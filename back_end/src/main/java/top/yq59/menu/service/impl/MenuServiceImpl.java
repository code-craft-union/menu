package top.yq59.menu.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yq59.menu.model.dto.AddMenuCommand;
import top.yq59.menu.model.dto.EditMenuCommand;
import top.yq59.menu.model.entity.Ingredient;
import top.yq59.menu.model.entity.Menu;
import top.yq59.menu.model.vo.*;
import top.yq59.menu.repository.IngredientRepository;
import top.yq59.menu.repository.MenuRepository;
import top.yq59.menu.service.intf.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, IngredientRepository ingredientRepository) {
        this.menuRepository = menuRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(AddMenuCommand command) {
        Set<Ingredient> a = ingredientRepository.findAllByIdIn(command.getIngredients());
        Menu menu = Menu.create(command.getName(), command.getLink(), command.getRemark(),a);
        menuRepository.save(menu);
        return menu.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(EditMenuCommand command) {
        Menu menu = menuRepository.getById(command.getId());
        menu.edit(command.getName(), command.getLink(), command.getRemark());
        menuRepository.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(int id) {
        Menu menu = menuRepository.getById(id);
        menuRepository.delete(menu);
    }

    @Override
    public MenuPaginationViewModel getByPage(String name, int currentPage, int pageSize) {
        currentPage = currentPage == 0 ? 1 : currentPage;
        pageSize = pageSize == 0 ? 1 : 10;
        //构造查询条件
        Page<Menu> queryResult;
        if(name !=null && !name.trim().equals("")){
            Specification<Menu> spec = (root, query, cb) -> cb.like(root.get("name").as(String.class), "%"+ name +"%");
            queryResult = menuRepository.findAll(spec, PageRequest.of(currentPage-1,pageSize));
        }else {
            queryResult = menuRepository.findAll(PageRequest.of(currentPage-1,pageSize));
        }
        List<MenuPageViewModel> result = new ArrayList<>();
        queryResult.forEach(y ->{
            MenuPageViewModel viewModel = new MenuPageViewModel();
            BeanUtils.copyProperties(y,viewModel);
            result.add(viewModel);
        });
        return new MenuPaginationViewModel(result,currentPage,pageSize,queryResult.getTotalPages());
    }

    @Override
    public MenuViewModel getById(int id) {
        Menu menu = menuRepository.getById(id);
        MenuViewModel menuViewModel = new MenuViewModel();
        menuViewModel.setId(menuViewModel.getId());
        menuViewModel.setName(menuViewModel.getName());
        menuViewModel.setLink(menuViewModel.getLink());
        menuViewModel.setRemark(menuViewModel.getRemark());
        menuViewModel.setIngredients(menu.getIngredients().stream().map(y -> new IngredientViewModel(y.getId(),y.getName(),y.getPrice(), y.getRemark()))
                .collect(Collectors.toList()));
        return menuViewModel;
    }
}
