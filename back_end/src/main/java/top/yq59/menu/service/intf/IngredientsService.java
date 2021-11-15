package top.yq59.menu.service.intf;

import top.yq59.menu.model.dto.AddIngredientCommand;
import top.yq59.menu.model.dto.EditIngredientCommand;
import top.yq59.menu.model.vo.IngredientPaginationViewModel;
import top.yq59.menu.model.vo.IngredientViewModel;

public interface IngredientsService {
    /**
     * 新增食材
     * @param command
     * @return
     */
    int insert(AddIngredientCommand command);

    /**
     * 编辑食材
     * @param command
     */
    void edit(EditIngredientCommand command);

    /**
     * 删除
     * @param id
     */
    void remove(int id);

    /**
     * 分页查询
     * @param name
     * @return
     */
    IngredientPaginationViewModel getByPage(String name, int currentPage,int pageSize);

    /**
     * 查询详细
     * @param id
     * @return
     */
    IngredientViewModel getById(int id);
}
