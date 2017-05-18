package post.tyrone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import post.tyrone.domain.Product;
import post.tyrone.services.ProductService;

import java.util.List;

import static java.lang.String.format;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String index(Model model) {
        List<Product> products = productService.listAllProducts();
        model.addAttribute("products", products);
        return "products/index";
    }

    @RequestMapping("/product/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products/show";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products/productform";
    }

    @RequestMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products/productform";
    }


    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product saveProduct = productService.saveOrUpdateProduct(product);
        return format("redirect:/product/%s", saveProduct.getId());
    }

    @RequestMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
