package legostore.backend.api.product;

import legostore.backend.api.product.model.Product;
import legostore.backend.api.product.model.ProductImage;
import legostore.backend.api.product.model.ProductSKU;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 24..
 */
@RestController
public class ProductApiMockEndpoint {

    private static final String SAMPLE_IMAGE_URL = "http://cache.lego.com/r/www/-/media/portal/main/recommendations/bionicle/mainstage/bionicle_feature.jpg?l.r2=912112809";

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> findProductList(@RequestParam(value = "categoryName", required = false) String categoryName) {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("P001", "레고1", 1000).addImage(getSampleImage()));
        productList.add(new Product("P002", "레고3", 3000).addImage(getSampleImage()));
        productList.add(new Product("P005", "레고5", 5000).addImage(getSampleImage()));
        return productList;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productId) {
        Product s = new Product(productId, productId + " 제품", 1000);
        s.addImage(getSampleImage());
        createSKU(s);
        return s;
    }

    private ProductImage getSampleImage() {
        return new ProductImage(SAMPLE_IMAGE_URL, 0);
    }

    private void createSKU(Product s) {
        s.addSku(new ProductSKU("SKU0001", "기본셑", 0, 100));
        s.addSku(new ProductSKU("SKU0002", "레고박스 추가", 1000, 100));
        s.addSku(new ProductSKU("SKU0003", "블락100피스 추가", 5000, 200));
    }

}