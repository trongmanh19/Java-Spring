package application.viewmodel.common;

import application.model.CategoryDataModel;

/**
 * Created by hoangmanh on 3/26/18.
 */
public class ProductVM {
    private int id;
    private String name;
    private String image;
    private String shortDesc;

    private CategoryDataModel category;

    public int getId() {
        return id;
    }

    public CategoryDataModel getCategory() {
        return category;
    }

    public void setCategory(CategoryDataModel category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
