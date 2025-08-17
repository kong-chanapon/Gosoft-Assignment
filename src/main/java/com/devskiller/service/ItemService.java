package com.devskiller.service;

import com.devskiller.dao.IItemRepository;
import com.devskiller.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {
    @Autowired
    private final IItemRepository itemRepository;

    public ItemService(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
        List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
        return items.stream().map(Item::getTitle).toList();
    }

}
