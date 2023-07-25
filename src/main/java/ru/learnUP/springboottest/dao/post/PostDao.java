package ru.learnUP.springboottest.dao.post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import ru.learnUP.springboottest.dao.entity.Post;

import java.util.List;

@Repository
public class PostDao {

    private final SessionFactory sessionFactory;

    public PostDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Создание Post
    public Post createPost(Post post) {
//        try здесь используется автоматич закрытия сессии (AutoClosable)
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(post);
            transaction.commit();
            return post;
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
