package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoangmanh on 4/3/18.
 */
@Service
public class CategoryService {

    private static final Logger logger = LogManager.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getListAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    public Category getOne(int categoryId) {
        return categoryRepository.getOne(categoryId);
    }

}
