package top.yq59.menu.model.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@Getter
public class Menu extends BaseEntity {
    /**
     * 菜谱
     */
    @Column(name = "Name",nullable = false)
    private String name;

    /**
     * 链接
     */
    @Column(name = "Link")
    private String link;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 关联食材
     */
    @ManyToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_relation_meterial",
            joinColumns = {@JoinColumn(name = "FoodMateriaId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "MenuId", referencedColumnName = "Id")}
    )
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    /**
     * 关联每日食谱
     */
    @ManyToMany(mappedBy="menus")
    private Set<Daily> dailys = new HashSet<Daily>();

    public static Menu create(String name, String link, String remark, Set<Ingredient> ingredients) {
        Menu menu = new Menu();
        menu.name = name;
        menu.link = link;
        menu.remark = remark;
        menu.ingredients = ingredients;
        return menu;
    }

    public void edit(String name, String link, String remark, Set<Ingredient> ingredients){
        this.name = name;
        this.link = link;
        this.remark = remark;
        this.ingredients = ingredients;
    }
}
