package application.viewmodel.homecanifa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 2/27/18.
 */

public class MenuItemVM {

    private String text;
    private String link;
    private String descClass;

    private List<MenuItemVM> children;

    public MenuItemVM(String text, String link) {
        this.text = text;
        this.link = link;
        children = new ArrayList<>();
    }

    public MenuItemVM(String text, String link, String descClass) {
        this.text = text;
        this.link = link;
        this.descClass = descClass;
        children = new ArrayList<>();
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

    public String getDescClass() {
        return descClass;
    }

    public void setDescClass(String descClass) {
        this.descClass = descClass;
    }

    public List<MenuItemVM> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItemVM> children) {
        this.children = children;
    }
}
