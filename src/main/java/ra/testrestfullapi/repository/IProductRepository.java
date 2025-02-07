package ra.testrestfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.testrestfullapi.model.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
