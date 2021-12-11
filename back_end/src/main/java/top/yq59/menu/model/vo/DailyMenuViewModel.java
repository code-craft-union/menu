package top.yq59.menu.model.vo;

import lombok.Data;
import top.yq59.menu.constant.enums.DayMenuType;

import java.sql.Date;
import java.util.List;

@Data
public class DailyMenuViewModel {
    /**
     * 日期
     */
    private Date day;

    /**
     * 类型
     */
    private DayMenuType dayMenuType;

    List<MenuViewModel> menuList;
}
