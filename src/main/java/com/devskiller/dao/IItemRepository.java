package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IItemRepository extends CrudRepository<Item, Long> {
    @Query("select i from Item i join i.reviews r group by i.id having avg(r.rating) < :rating")
    List<Item> findItemsWithAverageRatingLowerThan(@Param("rating")  Double rating);
}
