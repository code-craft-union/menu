package top.yq59.menu.model.vo;

import java.util.List;

public class IngredientPaginationViewModel extends PaginationViewModel<IngredientPageViewModel> {
    public IngredientPaginationViewModel(List<IngredientPageViewModel> list, int currentPage, int pageSize, int total) {
        super(list, currentPage, pageSize, total);
    }
}
