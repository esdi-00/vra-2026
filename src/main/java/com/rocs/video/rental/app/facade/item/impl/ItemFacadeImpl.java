package com.rocs.video.rental.app.facade.item.impl;

import com.rocs.video.rental.app.facade.item.ItemFacade;
import com.rocs.video.rental.app.model.item.Item;
import com.rocs.video.rental.data.dao.item.ItemDao;
import com.rocs.video.rental.data.dao.item.impl.ItemDaoImpl;

public class ItemFacadeImpl implements ItemFacade {

    private final ItemDao itemDao = new ItemDaoImpl();

    @Override
    public Item getItemById(Long id) {
        return this.itemDao.findById(id);
    }
}
