package com.example.newsfeed.post.entity;

import com.example.newsfeed.common.BaseTimeEntity;
import com.example.newsfeed.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private String title;
    private String content;
    private Long likesCount;

    public Post(String name,String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.likesCount = 0L;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
