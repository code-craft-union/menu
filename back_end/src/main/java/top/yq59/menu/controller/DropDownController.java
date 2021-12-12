package top.yq59.menu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yq59.menu.constant.enums.DayMenuType;
import top.yq59.menu.model.vo.DropDownViewModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dropDown")
public class DropDownController {

    /**
     * 获取每日食谱类型下拉列表
     * @return
     */
    @GetMapping(value = "getDayMenuTypeList")
    public List<DropDownViewModel> getDayMenuTypeList(){
        return getEnumToList(DayMenuType.class);
    }


    public <T extends Enum<T>> List<DropDownViewModel> getEnumToList(Class<T> enumT){
        List<DropDownViewModel> result = new ArrayList();
        for (T a : enumT.getEnumConstants()){
            result.add(new DropDownViewModel(String.valueOf(a.ordinal()),a.toString()));
        }
        return result;
    }
}
