package top.yq59.menu.service.intf;

import org.springframework.format.annotation.DateTimeFormat;
import top.yq59.menu.constant.enums.DayMenuType;
import top.yq59.menu.model.dto.SetDailyCommand;
import top.yq59.menu.model.vo.DailyMenuViewModel;
import top.yq59.menu.model.vo.DailyViewModel;

import java.sql.Date;
import java.util.List;

public interface DailyService {
    /**
     * 设置指定日期的食谱
     * @param command
     */
    int setDaily(SetDailyCommand command);

    /**
     * 查询制定日期的食谱
     * @param date
     * @param dayMenuType
     * @return
     */
    List<DailyMenuViewModel> getDailyMenu(Date date, DayMenuType dayMenuType);
}
