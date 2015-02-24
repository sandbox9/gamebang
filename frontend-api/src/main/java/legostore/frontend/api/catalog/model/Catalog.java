package legostore.frontend.api.catalog.model;

import legostore.backend.api.product.model.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 11..
 */
public class Catalog implements Serializable {

    private final String categoryName;
    private List<Product> productList;

    public Catalog(String categoryName, List<Product> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
