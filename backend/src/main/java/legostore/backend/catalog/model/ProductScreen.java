package legostore.backend.catalog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 19..
 */
public class ProductScreen implements Serializable {

    private String productId;

    private String productName;

    private Integer salePrice;

    private List<ProductSKU> skuList = new ArrayList<ProductSKU>();

    public ProductScreen(String productId) {
        this.productId = productId;
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
}
