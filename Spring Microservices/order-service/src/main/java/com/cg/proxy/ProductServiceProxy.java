package com.cg.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.model.Order;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {
    @GetMapping("/products/{pid}")
    Order gerProduct( @PathVariable  int pid);
}
