package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.MyFlowing;
import org.example.sealsbookbackendsp.service.MyFlowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/following")
public class MyFlowingController {

    @Autowired
    private MyFlowingService service;

    @PostMapping("/add")
    public ResponseEntity<MyFlowing> addFollowing(@RequestBody MyFlowing request) {
        return ResponseEntity.ok(service.addFollowing(request.getUserId(), request.getStoreId()));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFollowing(@RequestBody MyFlowing request) {
        boolean isRemoved = service.removeFollowing(request.getUserId(), request.getStoreId());
        if (isRemoved) {
            return ResponseEntity.ok("Successfully unfollowed the store.");
        } else {
            return ResponseEntity.badRequest().body("Following record not found.");
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<MyFlowing>> getAllFollowing(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getAllFollowing(userId));
    }
}
