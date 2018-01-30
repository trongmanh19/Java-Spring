package application.viewmodel.homelanding;

/**
 * Created by ManhNguyen on 1/17/18.
 */
public class BannerVM {
    private String link;
    private String altText;
    private String imageUrl;

    public BannerVM(String link, String altText) {
        this.link = link;
        this.altText = altText;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
