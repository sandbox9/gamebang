package legostore.backend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by chanwook on 2015. 2. 11..
 */
@EnableAutoConfiguration
@ComponentScan
public class LegoStoreBackendApiApp {

    public static void main(String[] args) {
        SpringApplication.run(LegoStoreBackendApiApp.class, args);
    }
}
