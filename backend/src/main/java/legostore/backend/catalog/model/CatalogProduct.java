package legostore.backend.catalog.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2015. 2. 11..
 */
public class CatalogProduct implements Serializable {
    private String productId;
    private String productName;
    private long salePrice;

    public CatalogProduct() {

    }

    public CatalogProduct(String productId, String productName, long salePrice) {
        this.productId = productId;
        this.productName = productName;
        this.salePrice = salePrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }
}
