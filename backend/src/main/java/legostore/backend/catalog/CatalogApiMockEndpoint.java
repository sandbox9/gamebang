package legostore.backend.catalog;

import legostore.backend.catalog.model.CatalogProduct;
import legostore.backend.catalog.model.CatalogScreen;
import legostore.backend.catalog.model.ProductSKU;
import legostore.backend.catalog.model.ProductScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chanwook on 2015. 2. 11..
 */
@RestController
public class CatalogApiMockEndpoint {
    private final Logger logger = LoggerFactory.getLogger(CatalogApiMockEndpoint.class);

    @RequestMapping(value = "/catalog/theme", method = RequestMethod.GET)
    public CatalogScreen findTheme() {
        return new CatalogScreen("theme", getProductList());
    }

    //TODO Screen 개념과 데이터 모델 개념을 연결해서 생각.. 알고보니 {person:{..}} 식으로 주어야 하더라...-_-;
    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.GET)
    public Map getProductDetail(@PathVariable("productId") String productId) {
        ProductScreen s = new ProductScreen(productId);
        s.setProductName(productId + " 제품");
        s.setSalePrice(1000);
        createSKU(s);
        Map data = new HashMap();
        data.put("product", s);
        return data;
    }

    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.PUT)
    public void addToCart(@PathVariable("productId") String productId, @RequestBody Map model) {
        logger.info(model.toString());
    }

    private void createSKU(ProductScreen s) {
        s.addSku(new ProductSKU("SKU0001", "기본셑", 0, 100));
        s.addSku(new ProductSKU("SKU0002", "레고박스 추가", 1000, 100));
        s.addSku(new ProductSKU("SKU0003", "블락100피스 추가", 5000, 200));
    }

    private ArrayList<CatalogProduct> getProductList() {
        ArrayList<CatalogProduct> productList = new ArrayList<CatalogProduct>();
        productList.add(new CatalogProduct("P001", "레고1", 1000L));
        productList.add(new CatalogProduct("P002", "레고2", 2000L));
        productList.add(new CatalogProduct("P003", "레고3", 3000L));
        return productList;
    }

}
