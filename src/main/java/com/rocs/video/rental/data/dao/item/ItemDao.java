package com.rocs.video.rental.data.dao.item;

import com.rocs.video.rental.app.model.item.Item;

import java.util.List;

public interface ItemDao {

    Item findById (Long id);

    List<Item> findAllItems ();

    boolean addItem (Item item);

    int updateItem (Item item);

    int deleteItemById (Long id);

}
