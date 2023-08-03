package ru.learnUP.springboottest.dao.post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.learnUP.springboottest.dao.entity.Comment;
import ru.learnUP.springboottest.dao.entity.Post;

import java.io.Serializable;
import java.util.List;

@Repository
public class PostDao {

    private final SessionFactory sessionFactory;

    public PostDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createDDL(String queryDDL) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(queryDDL).executeUpdate();
            transaction.commit();
        }
    }

    //Создание Post
    public Serializable createPost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable id = session.save(post);
            transaction.commit();
            return id;
        }
    }

    // Обновление Post
    public Post updatePost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

           List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                    comment.setTitle(post.getTitle());
            }
            session.merge(post);
            transaction.commit();
            return post;
        }
    }

    // Удаление Post
    public boolean deletePost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
//            Post post1 = session.find(Post.class, post.getId());
            session.remove(session.find(Post.class, post.getId()));
            transaction.commit();
            return true;
        }
    }

//    Получение списка всех постов
    public List<Post> getPosts() {
        try(Session session = sessionFactory.openSession()) {
          Query<Post> query = session.createQuery("from Post", Post.class);
            return query.getResultList();
        }
    }

    public Post getPostById(Long id) {

        return null;
    }

}
