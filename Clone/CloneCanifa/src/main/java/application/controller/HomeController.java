package application.controller;

import application.viewmodel.common.LogoVM;
import application.viewmodel.homecanifa.HomeCanifaVM;
import application.viewmodel.homecanifa.MenuItemVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 2/27/18.
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {
    @GetMapping(path = "/")
    public String index(Model model) {
        HomeCanifaVM vm = new HomeCanifaVM();

        LogoVM logo = new LogoVM("CANIFA", "", "CANIFA", "");

        ArrayList<MenuItemVM> listMenuTopItems = new ArrayList<>();
        listMenuTopItems.add(new MenuItemVM("Cửa hàng", "/"));
        listMenuTopItems.add(new MenuItemVM("KH thân thiết", "/"));
        listMenuTopItems.add(new MenuItemVM("Hỗ trợ", "/"));
        listMenuTopItems.add(new MenuItemVM("Tuyển dụng", "/"));
        listMenuTopItems.add(new MenuItemVM("Tài khoản", "/"));

        ArrayList<MenuItemVM> listHrMenuItems = new ArrayList<>();
        listHrMenuItems.add(new MenuItemVM("NAM", "/"));
        listHrMenuItems.add(new MenuItemVM("NỮ", "/"));
        listHrMenuItems.add(new MenuItemVM("BÉ TRAI", "/"));
        listHrMenuItems.add(new MenuItemVM("BÉ GÁI", "/"));
        listHrMenuItems.add(new MenuItemVM("NEW ARRIVALS", "/"));
        listHrMenuItems.add(new MenuItemVM("SALE", "/"));

        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("mega-menu0", ""));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("mega-menu1", ""));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("mega-menu2", ""));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("mega-menu3", ""));

        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Áo len", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Áo khoác (HOT)", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Áo sơ mi", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Áo kiểu", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Áo phông", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Quần jeans", "/"));
        listHrMenuItems.get(0).getChildren().get(0).getChildren().add(new MenuItemVM("Quần vải", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Quần khaki", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Quần shorts", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Trang phục đi làm", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Trang phục đi tập", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Đồ mặc nhà", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Đồ mặc trong", "/"));
        listHrMenuItems.get(0).getChildren().get(1).getChildren().add(new MenuItemVM("Phụ kiện", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("SẢN PHẨM MỚI", "/", "link-upper"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("SẢN PHẨM ĐẶC BIỆT", "/", "link-upper"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Trang phục tập luyện", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Len cashmere", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Giữ nhiệt", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Chống thấm nước", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("SP đạt chứng nhận an toàn", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Thoát ẩm vượt trội", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("Chống nắng", "/"));
        listHrMenuItems.get(0).getChildren().get(2).getChildren().add(new MenuItemVM("SALE", "/", "link-upper"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Celebration on Earth (New)", "/"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Be Active Be Cool", "/"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Sports Inspiration", "/"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Mickey", "/"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Color of nature - Sắc mộc", "/"));
        listHrMenuItems.get(0).getChildren().get(3).getChildren().add(new MenuItemVM("Urban Cool by Lê Hà", "/"));


        vm.setLogoVM(logo);
        vm.setListMenuTopItems(listMenuTopItems);
        vm.setListHrMenuItems(listHrMenuItems);

        model.addAttribute("vm", vm);

        return "home_canifa";
    }

}
