package application.controller.web;

import application.viewmodel.productindex.ProductIndexVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hoangmanh on 3/27/18.
 */
@Controller
@RequestMapping(path="/product")
public class ProductController extends BaseController {

    @GetMapping("/index")
    public String index(Model model) {

        ProductIndexVM vm = new ProductIndexVM();

        this.setLayoutHeaderVM(vm);

        model.addAttribute("vm", vm);

        return "product/index";
    }

}
