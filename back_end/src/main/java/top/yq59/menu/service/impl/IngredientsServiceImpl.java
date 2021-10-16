package top.yq59.menu.service.impl;

import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yq59.menu.model.dto.AddIngredientCommand;
import top.yq59.menu.model.dto.EditIngredientCommand;
import top.yq59.menu.model.entity.Ingredient;
import top.yq59.menu.model.vo.IngredientPageViewModel;
import top.yq59.menu.model.vo.IngredientPaginationViewModel;
import top.yq59.menu.repository.IngredientRepository;
import top.yq59.menu.service.intf.IngredientsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(AddIngredientCommand command) {
        Ingredient ingredient = Ingredient.create(command.getName(), command.getPrice(), command.getRemark());
        ingredientRepository.save(ingredient);
        return ingredient.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void edit(EditIngredientCommand command) {
        Ingredient ingredient = ingredientRepository.getById(command.getId());
        ingredient.edit(command.getName(), command.getPrice(), command.getRemark());
        ingredientRepository.save(ingredient);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(int id) {
        Ingredient ingredient = ingredientRepository.getById(id);
        ingredientRepository.delete(ingredient);
    }

    @Override
    public IngredientPaginationViewModel getByPage(String name, int currentPage, int pageSize) {
        currentPage = currentPage == 0 ? 1 : currentPage;
        pageSize = pageSize == 0 ? 1 : 10;
        Page<Ingredient> queryResult = ingredientRepository.findAll(PageRequest.of(currentPage-1,pageSize));
        List<IngredientPageViewModel> result = new ArrayList<>();
        queryResult.forEach(y ->{
            IngredientPageViewModel viewModel = new IngredientPageViewModel();
            BeanUtils.copyProperties(y,viewModel);
            result.add(viewModel);
        });
        return new IngredientPaginationViewModel(result,currentPage,pageSize,queryResult.getTotalPages());
    }
}
