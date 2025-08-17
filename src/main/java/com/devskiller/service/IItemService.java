package com.devskiller.service;

import java.util.List;

public interface IItemService {
    List<String> getTitlesWithAverageRatingLowerThan(Double rating);
}
