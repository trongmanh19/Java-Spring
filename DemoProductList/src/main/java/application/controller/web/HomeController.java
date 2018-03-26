package application.controller.web;

import application.data.model.PaginableItemList;
import application.data.model.Product;
import application.data.service.ProductService;
import application.viewmodel.common.ProductVM;
import application.viewmodel.homelanding.BannerVM;
import application.viewmodel.homelanding.HomeLandingVM;
import application.viewmodel.homelanding.MenuItemVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by hoangmanh on 3/26/18.
 */
@Controller
@RequestMapping(path = "/")
public class HomeController extends BaseController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "admin")
//    @RequestMapping(path = "admin", method = RequestMethod.GET)
    public String admin(Model model) {
        long totalProducts = productService.getTotalProducts();
        model.addAttribute("message", "Total existed products: " + totalProducts);
        return "admin";
    }

    @GetMapping(path="/list-products")
    public String index(Model model,
                        @RequestParam(value="pageSize", required=false)
                                String ps,
                        @RequestParam(value="pageNumber", required=false)
                                String pn){

        try {
            int pageSize = Integer.parseInt(ps);
            int pageNumber = Integer.parseInt(pn);
            if(pageSize > 0 && pageNumber >= 0) {
                model.addAttribute("paginableItem",
                        productService.getListProducts(pageSize, pageNumber));
            } else {
                model.addAttribute("paginableItem",
                        productService.getListProducts(10, 0));
            }
        } catch (Exception ex) {
            model.addAttribute("paginableItem",
                    productService.getListProducts(10, 0));
        }

        return "list_product";
    }

    @GetMapping(path="/")
    public String landing(Model model) {
        HomeLandingVM vm = new HomeLandingVM();

        this.setLayoutHeaderVM(vm);

        ArrayList<BannerVM> listBanners = new ArrayList<>();
        listBanners.add(new BannerVM("https://www.w3schools.com/bootstrap/la.jpg", "Los Angeles"));
        listBanners.add(new BannerVM("https://www.w3schools.com/bootstrap/chicago.jpg", "Chicago"));
        listBanners.add(new BannerVM("https://www.w3schools.com/bootstrap/ny.jpg", "New York"));

        ArrayList<MenuItemVM> listVtMenuItems = new ArrayList<>();
        listVtMenuItems.add(new MenuItemVM("Menu aside 01", "/"));
        listVtMenuItems.add(new MenuItemVM("Menu aside 02", "/"));
        listVtMenuItems.add(new MenuItemVM("Menu aside 03", "/"));
        listVtMenuItems.add(new MenuItemVM("Menu aside 04", "/"));
        listVtMenuItems.add(new MenuItemVM("Menu aside 05", "/"));

        PaginableItemList<Product> paginableItemListHot = productService.getListProducts(8, 0);
        ArrayList<ProductVM> listHotProductVMs = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Product product : paginableItemListHot.getListData()) {
            ProductVM productVM = modelMapper.map(product, ProductVM.class);
            listHotProductVMs.add(productVM);
        }

        PaginableItemList<Product> paginableItemListTrend = productService.getListProducts(8, 1);
        ArrayList<ProductVM> listTrendProductVMs = new ArrayList<>();
        for(Product product : paginableItemListTrend.getListData()) {
            ProductVM productVM = modelMapper.map(product, ProductVM.class);
            listTrendProductVMs.add(productVM);
        }

        vm.setListBanners(listBanners);
        vm.setListVtMenuItemsAside(listVtMenuItems);
        vm.setListHotProducts(listHotProductVMs);
        vm.setListTrendProducts(listTrendProductVMs);

        model.addAttribute("vm", vm);
        return "index";
    }


}
