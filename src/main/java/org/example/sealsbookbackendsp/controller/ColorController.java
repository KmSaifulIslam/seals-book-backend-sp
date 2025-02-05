package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.Color;
import org.example.sealsbookbackendsp.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    // Get all colors
    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    // Get a single color by ID
    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable Long id) {
        Color color = colorService.getColorById(id);
        return (color != null) ? ResponseEntity.ok(color) : ResponseEntity.notFound().build();
    }

    // Get colors by product ID
    @GetMapping("/product/{productId}")
    public List<Color> getColorsByProductId(@PathVariable Long productId) {
        return colorService.getColorsByProductId(productId);
    }

    // Create a new color
    @PostMapping
    public Color createColor(@RequestBody Color color) {
        return colorService.createColor(color);
    }

    // Update an existing color
    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Long id, @RequestBody Color colorDetails) {
        Color updatedColor = colorService.updateColor(id, colorDetails);
        return (updatedColor != null) ? ResponseEntity.ok(updatedColor) : ResponseEntity.notFound().build();
    }

    // Delete a color
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
