package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query("select i from Item i left join Review r on i.id = r.item.id group by i.id having COALESCE(AVG(r.rating), 0) < :rating")
    List<Item> findItemsWithAverageRatingLowerThan(@Param("rating")  Double rating);

}
