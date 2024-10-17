package ra.testrestfullapi.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.testrestfullapi.model.entity.Employee;
import ra.testrestfullapi.repository.IEmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        employee.setId(null); // Đảm bảo rằng đây là một entity mới
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
