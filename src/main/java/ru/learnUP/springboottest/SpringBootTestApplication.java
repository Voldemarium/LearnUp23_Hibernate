package ru.learnUP.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUP.springboottest.dao.entity.Comment;
import ru.learnUP.springboottest.dao.entity.Post;
import ru.learnUP.springboottest.dao.post.PostDao;

import java.io.Serializable;
import java.util.List;

@SpringBootApplication
public class SpringBootTestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

//		Использование базы данных SQL
		PostDao postDao = context.getBean(PostDao.class);

//		Удаление всех постов (одновременно удаляются зависимые дочерние Entity Comment)
		List<Post> posts1 = postDao.getPosts();
     	log.info("{}", posts1);
//		for (Post post : posts1) {
//			postDao.deletePost(post);
//		}
//
//		Post post = new Post();
//		post.setText("Post1 text");
//		post.setTitle("Post1 title");
//
//		Comment comment1 = new Comment();
//		comment1.setText("Comment1_1 text");
//		Comment comment2 = new Comment();
//		comment2.setText("Comment1_2 text");
//
//		comment1.setPost(post);
//		comment2.setPost(post);
//		post.setComments(List.of(comment1, comment2));
//
////		Сохранение в базу Entity "Post post" (одновременно сохраняются зависимые дочерние объекты Comment
//		Serializable id = postDao.createPost(post);
//		log.info("{}", id);


//		List<Post> posts2 = postDao.getPosts();
//		log.info("{}", posts2);

//       postDao.createDDL("ALTER TABLE comment DROP CONSTRAINT comment_post_id_title_fkey1");
//        postDao.createDDL("ALTER TABLE comment ADD FOREIGN KEY (post_id, title) " +
//                "                              REFERENCES post (id, title) ON UPDATE CASCADE");
//
//
		Post postsUpdate = posts1.get(0);
		postsUpdate.setTitle("title update4");
//		postsUpdate.setText("text update5");
		postDao.updatePost(postsUpdate);

	}
}
