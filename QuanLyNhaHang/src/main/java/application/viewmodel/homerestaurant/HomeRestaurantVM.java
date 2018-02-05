package application.viewmodel.homerestaurant;

import application.viewmodel.common.LogoVM;
import application.viewmodel.common.ProductVM;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 1/30/18.
 */
public class HomeRestaurantVM {

    private LogoVM logoVM;
    private ArrayList<MenuItemVM> listHrMenuItems;
    private ArrayList<MenuItemVM> listMenuItemsAside;
    private ArrayList<ProductVM> listHotPotProducts;
    private ArrayList<ProductVM> listSpecialProducts;
    private ArrayList<ImgVM> listImages;

    public LogoVM getLogoVM() {
        return logoVM;
    }

    public void setLogoVM(LogoVM logoVM) {
        this.logoVM = logoVM;
    }

    public ArrayList<MenuItemVM> getListMenuItemsAside() {
        return listMenuItemsAside;
    }

    public void setListMenuItemsAside(ArrayList<MenuItemVM> listMenuItemsAside) {
        this.listMenuItemsAside = listMenuItemsAside;
    }

    public ArrayList<ProductVM> getListHotPotProducts() {
        return listHotPotProducts;
    }

    public void setListHotPotProducts(ArrayList<ProductVM> listHotPotProducts) {
        this.listHotPotProducts = listHotPotProducts;
    }

    public ArrayList<ProductVM> getListSpecialProducts() {
        return listSpecialProducts;
    }

    public void setListSpecialProducts(ArrayList<ProductVM> listSpecialProducts) {
        this.listSpecialProducts = listSpecialProducts;
    }

    public ArrayList<ImgVM> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<ImgVM> listImages) {
        this.listImages = listImages;
    }

    public ArrayList<MenuItemVM> getListHrMenuItems() {
        return listHrMenuItems;
    }

    public void setListHrMenuItems(ArrayList<MenuItemVM> listHrMenuItems) {
        this.listHrMenuItems = listHrMenuItems;
    }
}
