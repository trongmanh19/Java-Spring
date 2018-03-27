package application.controller.api;

import application.data.model.Product;
import application.data.service.ProductService;
import application.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hoangmanh on 3/27/18.
 */
@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public BaseApiResult createProduct(@RequestBody ProductDataModel product) {
        BaseApiResult result = new BaseApiResult();

        try {
            if(!"".equals(product.getName()) && !"".equals(product.getShortDesc()) && !"".equals(product.getImage())) {
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
    public BaseApiResult detailProduct(@PathVariable int productId){
        DataApiResult result = new DataApiResult();
        try{
            Product existProduct = productService.findOne(productId);
            if (existProduct == null){
                result.setSuccess(false);
                result.setMessage("Can't find this product");
            }else {
                result.setSuccess(true);
                ModelMapper modelMapper = new ModelMapper();
                ProductDetailModel productDetailModel = modelMapper.map(existProduct, ProductDetailModel.class);
                result.setData(productDetailModel);
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/update-product/{productId}")
    public BaseApiResult updateProduct(@PathVariable int productId, @RequestBody ProductDataModel product){
        BaseApiResult result = new BaseApiResult();
        try {
            if (!"".equals(product.getName()) && !"".equals(product.getShortDesc()) && !"".equals(product.getImage())){
                Product existProduct = productService.findOne(productId);
                if (existProduct ==null){
                    result.setSuccess(false);
                    result.setMessage("Invalid model");

                }else {
                    existProduct.setImage(product.getImage());
                    existProduct.setName(product.getName());
                    existProduct.setCreatedDate(product.getCreatedDate());
                    existProduct.setShortDesc(product.getShortDesc());
                    productService.updateProduct(existProduct);
                    result.setSuccess(true);
                    result.setMessage("Update product successfully");
                }
            }else {
                result.setSuccess(false);
                result.setMessage("Invalid model");
            }
        } catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @PostMapping("/delete-product")
    public BaseApiResult deleteProduct(@RequestBody ProductDeleteDataModel product){
        BaseApiResult result = new DataApiResult();
        try{
            if (productService.deleteProduct(product.getProductId())){
                result.setSuccess(true);
                result.setMessage("Delete product successfully");
            }
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
