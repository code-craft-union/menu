package top.yq59.menu.service.intf;

import org.springframework.stereotype.Service;
import top.yq59.menu.model.dto.AddMenuCommand;
import top.yq59.menu.model.dto.EditMenuCommand;
import top.yq59.menu.model.vo.MenuPaginationViewModel;
import top.yq59.menu.model.vo.MenuViewModel;

public interface MenuService {
    /**
     * 新增菜单
     * @param command
     * @return
     */
    int insert(AddMenuCommand command);

    /**
     * 编辑
     * @param command
     */
    void edit(EditMenuCommand command);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     * 分页查询
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    MenuPaginationViewModel getByPage(String name, int currentPage, int pageSize);

    /**
     * 查询菜单详细信息
     * @param id
     * @return
     */
    MenuViewModel getById(int id);
}
