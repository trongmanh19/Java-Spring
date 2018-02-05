package application.viewmodel.common;

/**
 * Created by hoangmanh on 1/31/18.
 */
public class ProductVM {
    private int id;
    private String name;
    private String image;
    private String shortDesc;
    private int price_sell;
    private int price_sale;

    public ProductVM(int id, String name, String image, String shortDesc, int price_sell, int price_sale) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.shortDesc = shortDesc;
        this.price_sell = price_sell;
        this.price_sale = price_sale;
    }

    public int getId() {
        return id;
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

    public int getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(int price_sell) {
        this.price_sell = price_sell;
    }

    public int getPrice_sale() {
        return price_sale;
    }

    public void setPrice_sale(int price_sale) {
        this.price_sale = price_sale;
    }
}
