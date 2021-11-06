package top.yq59.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.yq59.menu.model.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu,Integer>, JpaSpecificationExecutor<Menu> {
}
