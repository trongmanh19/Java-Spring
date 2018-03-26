package application.data.service;

import application.data.model.PaginableItemList;
import application.data.model.Product;
import application.data.repository.ProductRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hoangmanh on 3/26/18.
 */
@Service
public class ProductService {

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void addNewListProducts(List<Product> productList) {
        productRepository.save(productList);
    }

    public long getTotalProducts() {
        return productRepository.getTotalProducts();
    }

    public PaginableItemList<Product> getListProducts(int pageSize, int pageNumber) {
        PaginableItemList<Product> paginableItemList = null;
        try {
            paginableItemList = new PaginableItemList<>();
            paginableItemList.setPageSize(pageSize);
            paginableItemList.setPageNumber(pageNumber);

            Page<Product> pages = productRepository.findAll(new PageRequest(pageNumber, pageSize));
            paginableItemList.setTotalProducts(pages.getTotalElements());
            paginableItemList.setListData(pages.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paginableItemList;
    }

    public Product findOne(int productId) {
        return productRepository.findOne(productId);
    }

    public boolean updateProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}
