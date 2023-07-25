package ru.learnUP.springboottest.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY = PRIMARY KEY
    private Long id;

    @Column
    private String title;

    @Column
    private String text;

//    FetchType.EAGER - значит комментарии всегда подтягиваются из базы данных при вызове
//    CascadeType.ALL - значит все комментарии после удаления поста Post удаляются из базы данных
//@OnDelete(action = OnDeleteAction.CASCADE) тоже значит все комментарии после удаления поста Post удаляются из базы данных
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}
