package ru.learnUP.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUP.springboottest.dao.entity.Comment;
import ru.learnUP.springboottest.dao.entity.Post;
import ru.learnUP.springboottest.dao.post.PostDao;

import java.util.List;
//import ru.learnUP.springboottest.service.Calculator;
//import ru.learnUP.springboottest.service.Operation;
//import ru.learnUP.springboottest.service.ValueService;


//Создание Spring Boot приложений удобнее через Spring initializr
//https://start.spring.io/index.html, а не путем импортирования зависимостей
//Нет необходимости в XML-конфигурации
@SpringBootApplication
public class SpringBootTestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

//		Calculator calculator = context.getBean(Calculator.class);
//		log.info("{} + {} = {}", 1, 2, calculator.calculate(2, 2, Operation.MINUS));
//		context.getBean(ValueService.class).print();

//		Использование базы данных SQL
		PostDao postDao = context.getBean(PostDao.class);

		Comment comment = new Comment();
		comment.setText("Comment text");

		Post post = new Post();
		post.setText("Post text");
		post.setTitle("Post title");

		comment.setPost(post);
		post.setComments(List.of(comment));

		postDao.createPost(post);

		List<Post> posts = postDao.getPosts();
		log.info("{}", posts);

	}

}
