package com.cg.api;

import com.cg.dto.OrderDto;
import com.cg.model.Order;
import com.cg.proxy.ProductServiceProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderApi {
    @PostMapping
    public Order orderProduct(@RequestBody OrderDto orderDto) {
      String url="http://localhost:8000/products/"+orderDto.getProdId();
      RestTemplate restTemplate=new RestTemplate();
      Order order=
      restTemplate.getForObject(url, Order.class);
      return  order;
    }
    @Autowired
    private RestTemplate template;
     @PostMapping("/loadBal")
    public Order orderProductLoadBal(@RequestBody OrderDto orderDto) {
      String url="http://product-service/products/"+orderDto.getProdId();
         Order order=
      template.getForObject(url, Order.class);
           return  order;
    }
    @Autowired
    private ProductServiceProxy proxy;
     @PostMapping("/feign")
    public Order orderProductFeign(@RequestBody OrderDto orderDto) {
       Order order=proxy.gerProduct(orderDto.getProdId());            
      return  order;
    }
}
