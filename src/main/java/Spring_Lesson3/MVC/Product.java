package Spring_Lesson3.MVC;

import lombok.Data;

import java.io.Serializable;
@Data
public class Product implements Serializable {
    private Long id;
    private String title;
    private Double cost;
    private static Long counter = 0L;

    public Product() {
        this.id = counter++;
    }

    public Product(String title, Double cost) {
        this.id = counter++;
        this.title = title;
        this.cost = cost;
    }
}
