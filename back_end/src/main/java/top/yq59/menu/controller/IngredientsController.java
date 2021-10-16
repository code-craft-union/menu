package top.yq59.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yq59.menu.model.dto.AddIngredientCommand;
import top.yq59.menu.model.dto.EditIngredientCommand;
import top.yq59.menu.model.vo.IngredientPaginationViewModel;
import top.yq59.menu.service.intf.IngredientsService;

@RestController
@RequestMapping(value = "/api/ingredients")
public class IngredientsController {

    private IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping(value = "test")
    public String test(){
        return "Hello Word";
    }

    /**
     * 新增食材
     * @param command
     * @return
     */
    @PostMapping(value = "add")
    public int insert(@RequestBody AddIngredientCommand command){
        return ingredientsService.insert(command);
    }

    /**
     * 编辑食材
     * @param command
     */
    @PostMapping(value = "edit")
    public void edit(@RequestBody EditIngredientCommand command){
        ingredientsService.edit(command);
    }

    /**
     * 删除
     * @param id
     */
    @PostMapping(value = "remove/{id}")
    public void remove(@RequestParam int id){
        ingredientsService.remove(id);
    }

    /**
     * 分页查询
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping(value = "getByPage")
    public IngredientPaginationViewModel getByPage(String name, int currentPage,int pageSize){
        return ingredientsService.getByPage(name,currentPage,pageSize);
    }
}
