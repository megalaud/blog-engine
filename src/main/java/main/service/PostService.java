package main.service;

import main.api.response.PostResponse;
import main.api.response.PostsResponse;
import main.api.response.UserPostResponse;
import main.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostsResponse list()
    {
        PostsResponse postsResponse = new PostsResponse();
        UserPostResponse userPostResponse = new UserPostResponse();
        userPostResponse.setId(88);
        userPostResponse.setName("Дмитрий Петров");
        PostResponse postResponse = new PostResponse();
        postResponse.setAnnounce("Текст анонса поста без HTML-тэгов");
        postResponse.setCommentCount(15);
        postResponse.setDislikeCount(3);
        postResponse.setId(345);
        postResponse.setLikeCount(36);
        postResponse.setUser(userPostResponse);
        postResponse.setViewCount(55);
        postResponse.setTitle("Заголовок поста");
        postResponse.setTimestamp(Instant.now().getEpochSecond());

        List<PostResponse> list = new ArrayList<>();
        list.add(postResponse);
        postsResponse.setCount(20);
        postsResponse.setPosts(list);
        return postsResponse;
    }

    public long postCounts()
    {
        return postRepository.count();
    }
}
