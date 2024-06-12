package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
//        throw new UnsupportedOperationException();
        List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
        List<String> titles = new ArrayList<>();
        for (Item i: items){
            titles.add(i.getTitle());
        }
        return titles;
    }

}
