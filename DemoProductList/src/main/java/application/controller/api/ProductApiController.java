package application.controller.api;

import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by hoangmanh on 3/27/18.
 */
@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    private String[] images = {
            "https://images-na.ssl-images-amazon.com/images/I/519rVW4jTIL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/51JJ0e-i2yL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/517Q0wwZUXL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41odx4vtkyL._SL500_SS135_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41KCisxFTwL._SL500_SS135_.jpg"
    };

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create-product")
    public BaseApiResult createProduct(@RequestBody ProductDataModel product) {
        BaseApiResult result = new BaseApiResult();

        try {
            if (!"".equals(product.getName()) && !"".equals(product.getShortDesc()) && !"".equals(product.getImage())) {
                ModelMapper modelMapper = new ModelMapper();
                Product productEntity = modelMapper.map(product, Product.class);
                productService.addNewProduct(productEntity);
                result.setSuccess(true);
                result.setMessage("Save product successfully");
            } else {
                result.setSuccess(false);
                result.setMessage("Invalid model");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    @GetMapping("/detail/{productId}")
    public BaseApiResult detailProduct(@PathVariable int productId) {
        DataApiResult result = new DataApiResult();
        try {
            Product existProduct = productService.findOne(productId);
            if (existProduct == null) {
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            } else {
                result.setSuccess(true);
                ModelMapper modelMapper = new ModelMapper();
                ProductDetailModel productDetailModel = modelMapper.map(existProduct, ProductDetailModel.class);
                result.setData(productDetailModel);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update-product/{productId}")
    public BaseApiResult updateProduct(@PathVariable int productId, @RequestBody ProductDataModel product) {
        BaseApiResult result = new BaseApiResult();
        try {
            if (!"".equals(product.getName()) && !"".equals(product.getShortDesc()) && !"".equals(product.getImage())) {
                Product existProduct = productService.findOne(productId);
                if (existProduct == null) {
                    result.setSuccess(false);
                    result.setMessage("Invalid model");

                } else {
                    existProduct.setImage(product.getImage());
                    existProduct.setName(product.getName());
                    existProduct.setCreatedDate(product.getCreatedDate());
                    existProduct.setShortDesc(product.getShortDesc());
                    productService.updateProduct(existProduct);
                    result.setSuccess(true);
                    result.setMessage("Update product successfully");
                }
            } else {
                result.setSuccess(false);
                result.setMessage("Invalid model");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/delete-product")
    public BaseApiResult deleteProduct(@RequestBody ProductDeleteDataModel product) {
        BaseApiResult result = new DataApiResult();
        try {
            if (productService.deleteProduct(product.getProductId())) {
                result.setSuccess(true);
                result.setMessage("Delete product successfully");
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/fake-products")
    public BaseApiResult fakeProducts() {
        ArrayList<Product> listProducts = new ArrayList<>();
        Random random = new Random();
        BaseApiResult result = new BaseApiResult();

        for (int i = 0; i <= 10; ++i) {
            Product p = new Product();
            p.setCreatedDate(new Date());
            p.setName("Product " + i);
            p.setShortDesc("Desc for product " + i);
            p.setImage(images[random.nextInt(images.length)]);
            p.setCategory(categoryService.getOne(1));
            listProducts.add(p);
        }
        productService.addNewListProducts(listProducts);
        result.setSuccess(true);
        result.setMessage("Done");
        return result;
    }

}
