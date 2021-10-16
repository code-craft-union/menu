package top.yq59.menu.model.vo;

import java.util.List;

public class PaginationViewModel<T> {
    private List<T> list;
    private Pagination pagination;

    public PaginationViewModel(List<T> list, int currentPage, int pageSize,int total) {
        this.list = list;
        this.pagination = new Pagination(currentPage, pageSize, total);
    }
}
