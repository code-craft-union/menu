package top.yq59.menu.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import top.yq59.menu.constant.enums.DayMenuType;

import java.sql.Date;
import java.util.List;

@Data
public class SetDailyCommand {
    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day;

    /**
     * 类型
     */
    private DayMenuType dayMenuType;

    /**
     * 菜谱
     */
    private List<Integer> menus;
}
