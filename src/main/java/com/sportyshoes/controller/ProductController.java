package com.sportyshoes.controller;

import com.sportyshoes.model.Category;
import com.sportyshoes.model.Product;
import com.sportyshoes.service.CategoryService;
import com.sportyshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/addProductPage",method = RequestMethod.GET)
    public String openAddProductPage(Model model, Product product) {
        model.addAttribute("product", product);
        List<Category> listOfCategory = categoryService.findAllCategory();
        model.addAttribute("category", listOfCategory);
        return "addProduct";
    }

    @RequestMapping(value = "/storeProductInfo",method = RequestMethod.POST)
    public String storeProductData(Model mm,Product pp) {
        String result = productService.storeProduct(pp);
        mm.addAttribute("product", pp);
        mm.addAttribute("action", result);
        List<Category> listOfCategory = categoryService.findAllCategory();
        mm.addAttribute("category",listOfCategory);
        System.out.println(pp);
        return "addProduct";
    }

    @RequestMapping("/viewProductsPage")
    public String viewProducts(Model model, Product pp) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("product", productList);
        return "viewProducts";
    }

    @RequestMapping(value = "/deleteProduct/{pid}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("pid") int pid, Model mm) {
        String result = productService.deleteProduct(pid);
        mm.addAttribute("action", result);
        List<Product> listOfProducts = productService.findAllProducts();
        mm.addAttribute("product", listOfProducts);
        return "viewProducts";
    }

}
