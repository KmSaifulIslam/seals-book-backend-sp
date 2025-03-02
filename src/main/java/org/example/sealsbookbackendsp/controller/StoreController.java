package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.Store;
import org.example.sealsbookbackendsp.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // ✅ Add Store
    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        Store createdStore = storeService.addStore(store);
        return ResponseEntity.ok(createdStore);
    }

    // ✅ Update Store
    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Long storeId, @RequestBody Store storeDetails) {
        Store updatedStore = storeService.updateStore(storeId, storeDetails);
        return ResponseEntity.ok(updatedStore);
    }

    // ✅ Delete Store
    @DeleteMapping("/{storeId}")
    public ResponseEntity<String> deleteStore(@PathVariable Long storeId) {
        storeService.deleteStore(storeId);
        return ResponseEntity.ok("Store deleted successfully.");
    }

    // ✅ Get Store by ID
    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {
        Store store = storeService.getStoreById(storeId);
        return ResponseEntity.ok(store);
    }

    // ✅ Get All Stores
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        return ResponseEntity.ok(stores);
    }
}