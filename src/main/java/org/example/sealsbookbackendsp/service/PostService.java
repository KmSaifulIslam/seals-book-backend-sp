package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.Post;
import org.example.sealsbookbackendsp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // ✅ Add a new post
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    // ✅ Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // ✅ Get a single post by ID
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
    }

    // ✅ Update a post
    public Post updatePost(Long postId, Post updatedPost) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBannerUrl(updatedPost.getBannerUrl());
        existingPost.setPromoVideoUrl(updatedPost.getPromoVideoUrl());
        existingPost.setProductsId(updatedPost.getProductsId());
        existingPost.setNatureOfDiscount(updatedPost.getNatureOfDiscount());
        existingPost.setNatureOfDiscountType(updatedPost.getNatureOfDiscountType());
        existingPost.setDiscountDetails(updatedPost.getDiscountDetails());
        existingPost.setFacebookBoostingDetails(updatedPost.getFacebookBoostingDetails());

        return postRepository.save(existingPost);
    }

    // ✅ Delete a post
    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post not found with id: " + postId);
        }
        postRepository.deleteById(postId);
    }
}
