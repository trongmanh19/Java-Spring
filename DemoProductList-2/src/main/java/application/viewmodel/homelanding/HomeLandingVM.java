package application.viewmodel.homelanding;

import application.viewmodel.common.LogoVM;

import java.util.ArrayList;

/**
 * Created by ManhNguyen on 1/17/18.
 */
public class HomeLandingVM {
    private LogoVM logo;
    private ArrayList<MenuItemVM> listHrMenuItems;

    public LogoVM getLogo() {
        return logo;
    }

    public void setLogo(LogoVM logo) {
        this.logo = logo;
    }

    public ArrayList<MenuItemVM> getListHrMenuItems() {
        return listHrMenuItems;
    }

    public void setListHrMenuItems(ArrayList<MenuItemVM> listHrMenuItems) {
        this.listHrMenuItems = listHrMenuItems;
    }
}