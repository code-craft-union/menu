package top.yq59.menu.model.vo;

import java.util.List;

public class MenuPaginationViewModel extends PaginationViewModel<MenuPageViewModel> {
    public MenuPaginationViewModel(List<MenuPageViewModel> list, int currentPage, int pageSize, int total) {
        super(list, currentPage, pageSize, total);
    }
}
