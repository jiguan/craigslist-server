package com.guan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.domain.Comment;
import com.guan.domain.Post;
import com.guan.dto.PostDto;
import com.guan.exceptions.ResourceNotFoundException;
import com.guan.repo.PostRepository;

@Service
public class PostService {
    private Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private PostRepository postRepo;

    public List<Post> getPostsUnderCategory(String categoryId) {
        return postRepo.findAll().stream().filter(p -> p.getCategory().equals(categoryId)).collect(Collectors.toList());
    }

    public List<Post> getAllPosts() {
        List<Post> result = postRepo.findAll();
        for (Post p : result) {
            LOGGER.debug(p.getId() + "");
        }
        return result;
    }

    public Post getPost(String id) {
        return postRepo.findOne(id);
    }
    

//    public Post createPost(PostDto dto) {
//        return savePost(new Post(dto));
//    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    public Post updatePost(String id, PostDto dto) {
        Post post = getPost(id);
        post.setTitle(dto.getTitle());
        post.setDetail(dto.getDetail());
        return savePost(post);
    }

    public void deletePost(String id) {
        LOGGER.warn("Delete post {}", id);
        if (getPost(id) != null) {
            postRepo.delete(id);
        } else {
            throw new ResourceNotFoundException(String.format("Post %s is not found", id));
        }
    }

    public Post addComment(String id, Comment comment) {
        Post post = getPost(id);
        post.addComment(comment);
        return savePost(post);
    }
    
    public Post addReply(String postId, int commentId, String reply) {
        Post post = getPost(postId);
        List<Comment> comments = post.getComments().stream().filter(c -> c.getId()==commentId).collect(Collectors.toList());;
        if(comments.size()!=1) {
            throw new IllegalStateException();
        }
        Comment comment = comments.get(0);
        comment.setReply(reply);
        return savePost(post);
    }

}
