package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Color;
import org.example.sealsbookbackendsp.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color getColorById(Long id) {
        return colorRepository.findById(id).orElse(null);
    }

    public List<Color> getColorsByProductId(Long productId) {
        return colorRepository.findByProductId(productId);
    }

    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    public Color updateColor(Long id, Color colorDetails) {
        Optional<Color> optionalColor = colorRepository.findById(id);
        if (optionalColor.isPresent()) {
            Color color = optionalColor.get();
            color.setColorName(colorDetails.getColorName());
            color.setColorCode(colorDetails.getColorCode());
            return colorRepository.save(color);
        }
        return null;
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}
