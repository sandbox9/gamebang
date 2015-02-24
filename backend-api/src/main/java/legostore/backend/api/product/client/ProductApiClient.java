package legostore.backend.api.product.client;

import legostore.backend.api.product.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by chanwook on 2015. 2. 24..
 */
//TODO framework로...
public class ProductApiClient {

    public static final String SERVER = "http://localhost:10002/";
    final RestTemplate template = new RestTemplate();

    public List<Product> findProductByCategory(String categoryName) {
        return template.getForObject(SERVER + "products?categoryName=" + categoryName, List.class);
    }

    public Product getProduct(String productId) {
        return template.getForObject(SERVER + "products/" + productId, Product.class);
    }
}
