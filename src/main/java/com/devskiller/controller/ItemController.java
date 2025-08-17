package com.devskiller.controller;

import com.devskiller.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private final IItemService itemService;

    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/titles")
    public List<String> getTitles(@RequestParam Double rating) {
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
