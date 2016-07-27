package com.guan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guan.domain.Comment;
import com.guan.domain.Post;
import com.guan.dto.CommentDto;
import com.guan.dto.PostDto;
import com.guan.exceptions.ResourceNotFoundException;
import com.guan.repo.CommentRepository;
import com.guan.repo.PostRepository;

@Service
public class PostService {
    private Logger LOGGER = LoggerFactory.getLogger(PostService.class);
    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private PostRepository postRepo;

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

    public Comment getComment(String id) {
        return commentRepo.findOne(id);
    }
    public List<Comment> getCommentsOfPost(String id) {
        return commentRepo.findByPostId(id);
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }
    
    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }
    
    public Post createPost(PostDto dto) {
        Post post = new Post(dto);
        post.setUsername(userService.getCurrentUsername());
        return savePost(post);
    }
    public Comment addComment(CommentDto dto) {
        Comment comment = new Comment(dto);
        comment.setUsername(userService.getCurrentUsername());
        return saveComment(comment);
    }
    
    public Post updatePost(String id, PostDto dto) {
        Post post = getPost(id);
        post.setTitle(dto.getTitle());
        post.setDetail(dto.getDetail());
        return savePost(post);
    }

    public Comment updateComment(String id, CommentDto dto) {
        Comment comment = getComment(id);
        comment.setComment(dto.getComment());
        comment.setRate(dto.getRate());
        return saveComment(comment);
    }

    public void deletePost(String id) {
        LOGGER.warn("Delete post {}", id);
        if (getPost(id) != null) {
            postRepo.delete(id);
        } else {
            throw new ResourceNotFoundException(String.format("Post %s is not found", id));
        }
    }

    public void deleteComment(String id) {
        LOGGER.warn("Delete comment {}", id);
        if (getComment(id) != null) {
            commentRepo.delete(id);
        } else {
            throw new ResourceNotFoundException(String.format("Comment %s is not found", id));
        }
    }

    public Comment addReply(String commentId, String reply) {
        Comment comment = getComment(commentId);
        comment.setReply(reply);
        return saveComment(comment);
    }

    public List<Post> getPostsOfCategory(String categoryId) {
        return postRepo.findByCategoryId(categoryId);
    }
    public List<Post> getPostsOfUser(String username) {
        return postRepo.findByUsername(username);
    }

}
