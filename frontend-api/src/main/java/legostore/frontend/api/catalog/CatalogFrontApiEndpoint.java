package legostore.frontend.api.catalog;

import legostore.backend.api.product.client.ProductApiClient;
import legostore.backend.api.product.model.Product;
import legostore.framework.web.EmberModel;
import legostore.frontend.api.catalog.model.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.GET)
    public EmberModel getProductDetail(@PathVariable("productId") String productId) {
        Product s = client.getProduct(productId);
        EmberModel em = new EmberModel();
        em.put("product", s);
        return em;
    }

    @RequestMapping(value = "/catalog/products/{productId}", method = RequestMethod.PUT)
    public void addToCart(@PathVariable("productId") String productId,
                          @RequestBody EmberModel em) {
        logger.info("Model Map: " + em.toString());
        Product product = em.get("product", Product.class);
        logger.info("Product: " + product.toString());

        //TODO 개발~
    }
}
