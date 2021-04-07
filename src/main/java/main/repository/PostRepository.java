package main.repository;


import main.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{
    @Query(value = "SELECT YEAR(time) FROM posts" +
            " WHERE is_active=1  AND moderation_status = 'ACCEPTED'" +
            " AND time <= CURDATE() GROUP BY YEAR(time) ORDER BY YEAR(time)", nativeQuery = true)
    List<Integer> getAllYearPost();

    @Query(value = "SELECT DATE(time), COUNT(1)  FROM posts " +
            "WHERE is_active=1 AND moderation_status ='ACCEPTED' " +
            "AND time <= CURDATE() AND YEAR(time)=:year GROUP BY DATE(time)", nativeQuery = true)
    List<Object[]> getCountPostByDate(String year);
}
