package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.BrandingRequest;
import org.example.sealsbookbackendsp.repository.BrandingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandingRequestService {
    private final BrandingRequestRepository brandingRequestRepository;

    public BrandingRequestService(BrandingRequestRepository brandingRequestRepository) {
        this.brandingRequestRepository = brandingRequestRepository;
    }

    // Create a new Branding Request
    public BrandingRequest createBrandingRequest(BrandingRequest brandingRequest) {
        return brandingRequestRepository.save(brandingRequest);
    }

    // Get all Branding Requests
    public List<BrandingRequest> getAllBrandingRequests() {
        return brandingRequestRepository.findAll();
    }

    // Get Branding Request by ID
    public Optional<BrandingRequest> getBrandingRequestById(Long id) {
        return brandingRequestRepository.findById(id);
    }

    // Update Branding Request
    public Optional<BrandingRequest> updateBrandingRequest(Long id, BrandingRequest brandingRequestDetails) {
        return brandingRequestRepository.findById(id).map(existingRequest -> {
            existingRequest.setBoostId(brandingRequestDetails.getBoostId());
            existingRequest.setBanner(brandingRequestDetails.getBanner());
            existingRequest.setBrandingCostId(brandingRequestDetails.getBrandingCostId());
            existingRequest.setPromotion_video(brandingRequestDetails.getPromotion_video());
            existingRequest.setPaintingDetails(brandingRequestDetails.getPaintingDetails());
            return brandingRequestRepository.save(existingRequest);
        });
    }

    // Delete Branding Request
    public void deleteBrandingRequest(Long id) {
        brandingRequestRepository.deleteById(id);
    }
}
