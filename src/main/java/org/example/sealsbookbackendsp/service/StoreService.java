package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Store;

import java.util.List;

public interface StoreService {
    Store addStore(Store store);
    Store updateStore(Long storeId, Store storeDetails);
    void deleteStore(Long storeId);
    Store getStoreById(Long storeId);
    Store getStoreByOwnerId(Long storeOwnerId);
    List<Store> getAllStores();
}