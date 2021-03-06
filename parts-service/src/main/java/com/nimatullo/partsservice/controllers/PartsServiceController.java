package com.nimatullo.partsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nimatullo.partsservice.db.Database;
import com.nimatullo.partsservice.models.GraphicsCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PartsServiceController {

    private final Database db = new Database();

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

    @RequestMapping("/parts/all")
    public Flux<GraphicsCard> getAllGraphicsCards() {
        return Flux.fromIterable(db.getAll());
    }

    public GraphicsCard getGraphicsCardDefault(int productId) {
        return new GraphicsCard("NVIDIA", "GTX 980 Ti", "Nvida", 299.99);
    }

}
