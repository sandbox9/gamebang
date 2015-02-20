package legostore.backend.catalog;

import legostore.backend.catalog.model.CatalogProduct;
import legostore.backend.catalog.model.CatalogScreen;
import legostore.backend.catalog.model.ProductDetailScreen;
import legostore.backend.catalog.model.ProductSKU;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by chanwook on 2015. 2. 11..
 */
@RestController
public class CatalogApiMockEndpoint {
    @RequestMapping(value = "/catalog/theme", method = RequestMethod.GET)
    public CatalogScreen findTheme() {
        return new CatalogScreen("theme", getProductList());
    }

    @RequestMapping(value = "/catalog/product/{productId}", method = RequestMethod.GET)
    public ProductDetailScreen getProductDetail(@PathVariable("productId") String productId) {
        ProductDetailScreen s = new ProductDetailScreen(productId);
        s.setProductName(productId + " 제품");
        s.setSalePrice(1000);
        createSKU(s);
        return s;
    }

    private void createSKU(ProductDetailScreen s) {
        s.addSku(new ProductSKU("SKU0001", "기본셑", 0, 100));
        s.addSku(new ProductSKU("SKU0002", "레고박스 추가", 1000, 100));
        s.addSku(new ProductSKU("SKU0003", "블락100피스 추가", 5000, 200));
    }

    private ArrayList<CatalogProduct> getProductList() {
        ArrayList<CatalogProduct> productList = new ArrayList<CatalogProduct>();
        productList.add(new CatalogProduct(1, "P001", "레고1", 1000L));
        productList.add(new CatalogProduct(2, "P002", "레고2", 2000L));
        productList.add(new CatalogProduct(3, "P003", "레고3", 3000L));
        return productList;
    }

}
