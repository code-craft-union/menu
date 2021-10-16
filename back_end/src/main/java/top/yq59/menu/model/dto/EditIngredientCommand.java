package top.yq59.menu.model.dto;

import lombok.Data;

@Data
public class EditIngredientCommand {
    private int id;

    /**
     * 食材名称
     */
    private String name;

    /**
     * 价格
     */
    private Float price;

    /**
     * 备注说明
     */
    private String remark;
}
