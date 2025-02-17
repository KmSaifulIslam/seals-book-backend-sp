package org.example.sealsbookbackendsp.service;

import lombok.RequiredArgsConstructor;
import org.example.sealsbookbackendsp.model.Cart;
import org.example.sealsbookbackendsp.model.CartItem;
import org.example.sealsbookbackendsp.model.Product;
import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.repository.CartItemRepository;
import org.example.sealsbookbackendsp.repository.CartRepository;
import org.example.sealsbookbackendsp.repository.ProductRepository;
import org.example.sealsbookbackendsp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    /**
     * Get cart by user ID, create a new cart if not exists.
     */
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });
    }

    /**
     * Add item to cart or update quantity if product already exists.
     */
//    @Transactional
//    public Cart addItemToCart(Long userId, CartItem cartItem) {
//        if (cartItem.getProduct() == null || cartItem.getProduct().getId() == null) {
//            throw new IllegalArgumentException("Product ID cannot be null");
//        }
//
//        // Fetch product to ensure it exists
//        Product product = productRepository.findById(cartItem.getProduct().getId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//        // Get user's cart
//        Cart cart = getCartByUserId(userId);
//
//        // Check if product already exists in cart
//        Optional<CartItem> existingItem = cart.getItems().stream()
//                .filter(item -> item.getProduct().getId().equals(product.getId()))
//                .findFirst();
//
//        if (existingItem.isPresent()) {
//            // Update quantity and total price if item already exists
//            CartItem item = existingItem.get();
//            item.setQuantity(item.getQuantity() + cartItem.getQuantity());
//            item.setTotalPrice(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
//            cartItemRepository.save(item);
//        } else {
//            // Add new item to cart
//            cartItem.setCart(cart);
//            cartItem.setProduct(product);
//            cartItem.setTotalPrice(cartItem.getUnitPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
//            cart.getItems().add(cartItem);
//            cartItemRepository.save(cartItem);
//        }
//
//        // Update cart total price
//        updateCartTotal(cart);
//        return cartRepository.save(cart);
//    }

    public Cart addItemToCart(Long userId, CartItem cartItem) {
        System.out.println("Received cart item: " + cartItem);
        if (cartItem.getProduct() == null || cartItem.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }

        Product product = productRepository.findById(cartItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = getCartByUserId(userId);
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setTotalPrice(cartItem.getUnitPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));

        cartItemRepository.save(cartItem);
        cart.getItems().add(cartItem);
        updateCartTotal(cart);
        return cartRepository.save(cart);
    }


    /**
     * Remove an item from the cart.
     */
    @Transactional
    public Cart removeItemFromCart(Long userId, Long itemId) {
        Cart cart = getCartByUserId(userId);
        boolean removed = cart.getItems().removeIf(item -> item.getId().equals(itemId));

        if (!removed) {
            throw new RuntimeException("Item not found in cart");
        }

        // Update total price after removing item
        updateCartTotal(cart);
        return cartRepository.save(cart);
    }

    /**
     * Clear all items from the cart.
     */
    @Transactional
    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartItemRepository.deleteAll(cart.getItems());
        cart.getItems().clear();
        cart.setTotalAmount(BigDecimal.ZERO);
        cartRepository.save(cart);
    }

    /**
     * Update cart total amount based on items.
     */
    private void updateCartTotal(Cart cart) {
        BigDecimal totalAmount = cart.getItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalAmount(totalAmount);
    }
}
