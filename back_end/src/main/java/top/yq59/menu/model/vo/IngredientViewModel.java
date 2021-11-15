package top.yq59.menu.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientViewModel {
    private int id;
    private String name;
    private Float price;
    private String remark;
}
