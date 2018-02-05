package application.controller;

import application.viewmodel.common.LogoVM;
import application.viewmodel.homerestaurant.HomeRestaurantVM;
import application.viewmodel.homerestaurant.ImgVM;
import application.viewmodel.homerestaurant.MenuItemVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 1/30/18.
 */

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @GetMapping(path = "/")
    public String restaurant(Model model) {
        HomeRestaurantVM vm = new HomeRestaurantVM();

        LogoVM logo = new LogoVM("LẨU ĐỆ NHẤT", "/img/Banner/banner.png",
                "LẨU ĐỆ NHẤT", "HOTNUM1");

        ArrayList<MenuItemVM> listHrMenuItems = new ArrayList<>();
        listHrMenuItems.add(new MenuItemVM("TRANG CHỦ", "/", true));
        listHrMenuItems.add(new MenuItemVM("SẢN PHẨM", "/", false));
        listHrMenuItems.add(new MenuItemVM("TIN TỨC", "/", false));
        listHrMenuItems.add(new MenuItemVM("BẢN ĐỒ", "/", false));
        listHrMenuItems.add(new MenuItemVM("LIÊN HỆ", "/", false));
        listHrMenuItems.add(new MenuItemVM("GIỚI THIỆU", "/", false));
        listHrMenuItems.add(new MenuItemVM("ĐẶT BÀN", "/", false));

        listHrMenuItems.get(1).getChildren().add(new MenuItemVM("Các Món Lẩu", "/"));
        listHrMenuItems.get(1).getChildren().add(new MenuItemVM("Nước uống", "/"));
        listHrMenuItems.get(1).getChildren().add(new MenuItemVM("Hải Sản", "/"));
        listHrMenuItems.get(1).getChildren().add(new MenuItemVM("Khai vị", "/"));

        ArrayList<MenuItemVM> listMenuItemsAside = new ArrayList<>();
        listMenuItemsAside.add(new MenuItemVM("Khai vị", "/"));
        listMenuItemsAside.add(new MenuItemVM("Hải sản", "/"));
        listMenuItemsAside.add(new MenuItemVM("Các món lẩu", "/"));
        listMenuItemsAside.add(new MenuItemVM("Rau", "/"));
        listMenuItemsAside.add(new MenuItemVM("Nước uống &amp; Đồ giải khát", "/"));

        listMenuItemsAside.get(4).getChildren().add(new MenuItemVM("Đồ uống nhẹ - Kem", "/"));
        listMenuItemsAside.get(4).getChildren().add(new MenuItemVM("Sinh tố", "/"));
        listMenuItemsAside.get(4).getChildren().add(new MenuItemVM("Nước ép", "/"));
        listMenuItemsAside.get(4).getChildren().add(new MenuItemVM("Bia", "/"));

        ArrayList<ImgVM> listBanners = new ArrayList<>();
        listBanners.add(new ImgVM("slider1", "/img/Slider/slider01.jpg"));
        listBanners.add(new ImgVM("slider2", "/img/Slider/slider02.jpg"));
        listBanners.add(new ImgVM("slider3", "/img/Slider/slider03.jpg"));

        vm.setLogoVM(logo);
        vm.setListHrMenuItems(listHrMenuItems);
        vm.setListMenuItemsAside(listMenuItemsAside);
        vm.setListImages(listBanners);

        model.addAttribute("vm", vm);
        return "homerestaurant";
    }
}
