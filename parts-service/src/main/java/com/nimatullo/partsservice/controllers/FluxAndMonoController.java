package com.nimatullo.partsservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nimatullo.partsservice.db.Database;
import com.nimatullo.partsservice.models.GraphicsCard;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FluxAndMonoController {

    private final Database db = new Database();

    @GetMapping(value = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<GraphicsCard> returnFluxStream() {
        return Mono.just(db.getAll())
                .flatMapMany(Flux::fromIterable)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

    @GetMapping(value = "/{productId}")
    @HystrixCommand(fallbackMethod = "getGraphicsCardDefault")
    public Mono<GraphicsCard> getGraphicCard(@PathVariable int productId) {
        return Mono.just(db.get(productId))
                .switchIfEmpty(Mono.error(new RuntimeException()));
    }

    public Mono<GraphicsCard> getGraphicsCardDefault(int productId) {
        return Mono.just(new GraphicsCard("NVIDIA", "GTX 980 Ti", "Nvidia", 299.99));
    }

}
