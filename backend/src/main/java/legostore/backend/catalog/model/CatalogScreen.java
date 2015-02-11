package legostore.backend.catalog.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 11..
 */
public class CatalogScreen implements Serializable {

    private List<CatalogProduct> productList;
    private String screenName;

    public CatalogScreen(String screenName, List<CatalogProduct> productList) {
        this.screenName = screenName;
        this.productList = productList;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<CatalogProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<CatalogProduct> productList) {
        this.productList = productList;
    }
}
