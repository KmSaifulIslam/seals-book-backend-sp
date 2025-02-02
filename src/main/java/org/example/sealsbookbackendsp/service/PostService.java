package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Post;
import org.example.sealsbookbackendsp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Create Post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Get All Posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get Post by ID
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Get Posts by User ID
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    // Update Post
    public Optional<Post> updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(existingPost -> {
            existingPost.setTitle(postDetails.getTitle());
            existingPost.setBannerUrl(postDetails.getBannerUrl());
            existingPost.setPromoVideoUrl(postDetails.getPromoVideoUrl());
            existingPost.setProductId(postDetails.getProductId());
            existingPost.setNatureOfDiscount(postDetails.getNatureOfDiscount());
            existingPost.setNatureOfDiscountType(postDetails.getNatureOfDiscountType());
            existingPost.setDiscountDetails(postDetails.getDiscountDetails());
            existingPost.setFacebookBoostingDetails(postDetails.getFacebookBoostingDetails());

            return postRepository.save(existingPost);
        });
    }

    // Delete Post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
