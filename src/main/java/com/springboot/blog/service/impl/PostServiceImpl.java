package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDTO;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //convert DTO to entity
        Post post = mapToEntity(postDTO);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDTO postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        List<PostDTO> postResponse = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

//        List<PostDTO> postResponse = new ArrayList<>();
//
//        for (Post post:
//             posts) {
//            postResponse.add(mapToDTO(post));
//        }
        return postResponse;
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        PostDTO responseDTO = mapToDTO(post);

        return responseDTO;
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO updatedPostDTO) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        PostDTO responseDTO = null;

        Post updatedPost = mapToEntity(updatedPostDTO);

        Post tempPost = postRepository.save(updatedPost);

        responseDTO = mapToDTO(tempPost);

//        post.setDescription(updatedPostDTO.getDescription());
//        post.setTitle(updatedPostDTO.getTitle());
//        post.setContent(updatedPostDTO.getContent());
//
//        return mapToDTO(postRepository.save(post));

        return responseDTO;
    }


    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }


    private PostDTO mapToDTO(Post post) {
        PostDTO tempPostDTO = new PostDTO();

        tempPostDTO.setId(post.getId());
        tempPostDTO.setDescription(post.getDescription());
        tempPostDTO.setTitle(post.getTitle());
        tempPostDTO.setContent(post.getContent());

        return tempPostDTO;
    }

    private Post mapToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        return post;
    }
}