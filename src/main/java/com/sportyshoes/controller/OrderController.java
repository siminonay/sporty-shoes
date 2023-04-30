package com.sportyshoes.controller;

import com.sportyshoes.model.Orders;
import com.sportyshoes.model.Product;
import com.sportyshoes.service.OrderService;
import com.sportyshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/placeOrder/{pid}")
    public String placeOrder(Model mm, @PathVariable("pid") int pid, HttpSession session, Orders o) {
        String mail = (String) session.getAttribute("email");
        o.setOdate(LocalDate.now());
        o.setOmail(mail);
        o.setProductid(pid);
        String result = orderService.saveOrder(o);
        productService.decrementQuantity(pid);
        List<Product> listOfProducts = productService.findAllProducts();
        mm.addAttribute("product", listOfProducts);
        mm.addAttribute("action", result);
        return "viewProducts";
    }

    @RequestMapping("/purchaseReports")
    public String viewProducts(Model model) {
        List<Orders> listOfOrders = orderService.findAllOrders();
        model.addAttribute("orders", listOfOrders);
        return "viewOrders";
    }

    @PostMapping("/searchPurchaseDate")
    public String searchPurchaseDate(@RequestParam("date") String date, Model model) {
        List<Orders> ordersList = orderService.getOrdersByDate(LocalDate.parse(date));
        if (ordersList.isEmpty()) {
            model.addAttribute("action", "No purchases on the selected date!");
            return "viewOrders";
        } else {
            model.addAttribute("searchHeading", "selected Date");
            model.addAttribute("orders", ordersList);
            return "viewOrders";
        }

    }
}
