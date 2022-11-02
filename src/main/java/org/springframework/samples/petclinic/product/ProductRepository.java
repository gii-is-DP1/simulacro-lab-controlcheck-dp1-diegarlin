package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    @Query("select ptype from ProductType ptype")
    List<ProductType> findAllProductTypes();

    @Query("SELECT ptype from ProductType ptype where ptype.name = ?1")
    ProductType findProductTypeByName(String name);

    @Query("SELECT product from Product product where product.price<?1")
    List<Product> findByPriceLessThan(Double price);

    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
