package com.productpricechange.ProductPriceChange.Service;

import com.productpricechange.ProductPriceChange.Entity.Product;
import com.productpricechange.ProductPriceChange.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


     public List<Product> allProducts(){
         return          productRepository.findAll();
     }
    public Product saveproduct(Product product){
       return productRepository.save(product);
    }

    public Product indirim(Long urunid,Double indirim){           /// indirim oranı
       Optional<Product> product = productRepository.findById(urunid);

       if (product.isPresent()){
           Product product1 = product.get();
           Double priceupdated = product1.getPrice() - (product1.getPrice()  * indirim ) / 100;
           product1.setPrice(priceupdated);
           productRepository.save(product1);
           return product1;
       }
       else {
           return null;


       }
    }
    public String deleteurun(Long id){
         productRepository.deleteById(id);
         return "Product is deleted";
    }
    public Product zam(Long urunid,Double zam) {           /// indirim oranı
        Optional<Product> product = productRepository.findById(urunid);

        if (product.isPresent()) {
            Product product1 = product.get();
            Double priceupdated = product1.getPrice() + (product1.getPrice() * zam) / 100;
            product1.setPrice(priceupdated);
            productRepository.save(product1);
            return product1;
        } else {
            return null;
        }
    }
}
