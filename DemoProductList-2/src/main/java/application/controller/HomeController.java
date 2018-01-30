package application.controller;

import application.data.model.Product;
import application.data.service.ProductService;
import application.viewmodel.homelanding.HomeLandingVM;
import application.viewmodel.common.LogoVM;
import application.viewmodel.homelanding.MenuItemVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by ManhNguyen on 10/11/17.
 */

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    private ProductService productService;

    private String[] images = {
            "https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg"
    };

    //@GetMapping(path="admin")
    @RequestMapping(path = "admin", method = RequestMethod.GET)
    public String admin(Model model) {

        long totalProducts = productService.getTotalProducts();
        if (totalProducts <= 0) {
            ArrayList<Product> listProducts = new ArrayList<>();
            Random random = new Random();

            for (int i = 1; i <= 100; ++i) {
                Product p = new Product();
                p.setCreatedDate(new Date());
                p.setName("Product " + i);
                p.setShortDesc("Description for product " + i);
                p.setImage(images[random.nextInt(images.length)]);
                listProducts.add(p);
            }

            productService.addNewListProducts(listProducts);
            model.addAttribute("message", "Total added products: " + listProducts.size());
        } else {
            model.addAttribute("message", "Total existed products: " + totalProducts);
        }

        return "admin";
    }

    @GetMapping(path = "/")
    public String index(Model model,
                        @RequestParam(value = "pageSize", required = false) String ps,
                        @RequestParam(value = "pageNumber", required = false) String pn) {

        try {
            int pageSize = Integer.parseInt(ps);
            int pageNumber = Integer.parseInt(pn);
            if (pageSize > 0 && pageNumber >= 0) {
                model.addAttribute("paginableItem", productService.getListProducts(pageSize, pageNumber));
            } else {
                model.addAttribute("paginableItem", productService.getListProducts(10, 0));
            }
        } catch (Exception ex) {
            model.addAttribute("paginableItem", productService.getListProducts(10, 0));
        }

        return "index";
    }

    @GetMapping(path = "landing")
    public String landing(Model model) {
        HomeLandingVM vm = new HomeLandingVM();

        LogoVM logo = new LogoVM("SpringMVC",
                "/img/logo.png", "SpringMVC", "SMVC");

        ArrayList<MenuItemVM> listHrMenuItems = new ArrayList<>();
        listHrMenuItems.add(new MenuItemVM("Menu 01", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 02", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 03", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 04", "/"));

        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 01", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 02", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 03", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 04", "/"));

        vm.setLogo(logo);
        vm.setListHrMenuItems(listHrMenuItems);

        model.addAttribute("vm", vm);
        return "homelanding";
    }

    @GetMapping(path = "restaurant")
    public String restaurant(Model model) {
        return "homerestaurant";
    }
}
