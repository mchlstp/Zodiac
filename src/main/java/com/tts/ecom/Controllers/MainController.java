package com.tts.ecom.Controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.ecom.Models.Product;
import com.tts.ecom.Services.ProductService;

@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
                  // controllers, for the navbar.
public class MainController {
    @Autowired
    ProductService productService;

    // public Product(int quantity, float price, String description,
    // String name, String brand, String category,String image) {

    public void addNew() {
        List<Product> allProducts = productService.findAll();

        if (allProducts.isEmpty()) {

            List<Product> newProducts = new ArrayList<Product>();

            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Aries",
                    "images/Aries.png","Aries"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Taurus",
                    "images/Taurus.png","Taurus"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Gemini",
                    "images/Gemini.png","Gemini"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Cancer",
                    "images/Cancer.png","Cancer"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Leo",
                    "images/Leo.png","Leo"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Virgo",
                    "images/Virgo.png","Virgo"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Libra",
                    "images/Libra.png","Libra"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Scorpio",
                    "images/Scorpio.png","Scorpio"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Sagittarius",
                    "images/Sagittarius.png","Sagittarius"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Capricorn",
                    "images/Capricorn.png","Capricorn"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Aquarius",
                    "images/Aquarius.png","Aquarius"));
            
            newProducts.add(new Product(4, (float) 3.99, "Aries Avatar", "Pisces",
                    "images/Pisces.png","Pisces"));

        

            for (Product product : newProducts) {
                productService.save(product);
            }
        } else {

            System.out.println("You don't need more items!");
        }
   }

    @GetMapping("/")
    public String main() {
        addNew();
        return "main";
    }

    @ModelAttribute("products")
    public List<Product> products() {
        return productService.findAll();
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        return productService.findDistinctCategories();
    }

    @ModelAttribute("sign")
    public List<String> sign() {
        return productService.findDistinctSign();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String category, @RequestParam(required = false) String sign,
            Model model) {
        List<Product> filtered = productService.findBySignAndOrCategory(sign, category);
        model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
        return "main";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}