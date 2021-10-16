package top.yq59.menu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import top.yq59.menu.model.entity.Ingredient;

import java.awt.print.Pageable;

public interface IngredientRepository  extends JpaRepository<Ingredient,Integer> {
//    Page<Ingredient> findAll(Pageable pageable);
}
