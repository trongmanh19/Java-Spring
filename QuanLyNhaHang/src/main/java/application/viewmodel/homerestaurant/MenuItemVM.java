package application.viewmodel.homerestaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 1/30/18.
 */

public class MenuItemVM {
    private String text;
    private String link;
    private boolean flag;

    private List<MenuItemVM> children;

    public MenuItemVM(String text, String link) {
        this.text = text;
        this.link = link;
        children = new ArrayList<>();
    }

    public MenuItemVM(String text, String link, boolean flag) {
        this.text = text;
        this.link = link;
        this.flag = flag;
        children = new ArrayList<>();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<MenuItemVM> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItemVM> children) {
        this.children = children;
    }
}

