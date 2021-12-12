package top.yq59.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yq59.menu.constant.enums.DayMenuType;
import top.yq59.menu.model.dto.SetDailyCommand;
import top.yq59.menu.model.vo.DailyMenuViewModel;
import top.yq59.menu.model.vo.DailyViewModel;
import top.yq59.menu.service.intf.DailyService;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping(value = "/api/daily")
public class DailyController {
    private DailyService dailyService;

    @Autowired
    public DailyController(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    /**
     * 设置指定日期的食谱
     * @param command
     */
    @PostMapping(value = "setDaily")
    public int setDaily(@RequestBody SetDailyCommand command){
        return dailyService.setDaily(command);
    }

    /**
     * 获取指定日期下来列表
     * @param command
     * @return
     */
    @PostMapping(value = "getDailyMenu")
    public List<DailyMenuViewModel> getDailyMenu(@RequestBody SetDailyCommand command){
        return dailyService.getDailyMenu(command.getDay(),command.getDayMenuType());
    }
}
