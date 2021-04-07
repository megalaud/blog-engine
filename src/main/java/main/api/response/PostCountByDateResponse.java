package main.api.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class PostCountByDateResponse
{
    private Map<String, Long> posts;

    public PostCountByDateResponse(Map<String, Long> posts) {
        this.posts = posts;
    }

    @JsonAnyGetter
    public Map<String, Long> getPosts() {
        return posts;
    }

    public void setPosts(Map<String, Long> posts) {
        this.posts = posts;
    }
}
