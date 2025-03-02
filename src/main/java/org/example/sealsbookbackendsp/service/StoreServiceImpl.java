package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Store;
import org.example.sealsbookbackendsp.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store updateStore(Long storeId, Store storeDetails) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + storeId));

        store.setStoreName(storeDetails.getStoreName());
        store.setStoreDescription(storeDetails.getStoreDescription());
        store.setStoreEmail(storeDetails.getStoreEmail());
        store.setStorePhoneNumber(storeDetails.getStorePhoneNumber());
        store.setStoreAddress(storeDetails.getStoreAddress());
        store.setCity(storeDetails.getCity());
        store.setState(storeDetails.getState());
        store.setCountry(storeDetails.getCountry());
        store.setStoreLogo(storeDetails.getStoreLogo());
        store.setBannerUrl(storeDetails.getBannerUrl());
        store.setOpeningHours(storeDetails.getOpeningHours());
        store.setStoreStatus(storeDetails.getStoreStatus());
        store.setStoreType(storeDetails.getStoreType());
        store.setStoreCategory(storeDetails.getStoreCategory());
        store.setFacebookPageLink(storeDetails.getFacebookPageLink());
        store.setWebsiteUrl(storeDetails.getWebsiteUrl());
        store.setWhatsappNumber(storeDetails.getWhatsappNumber());
        store.setStoreOwnerType(storeDetails.getStoreOwnerType());

        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + storeId));
        storeRepository.delete(store);
    }

    @Override
    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with ID: " + storeId));
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
