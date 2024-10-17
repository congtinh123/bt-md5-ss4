package ra.testrestfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.testrestfullapi.model.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
