package main.repository;

import main.model.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>
{
    Tag findTagByName(String name);

}
