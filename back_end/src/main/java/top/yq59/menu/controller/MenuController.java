package top.yq59.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yq59.menu.model.dto.AddMenuCommand;
import top.yq59.menu.model.dto.EditMenuCommand;
import top.yq59.menu.model.vo.MenuPaginationViewModel;
import top.yq59.menu.model.vo.MenuViewModel;
import top.yq59.menu.service.intf.MenuService;

@RestController
@RequestMapping(value = "/api/menu")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 新增菜单
     * @param command
     * @return
     */
    @PostMapping(value = "add")
    public int insert(@RequestBody AddMenuCommand command){
        return menuService.insert(command);
    }

    /**
     * 编辑菜单
     * @param command
     */
    @PostMapping(value = "edit")
    public void edit(@RequestBody EditMenuCommand command){
        menuService.edit(command);
    }

    /**
     * 删除菜单
     * @param id
     */
    @PostMapping(value = "remove/{id}")
    public void delete(@RequestParam int id){
        menuService.delete(id);
    }

    /**
     * 分页查询
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping(value = "getByPage")
    public MenuPaginationViewModel getByPage(String name, int currentPage,int pageSize){
        return menuService.getByPage(name,currentPage,pageSize);
    }

    /**
     * 查询详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "getById")
    public MenuViewModel getById(int id){
        return menuService.getById(id);
    }
}
