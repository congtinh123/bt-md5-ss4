package ra.testrestfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.testrestfullapi.model.entity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
