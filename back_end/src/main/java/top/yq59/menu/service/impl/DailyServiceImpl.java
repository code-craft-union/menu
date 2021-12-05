package top.yq59.menu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yq59.menu.constant.enums.DayMenuType;
import top.yq59.menu.model.dto.SetDailyCommand;
import top.yq59.menu.model.entity.Daily;
import top.yq59.menu.model.entity.Ingredient;
import top.yq59.menu.model.entity.Menu;
import top.yq59.menu.model.vo.DailyViewModel;
import top.yq59.menu.repository.DailyRepository;
import top.yq59.menu.repository.MenuRepository;
import top.yq59.menu.service.intf.DailyService;

import java.util.Date;
import java.util.Set;

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
        Set<Menu> a = menuRepository.findAllByIdIn(command.getMenus());
        Daily daily = Daily.create(command.getDay(),command.getDayMenuType(),a);
        dailyRepository.save(daily);
        return daily.getId();
    }

    @Override
    public DailyViewModel getDailyMenu(Date date, DayMenuType dayMenuType) {
        return null;
    }
}
