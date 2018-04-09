package application.data.repository;

import application.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hoangmanh on 4/3/18.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
