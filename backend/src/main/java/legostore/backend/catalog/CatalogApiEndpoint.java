package legostore.backend.catalog;

import legostore.backend.catalog.model.CatalogProduct;
import legostore.backend.catalog.model.CatalogScreen;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by chanwook on 2015. 2. 11..
 */
@RestController
public class CatalogApiEndpoint {
    @RequestMapping(value = "/catalog/theme", method = RequestMethod.GET)
    public CatalogScreen findTheme() {
        return new CatalogScreen("theme", getProductList());
    }

    private ArrayList<CatalogProduct> getProductList() {
        ArrayList<CatalogProduct> productList = new ArrayList<CatalogProduct>();
        productList.add(new CatalogProduct(1, "P001", "레고1", 1000L));
        productList.add(new CatalogProduct(2, "P002", "레고2", 2000L));
        productList.add(new CatalogProduct(3, "P003", "레고3", 3000L));
        return productList;
    }

}
