package application.model;

/**
 * Created by hoangmanh on 3/27/18.
 */
public class FileUploadResult extends BaseApiResult {
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
