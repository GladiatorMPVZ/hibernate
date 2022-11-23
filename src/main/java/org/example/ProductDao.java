package org.example;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductDao {
    private Product product;

    public Product findById(Long id, Session session) {
        product = session.get(Product.class, id);
        return product;
    }

    public List<Product> findAll(Session session) {
        List<Product> productList = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        return productList;
    }
//
     public void deleteById(Long id, Session session) {
         product = session.get(Product.class, id);
         session.remove(product);
     }

    public Product saveOrUpdate(Product product) {
        //?
        return product;
    }
}
