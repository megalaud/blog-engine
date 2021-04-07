package main.api.response;
import java.util.List;

public class CalendarResponse
{
    private List<Integer> years;
    private PostCountByDateResponse posts;

    public CalendarResponse(List<Integer> years, PostCountByDateResponse posts) {
        this.years = years;
        this.posts = posts;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public PostCountByDateResponse getPosts() {
        return posts;
    }

    public void setPosts(PostCountByDateResponse posts) {
        this.posts = posts;
    }

}
