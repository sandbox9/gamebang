package legostore.frontend.api.catalog;

import legostore.backend.api.product.client.ProductApiClient;
import legostore.backend.api.product.model.Product;
import legostore.frontend.api.catalog.model.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chanwook on 2015. 2. 11..
 */
@RestController
public class CatalogFrontApiEndpoint {

    private final Logger logger = LoggerFactory.getLogger(CatalogFrontApiEndpoint.class);

    public static final String THEME = "theme";

    private ProductApiClient client = new ProductApiClient();

    @RequestMapping(value = "/catalog/theme", method = RequestMethod.GET)
    public Catalog findTheme() {
        Catalog catalog = new Catalog(THEME, client.findProductByCategory(THEME));
        return catalog;
    }

    //TODO Screen 개념과 데이터 모델 개념을 연결해서 생각.. 알고보니 {person:{..}} 식으로 주어야 하더라...-_-;
    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.GET)
    public Map getProductDetail(@PathVariable("productId") String productId) {
        Product s = client.getProduct(productId);
        Map data = new HashMap();
        data.put("product", s);
        return data;
    }

    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.PUT)
    public void addToCart(@PathVariable("productId") String productId, @RequestBody Map model) {
        logger.info(model.toString());
        //TODO 개발~
    }


}
