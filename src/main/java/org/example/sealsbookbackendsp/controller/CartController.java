package org.example.sealsbookbackendsp.controller;

import lombok.RequiredArgsConstructor;
import org.example.sealsbookbackendsp.model.Cart;
import org.example.sealsbookbackendsp.model.CartItem;
import org.example.sealsbookbackendsp.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
//@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long userId, @RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartService.addItemToCart(userId, cartItem));
    }

    @DeleteMapping("/{userId}/remove/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long userId, @PathVariable Long itemId) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, itemId));
    }

    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }
}
