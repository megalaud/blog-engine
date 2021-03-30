package main.service;


import main.api.response.TagResponse;
import main.api.response.TagsResponse;
import main.model.Tag;
import main.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagService
{
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostService postService;

    public TagsResponse list()
    {
        TagsResponse tagsResponse = new TagsResponse();
        List<TagResponse> list =  new ArrayList<>();
        Iterable<Tag> tagIterable = tagRepository.findAll();
        long weights = postService.postCounts();
        int maxTagCount = 0;
        for(Tag tag: tagIterable)
        {
            TagResponse tagResponse = new TagResponse();
            tagResponse.setName(tag.getName());
            int curTagCount = tag.getPostCount();
            maxTagCount = (maxTagCount > curTagCount ? maxTagCount : curTagCount);
            tagResponse.setWeight(((double) curTagCount)/weights);
            list.add(tagResponse);
        }
        double k = (maxTagCount>0 ? (double) weights/maxTagCount : 0.0);
        for (TagResponse t: list)
        {
            double w = t.getWeight();
            double temp = ((double) Math.round( w * k * 100.0))/100.0;
            t.setWeight(temp);
        }

        tagsResponse.setTags(list);
        return tagsResponse;
    }
}
