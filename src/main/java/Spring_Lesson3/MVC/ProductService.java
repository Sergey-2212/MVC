package Spring_Lesson3.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/storage")
public class ProductService {
    private ProductStorage storage;
    @Autowired
    public void setStorage(ProductStorage storage) {
        this.storage = storage;
    }

    @GetMapping("/all")
    public String getAllStorage(Model model) {
        model.addAttribute("storage", storage.getProducts());
        return "shows_storage.html";

    }
    @GetMapping("/form")
    public String getProductForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "new_product.html";
    }
    @PostMapping("/form")
    public String createProduct(@ModelAttribute Product product) {
        storage.saveProduct(product);
        return "new_product.html";
    }
    @GetMapping("/new")
    public String createPrForm() {

        System.out.println("/new");
        return "create_product.html";
    }

    @GetMapping("/pr_add")
    @ResponseBody
    public String addProduct(@RequestParam String title, @RequestParam Double cost) {
        System.out.println("/pr_add");
        Product pr = new Product(title, cost);
        System.out.println(pr);
        storage.saveProduct(pr);
       return "Добавлен продукт: " + "\n" + pr;
    }

}
