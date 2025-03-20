package com.example.newsfeed.user.entity;

import com.example.newsfeed.follow.entity.Follow;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    private Long followerCount;
    private Long followingCount;

    @OneToMany(mappedBy = "follower")
    private List<Follow> followerList;

    @OneToMany(mappedBy = "following")
    private List<Follow> followingList;


    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.followerCount = 0L;
        this.followingCount = 0L;
    }

    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
