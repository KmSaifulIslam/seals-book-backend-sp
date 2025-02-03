package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.BrandingRequest;
import org.example.sealsbookbackendsp.service.BrandingRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branding-requests")
public class BrandingRequestController {

    private final BrandingRequestService brandingRequestService;

    public BrandingRequestController(BrandingRequestService brandingRequestService) {
        this.brandingRequestService = brandingRequestService;
    }

    // Create Branding Request
    @PostMapping("/add")
    public ResponseEntity<BrandingRequest> createBrandingRequest(@RequestBody BrandingRequest brandingRequest) {
        BrandingRequest createdRequest = brandingRequestService.createBrandingRequest(brandingRequest);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    // Get All Branding Requests
    @GetMapping("/all")
    public ResponseEntity<List<BrandingRequest>> getAllBrandingRequests() {
        return new ResponseEntity<>(brandingRequestService.getAllBrandingRequests(), HttpStatus.OK);
    }

    // Get Branding Request by ID
    @GetMapping("/{id}")
    public ResponseEntity<BrandingRequest> getBrandingRequestById(@PathVariable Long id) {
        Optional<BrandingRequest> brandingRequest = brandingRequestService.getBrandingRequestById(id);
        return brandingRequest.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update Branding Request
    @PutMapping("/update/{id}")
    public ResponseEntity<BrandingRequest> updateBrandingRequest(@PathVariable Long id, @RequestBody BrandingRequest brandingRequestDetails) {
        Optional<BrandingRequest> updatedRequest = brandingRequestService.updateBrandingRequest(id, brandingRequestDetails);
        return updatedRequest.map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Branding Request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBrandingRequest(@PathVariable Long id) {
        brandingRequestService.deleteBrandingRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
