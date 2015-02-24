package legostore.backend.api.product.model;

import java.io.Serializable;

/**
 * Created by chanwook on 2015. 2. 20..
 */
public class ProductSKU implements Serializable {

    private String skuId;

    private String displayName;

    private Integer addPrice;

    private Integer stock;

    public ProductSKU() {
    }

    public ProductSKU(String skuId, String displayName, Integer addPrice, Integer stock) {
        this.skuId = skuId;
        this.displayName = displayName;
        this.addPrice = addPrice;
        this.stock = stock;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(Integer addPrice) {
        this.addPrice = addPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
