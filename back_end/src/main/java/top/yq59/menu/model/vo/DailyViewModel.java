package top.yq59.menu.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DailyViewModel {
    List<DailyMenuViewModel> dailyMenuViewModelList = new ArrayList<>();
}
