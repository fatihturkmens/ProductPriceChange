package com.productpricechange.ProductPriceChange.Repository;

import com.productpricechange.ProductPriceChange.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
