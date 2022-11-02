package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    
    @Autowired(required = true)
	public ProductService(ProductRepository ProductRepository) {
		this.productRepository = ProductRepository;
	}

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductType> getAllProductsType(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    
    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}
