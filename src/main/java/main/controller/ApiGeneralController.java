package main.controller;

import main.api.response.*;
import main.service.PostService;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api")
public class ApiGeneralController
{
    private final InitResponse initResponse;
    private final SettingsService settingsService;
    private final TagService tagService;
    private final PostService postService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService, TagService tagService, PostService postService)
    {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.tagService = tagService;
        this.postService = postService;
    }

    @GetMapping("/init")
    private InitResponse init()
    {
        return initResponse;
    }

    @GetMapping("/settings")
    private SettingsResponse settings()
    {
        return settingsService.getSettings();
    }

    @GetMapping("/tag")
    private TagsResponse tags(@RequestParam(value = "query", required = false) String query)
    {
        return tagService.list();
    }

    @GetMapping("/calendar")
    private CalendarResponse calendar(@RequestParam(value = "year", required = false) String year)
    {
//        Map<String, Integer> map = new TreeMap<>();
//        map.put("2021-01-01",100);
//        map.put("2021-03-01",31);
        PostCountByDateResponse pp = new PostCountByDateResponse(postService.getCountPostByDate(year));

        return new CalendarResponse(postService.getAllYearPost(),pp);
    }

}
