package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Product;
import org.example.sealsbookbackendsp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create Product
    public Product createProduct(Product product) {
        // Set product reference in colors
        if (product.getColors() != null) {
            product.getColors().forEach(color -> color.setProduct(product));
        }

        // Set product reference in sizes
        if (product.getSizes() != null) {
            product.getSizes().forEach(size -> size.setProduct(product));
        }

        // Set product reference in images (if needed)
        if (product.getImages() != null) {
            product.getImages().forEach(image -> image.setProduct(product));
        }

        return productRepository.save(product);
    }

    // Update Product
    public Product updateProduct(Long id, Product product) {
        // Check if product exists
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        Product updatedProduct = existingProduct.get();
        updatedProduct.setName(product.getName());
        updatedProduct.setBrand(product.getBrand());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setInventory(product.getInventory());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setImages(product.getImages());
        updatedProduct.setColors(product.getColors());
        updatedProduct.setSizes(product.getSizes());
        updatedProduct.setStoreId(id);

        return productRepository.save(updatedProduct);
    }

    // Delete Product
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    // Get Product By id
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Optional: Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
