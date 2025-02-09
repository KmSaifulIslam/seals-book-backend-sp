package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.Size;
import org.example.sealsbookbackendsp.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    // Get all sizes
    @GetMapping
    public List<Size> getAllSizes() {
        return sizeService.getAllSizes();
    }

    // Get a single size by ID
    @GetMapping("/{id}")
    public ResponseEntity<Size> getSizeById(@PathVariable Long id) {
        Size size = sizeService.getSizeById(id);
        return (size != null) ? ResponseEntity.ok(size) : ResponseEntity.notFound().build();
    }

    // Get sizes by product ID
    @GetMapping("/product/{productId}")
    public List<Size> getSizesByProductId(@PathVariable Long productId) {
        return sizeService.getSizesByProductId(productId);
    }

    // Create a new size
    @PostMapping
    public Size createSize(@RequestBody Size size) {
        return sizeService.createSize(size);
    }

    // Update an existing size
    @PutMapping("/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable Long id, @RequestBody Size sizeDetails) {
        Size updatedSize = sizeService.updateSize(id, sizeDetails);
        return (updatedSize != null) ? ResponseEntity.ok(updatedSize) : ResponseEntity.notFound().build();
    }

    // Delete a size
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSize(@PathVariable Long id) {
        sizeService.deleteSize(id);
        return ResponseEntity.noContent().build();
    }
}
