package capstone.code.repositories;

import capstone.code.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface ProductRepository extends CrudRepository<capstone.code.domain.Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    public List<capstone.code.domain.Product> search(String keyword);
}
