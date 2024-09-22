package com.productpricechange.ProductPriceChange.Controller;

import com.productpricechange.ProductPriceChange.Entity.Product;
import com.productpricechange.ProductPriceChange.ProductPriceChangeApplication;
import com.productpricechange.ProductPriceChange.Repository.ProductRepository;
import com.productpricechange.ProductPriceChange.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
    private ProductService productService;


   @GetMapping("all")
   public ResponseEntity<List<Product>> all(){
      List<Product> list = productService.allProducts();
      return new ResponseEntity<>(list,HttpStatus.OK);

   }

   @PostMapping("/save")
   public ResponseEntity<String> save(@RequestBody Product product){
       productService.saveproduct(product);
       return new ResponseEntity<>("eklendi", HttpStatus.CREATED);
   }


   @PutMapping("/update/{urunid}/{indirim}")
    public ResponseEntity<Product> indirim (@PathVariable Long urunid,@PathVariable Double indirim){
      Product product = productService.indirim(urunid,indirim);
       return new ResponseEntity<>(product,HttpStatus.OK);

   }


   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
       productService.deleteurun(id);
       return new ResponseEntity<>("prodoct is deleted",HttpStatus.OK);
   }
   @PutMapping("/updatezam/{urunid}/{zam}")
    public ResponseEntity<Product> zam(@PathVariable Long urunid,@PathVariable Double zam){
       Product product = productService.zam(urunid,zam);
       return new ResponseEntity<>(product,HttpStatus.OK);
   }




}
