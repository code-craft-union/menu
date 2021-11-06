package top.yq59.menu.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuViewModel {
    private int id;
    /**
     * 菜谱
     */
    private String name;

    /**
     * 链接
     */
    private String link;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联食材
     */
    private List<IngredientViewModel> ingredients = new ArrayList<>();
}
