package top.yq59.menu.model.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_material")
@Getter
public class Ingredient extends BaseEntity{
    /**
     * 食材名称
     */
    @Column(name = "Name",nullable = false)
    private String name;

    /**
     * 价格
     */
    @Column(name = "Price")
    private Float price;

    /**
     * 食材名称
     */
    @Column(name = "Remark")
    private String remark;

    @ManyToMany(targetEntity = Menu.class)
    private Set<Menu> menus = new HashSet<Menu>();

    public static Ingredient create(String name,Float price,String remark){
        Ingredient ingredient = new Ingredient();
        ingredient.name = name;
        ingredient.price = price;
        ingredient.remark = remark;
        return ingredient;
    }

    public void edit(String name,Float price,String remark){
        this.name = name;
        this.price = price;
        this.remark = remark;
    }
}
