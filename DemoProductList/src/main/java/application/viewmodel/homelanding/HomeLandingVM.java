package application.viewmodel.homelanding;

import application.viewmodel.common.LayoutHeaderVM;
import application.viewmodel.common.ProductVM;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 3/26/18.
 */
public class HomeLandingVM extends LayoutHeaderVM {
    private ArrayList<MenuItemVM> listVtMenuItemsAside;
    private ArrayList<ProductVM> listHotProducts;
    private ArrayList<ProductVM> listTrendProducts;
    private ArrayList<BannerVM> listBanners;

    public ArrayList<BannerVM> getListBanners() {
        return listBanners;
    }

    public void setListBanners(ArrayList<BannerVM> listBanners) {
        this.listBanners = listBanners;
    }

    public ArrayList<ProductVM> getListTrendProducts() {
        return listTrendProducts;
    }

    public void setListTrendProducts(ArrayList<ProductVM> listTrendProducts) {
        this.listTrendProducts = listTrendProducts;
    }

    public ArrayList<ProductVM> getListHotProducts() {
        return listHotProducts;
    }

    public void setListHotProducts(ArrayList<ProductVM> listHotProducts) {
        this.listHotProducts = listHotProducts;
    }

    public ArrayList<MenuItemVM> getListVtMenuItemsAside() {
        return listVtMenuItemsAside;
    }

    public void setListVtMenuItemsAside(ArrayList<MenuItemVM> listVtMenuItemsAside) {
        this.listVtMenuItemsAside = listVtMenuItemsAside;
    }
}
