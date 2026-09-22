package com.rocs.video.rental.data.dao.item.impl;

import com.rocs.video.rental.app.model.item.Item;
import com.rocs.video.rental.data.connection.ConnectionHelper;
import com.rocs.video.rental.data.dao.item.ItemDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement statement;

    @Mock
    private ResultSet resultSet;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    private ItemDao itemDao;

    @BeforeEach
    public void setUp () throws SQLException {
        // Setup Phase
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(statement);
        itemDao = new ItemDaoImpl();
    }

    @AfterEach
    public void tearDown () {
        // Tear Down
        connectionHelper.close();
    }

    @Test
    public void testFindByIdReturnsAnItem () throws SQLException {
        // Setup Phase
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE);

        // Testing Phase
        Item item = itemDao.findById(1L);

        // Assertion Phase
        verify(connection, times(1)).prepareStatement(anyString());
        verify(statement, times(1)).setLong(anyInt(), anyLong());
        verify(statement, times(1)).executeQuery();
        verify(resultSet, times(1)).next();
        assertNotNull(item);
    }

    @Test
    public void testFindByIdReturnsNull () throws SQLException {
        // Setup Phase
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.FALSE);

        // Testing Phase
        Item item = itemDao.findById(1L);

        // Assertion Phase
        verify(connection, times(1)).prepareStatement(anyString());
        verify(statement, times(1)).setLong(anyInt(), anyLong());
        verify(statement, times(1)).executeQuery();
        verify(resultSet, times(1)).next();
        assertNull(item);
    }

}