package com.springboot.blog;

import com.springboot.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootBlogRestApiApplication {

	@Autowired
	PostRepository postRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);

	}
//	@PostConstruct
//	void test() {
//		try{
//			postRepository.deleteById(10L);
//		} catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//	}
}
