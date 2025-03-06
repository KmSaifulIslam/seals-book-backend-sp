package org.example.sealsbookbackendsp.service;
import org.example.sealsbookbackendsp.model.MyFevaritProduct;
import org.example.sealsbookbackendsp.repository.MyFavoriteProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyFavoriteProductService {

    @Autowired
    private MyFavoriteProductRepository repository;

    public MyFevaritProduct addFavoriteProduct(Long userId, Long productId, Long storeId) {
        MyFevaritProduct favorite = new MyFevaritProduct();
        favorite.setUserId(userId);
        favorite.setProductId(productId);
        favorite.setStoreId(storeId);
        return repository.save(favorite);
    }

    public boolean removeFavoriteProduct(Long userId, Long productId) {
        Optional<MyFevaritProduct> favorite = repository.findByUserIdAndProductId(userId, productId);
        if (favorite.isPresent()) {
            repository.delete(favorite.get());
            return true;
        }
        return false;
    }

    public List<MyFevaritProduct> getAllFavoriteProducts(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
