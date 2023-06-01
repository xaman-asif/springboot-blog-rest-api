package com.springboot.blog;

import com.springboot.blog.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootBlogRestApiApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

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
