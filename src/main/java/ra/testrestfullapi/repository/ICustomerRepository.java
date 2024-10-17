package ra.testrestfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.testrestfullapi.model.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
