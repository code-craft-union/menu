package top.yq59.menu.model.vo;

import lombok.Data;

@Data
public class DropDownViewModel {
    private String id;
    private String text;

    public DropDownViewModel(String id, String text) {
        this.id = id;
        this.text = text;
    }
}
