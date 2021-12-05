package top.yq59.menu.model.vo;

import lombok.Data;
import top.yq59.menu.model.entity.Menu;

import java.util.List;

@Data
public class DailyMenuViewModel {
    List<MenuViewModel> menuList;
}
