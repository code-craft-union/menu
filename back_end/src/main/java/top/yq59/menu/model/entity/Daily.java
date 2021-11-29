package top.yq59.menu.model.entity;

import lombok.Getter;
import top.yq59.menu.constant.enums.DayMenuType;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "daily")
@Getter
public class Daily extends BaseEntity{
    /**
     * 日期
     */
    @Column(name = "Day",nullable = false, columnDefinition = "date")
    private Date day;

    /**
     * 类型
     */
    @Column(name = "DayMenuType",nullable = false)
    private DayMenuType dayMenuType;

    /**
     * 关联食谱
     */
    @ManyToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
    @JoinTable(name = "daily_relation_menu",
            joinColumns = {@JoinColumn(name = "MenuId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name = "DayId", referencedColumnName = "Id")}
    )
    private Set<Ingredient> menus = new HashSet<Ingredient>();
}
