package com.rocs.video.rental.data.dao.item.impl;

import com.rocs.video.rental.app.model.item.Item;
import com.rocs.video.rental.data.connection.ConnectionHelper;
import com.rocs.video.rental.data.dao.item.ItemDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public Item findById (Long id) {
        Item item = null;

        try (Connection conn = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ITEM WHERE ID=?");
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                item = new Item();
                item.setId(rs.getLong("ID"));
                item.setTitle(rs.getString("TITLE"));
                item.setGenre(rs.getString("GENRE"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setCopy(rs.getInt("COPY"));
            }

        } catch (SQLException e) {
            System.out.println("An exception was thrown while finding an item. " + e.getMessage());
        }

        return item;
    }

    @Override
    public List<Item> findAllItems () {
        List<Item> items = new ArrayList<>();

        try (Connection conn = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ITEM");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getLong("ID"));
                item.setTitle(rs.getString("TITLE"));
                item.setGenre(rs.getString("GENRE"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setCopy(rs.getInt("COPY"));

                items.add(item);
            }

        } catch (SQLException e) {
            System.out.println("An exception was thrown while finding an item. " + e.getMessage());
        }

        return items;
    }

    @Override
    public boolean addItem (Item item) {
        boolean success = false;

        try (Connection conn = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO ITEM (ID, TITLE, GENRE, DESCRIPTION, COPY) VALUES (?, ?, ?, ?, ?)");
            stmt.setLong(1, item.getId());
            stmt.setString(2, item.getTitle());
            stmt.setString(3, item.getGenre());
            stmt.setString(4, item.getDescription());
            stmt.setInt(5, item.getCopy());
            stmt.executeUpdate();
            success = true;

        } catch (SQLException e) {
            System.out.println("There was an exception in adding an item. " + e.getMessage());
        }

        return success;
    }

    @Override
    public int updateItem(Item item) {
        int updatedRows = 0;
        try (Connection conn = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE ITEM SET TITLE=?, GENRE=?, DESCRIPTION=?, COPY=? WHERE ID=?");
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getGenre());
            stmt.setString(3, item.getDescription());
            stmt.setInt(4, item.getCopy());
            stmt.setLong(5, item.getId());
            updatedRows = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There was an exception in adding an item. " + e.getMessage());
        }

        return updatedRows;
    }

    @Override
    public int deleteItemById(Long id) {
        int deletedRows = 0;

        try (Connection conn = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM ITEM WHERE ID = ?");
            stmt.setLong(1, id);

            deletedRows = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("There was an exception in deleting an item. " + e.getMessage());
        }

        return deletedRows;
    }


}
