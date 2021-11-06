package top.yq59.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.yq59.menu.model.entity.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientRepository  extends JpaRepository<Ingredient,Integer>, JpaSpecificationExecutor<Ingredient> {
    Set<Ingredient> findAllByIdIn(List ids);
}
