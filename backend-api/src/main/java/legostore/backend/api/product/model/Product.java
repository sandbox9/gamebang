package legostore.backend.api.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 19..
 */
public class Product implements Serializable {

    private String productId;

    private String productName;

    private Integer salePrice;

    private List<ProductImage> imageList = new ArrayList<ProductImage>();

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<ProductSKU> skuList = new ArrayList<ProductSKU>();

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
    }

    public Product(String productId, String productName, Integer salePrice) {
        this.productId = productId;
        this.productName = productName;
        this.salePrice = salePrice;
    }


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public List<ProductSKU> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<ProductSKU> skuList) {
        this.skuList = skuList;
    }

    public void addSku(ProductSKU sku) {
        this.skuList.add(sku);
    }

    public Product addImage(ProductImage image) {
        this.imageList.add(image);
        return this;
    }

    public List<ProductImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ProductImage> imageList) {
        this.imageList = imageList;
    }
}
