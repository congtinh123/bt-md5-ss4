package ra.testrestfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.testrestfullapi.model.entity.Account;
@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
