package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Size;
import org.example.sealsbookbackendsp.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    public Size getSizeById(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }

    public List<Size> getSizesByProductId(Long productId) {
        return sizeRepository.findByProductId(productId);
    }

    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }

    public Size updateSize(Long id, Size sizeDetails) {
        Optional<Size> optionalSize = sizeRepository.findById(id);
        if (optionalSize.isPresent()) {
            Size size = optionalSize.get();
            size.setSizeName(sizeDetails.getSizeName());
            return sizeRepository.save(size);
        }
        return null;
    }

    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
