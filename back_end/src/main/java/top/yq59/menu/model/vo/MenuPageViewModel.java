package top.yq59.menu.model.vo;

import lombok.Data;

@Data
public class MenuPageViewModel {
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
}
