package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    //public Product getProduct(@PathVariable("id") long id){
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){

        //return productService.getProduct(id);
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        HttpHeaders resHttpHeaders = new HttpHeaders();
        resHttpHeaders.set("Version","Cybertek.v1");
        resHttpHeaders.set("Operation","Get List");

        return ResponseEntity
                .ok()
                .headers(resHttpHeaders)
                .body(productService.getProducts());
    }

    @PostMapping
    //public List<Product> createProduct(@RequestBody Product product){
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product){

        //return productService.createProduct(product);
        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version","Cybertek.v1")
                .header("Operation","Create")
                .body(set);
    }

    @DeleteMapping(value = "/{id}")
    //public List<Product> deleteProducts(@PathVariable("id") long id){
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id){

        //return productService.delete(id);
        HttpHeaders resHttpHeaders = new HttpHeaders();
        resHttpHeaders.set("Version","Cybertek.v1");
        resHttpHeaders.set("Operation","Delete");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list, resHttpHeaders, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    //public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id, @RequestBody Product product){

        //return productService.updateProduct(id, product);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Version","Cybertek.v1");
        map.add("Operation","Update");

        List<Product> list = productService.updateProduct(id,product);

        return new ResponseEntity<>(list,map,HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProduct(){
        return ResponseEntity
                .ok(new ResponseWrapper("Product Successfully Retrieved.",productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") long id){
        return ResponseEntity.ok(new ResponseWrapper("Product Successfully Deleted."));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("Product Successfully Deleted."));
    }
}
