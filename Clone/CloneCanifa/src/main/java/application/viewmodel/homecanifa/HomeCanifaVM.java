package application.viewmodel.homecanifa;

import application.viewmodel.common.LogoVM;
import application.viewmodel.common.ProductVM;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 2/27/18.
 */

public class HomeCanifaVM {

    private LogoVM logoVM;
    private ArrayList<MenuItemVM> listMenuTopItems;
    private ArrayList<MenuItemVM> listHrMenuItems;
    private ArrayList<MenuItemVM> listMenuItemsAside;
    private ArrayList<ProductVM> listMenProducts;
    private ArrayList<BannerVM> listImages;

    public LogoVM getLogoVM() {
        return logoVM;
    }

    public void setLogoVM(LogoVM logoVM) {
        this.logoVM = logoVM;
    }

    public ArrayList<MenuItemVM> getListMenuTopItems() {
        return listMenuTopItems;
    }

    public void setListMenuTopItems(ArrayList<MenuItemVM> listMenuTopItems) {
        this.listMenuTopItems = listMenuTopItems;
    }

    public ArrayList<MenuItemVM> getListHrMenuItems() {
        return listHrMenuItems;
    }

    public void setListHrMenuItems(ArrayList<MenuItemVM> listHrMenuItems) {
        this.listHrMenuItems = listHrMenuItems;
    }

    public ArrayList<MenuItemVM> getListMenuItemsAside() {
        return listMenuItemsAside;
    }

    public void setListMenuItemsAside(ArrayList<MenuItemVM> listMenuItemsAside) {
        this.listMenuItemsAside = listMenuItemsAside;
    }

    public ArrayList<ProductVM> getListMenProducts() {
        return listMenProducts;
    }

    public void setListMenProducts(ArrayList<ProductVM> listMenProducts) {
        this.listMenProducts = listMenProducts;
    }

    public ArrayList<BannerVM> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<BannerVM> listImages) {
        this.listImages = listImages;
    }
}
