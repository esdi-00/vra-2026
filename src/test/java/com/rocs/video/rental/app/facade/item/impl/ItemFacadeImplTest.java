package com.rocs.video.rental.app.facade.item.impl;

import com.rocs.video.rental.app.facade.item.ItemFacade;
import com.rocs.video.rental.app.model.item.Item;
import com.rocs.video.rental.data.dao.item.ItemDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemFacadeImplTest {

    private ItemDao itemDao;

    private ItemFacade itemFacade;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        itemDao = mock(ItemDao.class);
        itemFacade = new ItemFacadeImpl();
        Field itemDaoField = ItemFacadeImpl.class.getDeclaredField("itemDao");
        itemDaoField.setAccessible(true);
        itemDaoField.set(itemFacade, itemDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetItemByIdReturnsId () {
        Item expected = new Item();
        expected.setId(1L);
        expected.setTitle("Test Title");
        expected.setDescription("Test Description");
        expected.setGenre("Test Genre");
        expected.setCopy(13);

        when(itemDao.findById(1L)).thenReturn(expected);

        Item actual = itemFacade.getItemById(1L);

        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    public void testGetItemByIdReturnsNull () {
        Item actual = itemFacade.getItemById(2L);
        assertNull(actual);
    }
}