package ra.testrestfullapi.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.testrestfullapi.model.entity.Product;
import ra.testrestfullapi.repository.IProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        product.setId(null); // To ensure a new entity is created
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Integer id) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
