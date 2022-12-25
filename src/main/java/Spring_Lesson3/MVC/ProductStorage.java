package Spring_Lesson3.MVC;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductStorage {
    private List<Product> products = new ArrayList<>();

//    public void addProduct(String title, Double cost) {
//        products.add(new Product(title, cost));
//    }

    public Product getProductById(Long id) {
        for (Product p : products) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void saveProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
