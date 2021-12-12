package top.yq59.menu.service.impl;

import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yq59.menu.constant.enums.DayMenuType;
import top.yq59.menu.model.dto.SetDailyCommand;
import top.yq59.menu.model.entity.Daily;
import top.yq59.menu.model.entity.Menu;
import top.yq59.menu.model.vo.DailyMenuViewModel;
import top.yq59.menu.model.vo.DailyViewModel;
import top.yq59.menu.model.vo.MenuViewModel;
import top.yq59.menu.repository.DailyRepository;
import top.yq59.menu.repository.MenuRepository;
import top.yq59.menu.service.intf.DailyService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DailyServiceImpl implements DailyService {
    private DailyRepository dailyRepository;
    private MenuRepository menuRepository;

    @Autowired
    public DailyServiceImpl(DailyRepository dailyRepository, MenuRepository menuRepository) {
        this.dailyRepository = dailyRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public int setDaily(SetDailyCommand command) {
        Set<Menu> menus = menuRepository.findAllByIdIn(command.getMenus());
        var menu = dailyRepository.findAllByDay(command.getDay());
        var daily = menu.stream().filter(y -> y.getDayMenuType() == command.getDayMenuType()).findFirst();
        Daily domain;
        if(daily.isPresent()){
            domain = daily.get();
            domain.edit(menus);
        }else {
            domain = Daily.create(command.getDay(),command.getDayMenuType(),menus);
        }
        dailyRepository.save(domain);
        return domain.getId();
    }

    @Override
    public List<DailyMenuViewModel> getDailyMenu(Date date, DayMenuType dayMenuType) {
        var menu = dailyRepository.findAllByDay(date);
        if(dayMenuType!=null){
            menu = menu.stream().filter(y -> y.getDayMenuType() == dayMenuType).collect(Collectors.toSet());
        }
        List<DailyMenuViewModel> result = new ArrayList<>();
        menu.forEach(y -> {
            var viewModel = new DailyMenuViewModel();
            BeanUtils.copyProperties(y,viewModel);
            var menuList = new ArrayList<MenuViewModel>();
            y.getMenus().forEach(x ->{
                var menuModel = new MenuViewModel();
                BeanUtils.copyProperties(x,menuModel);
                menuList.add(menuModel);
            });
            viewModel.setMenuList(menuList);
            result.add(viewModel);
        });
        return result;
    }
}
