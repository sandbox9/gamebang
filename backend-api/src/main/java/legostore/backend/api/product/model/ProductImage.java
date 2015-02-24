package legostore.backend.api.product.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2015. 2. 24..
 */
public class ProductImage implements Serializable {

    private String imageUrl;

    private int displayOrder;

    //TODO 사이즈 등등등

    public ProductImage() {
    }

    public ProductImage(String imageUrl, int displayOrder) {
        this.imageUrl = imageUrl;
        this.displayOrder = displayOrder;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
