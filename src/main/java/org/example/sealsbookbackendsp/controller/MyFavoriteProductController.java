package org.example.sealsbookbackendsp.controller;
import org.example.sealsbookbackendsp.model.MyFevaritProduct;
import org.example.sealsbookbackendsp.service.MyFavoriteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class MyFavoriteProductController {

    @Autowired
    private MyFavoriteProductService service;

    @PostMapping("/add")
    public ResponseEntity<MyFevaritProduct> addFavorite(@RequestBody MyFevaritProduct request) {
        return ResponseEntity.ok(service.addFavoriteProduct(request.getUserId(), request.getProductId(), request.getStoreId()));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFavorite(@RequestBody MyFevaritProduct request) {
        boolean isRemoved = service.removeFavoriteProduct(request.getUserId(), request.getProductId());
        if (isRemoved) {
            return ResponseEntity.ok("Product removed from favorites.");
        } else {
            return ResponseEntity.badRequest().body("Product not found in favorites.");
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<MyFevaritProduct>> getAllFavorites(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getAllFavoriteProducts(userId));
    }
}
