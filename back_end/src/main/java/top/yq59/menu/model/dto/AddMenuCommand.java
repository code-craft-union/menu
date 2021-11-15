package top.yq59.menu.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddMenuCommand {
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
     * 食材
     */
    private List<Integer> ingredients;
}
