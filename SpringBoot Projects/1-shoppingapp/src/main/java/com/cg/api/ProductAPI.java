package com.cg.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Product;
import com.cg.exceptions.ApplicationException;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {
   List<Product> products = new ArrayList<>();
   {
    products.add(new Product(1, "Laptop", 70000.0f, 4.5f));
    products.add(new Product(2, "Mobile", 30000.0f, 4.0f));
    products.add(new Product(3, "Apple Tablet", 25000.0f, 4.2f));
   products.add(new Product(4, "Smart Watch", 15000.0f, 3.5f));
   products.add(new Product(5, "Headphones", 5000.0f, 4.8f));
}
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }
    @PostMapping(consumes = {"application/xml"},
                 produces = {"application/xml","application/json"})
    public Product addNewProduct(@RequestBody   Product product) {
        products.add(product);
        return product;
    }
    @GetMapping( value = "/{id}",produces = {"application/xml","application/json"})
    public Product searchById( @PathVariable("id") int id ) {
          Product p1=  products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
          if(p1==null)
            throw new ApplicationException("Product with id "+id+" not found");
        return p1;
    }
     @PutMapping( value = "/{id}",produces = {"application/xml","application/json"},
                                  consumes = {"application/xml","application/json"})
    public Product updateProduct( @PathVariable("id") int id , @RequestBody  Product product) {
        Optional<Product>  existingProduct= products.stream().
        filter(p -> p.getId() == id).findFirst();

        if(existingProduct.isPresent()) {
            Product p = existingProduct.get();
            p.setProductName(product.getProductName());
            p.setPrice(product.getPrice());
            p.setRating(product.getRating());
            return p;
        }
       throw new ApplicationException("Product with id "+id+" not found");
    }
    @DeleteMapping( value = "/{id}")
    public String deleteProduct( @PathVariable("id") int id ) {
        Optional<Product>  existingProduct= products.stream().filter(p -> p.getId() == id).findFirst();
        if(existingProduct.isPresent()) {
            products.remove(existingProduct.get());
            return "Product deleted successfully";
        }
        return "Product not found";
    }
    @GetMapping( value="/test",
     produces = {"application/xml","application/json"})
    public Product testProduct() {
        return new Product(1, "Laptop", 70000.0f, 4.5f);
    }
    //searchbyname?name=lap
    @GetMapping( value="/searchbyname",
     produces = {"application/xml","application/json"})
    public   ResponseEntity<List<Product>> searchByName ( @RequestParam("name")   String name) {
          //starts with or end with or contains
          //if no records found return status code 204 
        return null;
    }
    //searchbyprice?min=1000&max=5000
    @GetMapping( value="/searchbyprice",
     produces = {"application/xml","application/json"})
   public  ResponseEntity<List<Product>> searchByPriceRange ( @RequestParam("min") float min,
    @RequestParam("max") float max) {
        return null;
    }  
    //sort?order=asc&field=price 
 @GetMapping( value="/sort",  produces = {"application/xml","application/json"})
    public  ResponseEntity<List<Product>> sortProducts(String order, String field){
        //recommended method : use Streams
        return null;
    }
    //topProducts?n=3&field=rating
     @GetMapping( value="/topProducts",  produces = {"application/xml","application/json"})
    public  ResponseEntity<List<Product>> findTopNProductsEntity(int n, String field){
                //recommended method : use Streams
        return null;
    }
    //averagePrice?price=price
     @GetMapping( value="/averagePrice",  produces = {"application/xml","application/json"})
    public  ResponseEntity<Float> findAveragePrice(String price){
        //recommended method : use Streams
        return null;
    }
    
    

}
