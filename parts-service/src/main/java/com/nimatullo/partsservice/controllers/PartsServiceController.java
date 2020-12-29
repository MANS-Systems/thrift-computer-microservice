package com.nimatullo.partsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nimatullo.partsservice.db.Database;
import com.nimatullo.partsservice.models.GraphicsCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartsServiceController {

    private final Database db = new Database();

    @RequestMapping("/")
    public String homePage() {
        return "Hello world";
    }

    @RequestMapping("/{productId}")
    @HystrixCommand(fallbackMethod = "getGraphicsCardDefault")
    public GraphicsCard getGraphicsCard(@PathVariable int productId) {
        if (productId > db.size()) {
            throw new RuntimeException();
        }
        else {
            return db.get(productId);
        }
    }

    public GraphicsCard getGraphicsCardDefault(int productId) {
        return new GraphicsCard("NVIDIA", "GTX 980 Ti", "Nvida", 299.99);
    }

}
