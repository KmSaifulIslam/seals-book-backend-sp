package org.example.sealsbookbackendsp.service;

import lombok.RequiredArgsConstructor;
import org.example.sealsbookbackendsp.model.Cart;
import org.example.sealsbookbackendsp.model.CartItem;
import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.repository.CartItemRepository;
import org.example.sealsbookbackendsp.repository.CartRepository;
import org.example.sealsbookbackendsp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
    }

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });
    }

    public Cart addItemToCart(Long userId, CartItem cartItem) {
        Cart cart = getCartByUserId(userId);
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
        cart.getItems().add(cartItem);
        cart.setTotalAmount(cart.getItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(Long userId, Long itemId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().removeIf(item -> item.getId().equals(itemId));
        cart.setTotalAmount(cart.getItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return cartRepository.save(cart);
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartItemRepository.deleteAll(cart.getItems());
        cart.getItems().clear();
        cart.setTotalAmount(BigDecimal.ZERO);
        cartRepository.save(cart);
    }
}
