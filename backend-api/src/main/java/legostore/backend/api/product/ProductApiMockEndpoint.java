package legostore.backend.api.product;

import legostore.backend.api.product.model.Product;
import legostore.backend.api.product.model.ProductSKU;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chanwook on 2015. 2. 24..
 */
@RestController
public class ProductApiMockEndpoint {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> findProductList(@RequestParam(value = "categoryName", required = false) String categoryName) {
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(new Product("P001", "레고1", 1000));
        productList.add(new Product("P003", "레고3", 1000));
        productList.add(new Product("P004", "레고4", 1000));
        return productList;
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productId) {
        Product s = new Product(productId);
        s.setProductName(productId + " 제품");
        s.setSalePrice(1000);
        createSKU(s);
        return s;
    }

    private void createSKU(Product s) {
        s.addSku(new ProductSKU("SKU0001", "기본셑", 0, 100));
        s.addSku(new ProductSKU("SKU0002", "레고박스 추가", 1000, 100));
        s.addSku(new ProductSKU("SKU0003", "블락100피스 추가", 5000, 200));
    }

}