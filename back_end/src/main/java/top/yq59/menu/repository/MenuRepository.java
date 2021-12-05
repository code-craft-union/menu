package top.yq59.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.yq59.menu.model.entity.Ingredient;
import top.yq59.menu.model.entity.Menu;

import java.util.List;
import java.util.Set;

public interface MenuRepository extends JpaRepository<Menu,Integer>, JpaSpecificationExecutor<Menu> {
    Set<Menu> findAllByIdIn(List ids);
}
