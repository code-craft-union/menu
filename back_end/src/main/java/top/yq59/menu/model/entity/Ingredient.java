package top.yq59.menu.model.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food_material")
@Getter
public class Ingredient extends BaseEntity{
    /**
     * 食材名称
     */
    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Price")
    private Float price;
    /**
     * 食材名称
     */
    @Column(name = "Remark")
    private String remark;

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
