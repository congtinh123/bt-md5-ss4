package ra.testrestfullapi.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.testrestfullapi.model.entity.Account;
import ra.testrestfullapi.repository.IAccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        account.setId(null);
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account, Integer id) {
       account.setId(id);
       return accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }
}
