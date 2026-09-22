package com.rocs.video.rental;

import com.rocs.video.rental.app.model.item.Item;
import com.rocs.video.rental.data.connection.ConnectionHelper;
import com.rocs.video.rental.data.dao.item.ItemDao;
import com.rocs.video.rental.data.dao.item.impl.ItemDaoImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoRentalApp {

    public static void main(String[] args) {

        ItemDao itemDao = new ItemDaoImpl();
//        for(int i = 1; i <= 10; i++) {
//            Item item = itemDao.findById((long) i);
//            System.out.println(item);
//        }

//        List<Item> items = itemDao.findAllItems();
//        for(Item item : items) {
//            System.out.println(item);
//        }

        Scanner sc = new Scanner(System.in);
        Item item = new Item();
        String stringInput = "";
        Long longInput = 0L;
        int intInput = 0;

        System.out.println("Input movie data:");
        System.out.print("Enter ID: ");
        longInput = sc.nextLong();

        Item searchItem = itemDao.findById(longInput);
        if (searchItem == null) {
            System.out.println("No record found!");
            return;
        }

        itemDao.deleteItemById(longInput);

//        item.setId(longInput);
//        System.out.print("Enter Title: ");
//        stringInput = sc.nextLine();
//        stringInput = sc.nextLine();
//        item.setTitle(stringInput);
//        System.out.print("Enter Genre: ");
//        stringInput = sc.nextLine();
//        item.setGenre(stringInput);
//        System.out.print("Enter Description: ");
//        stringInput = sc.nextLine();
//        item.setDescription(stringInput);
//        System.out.print("Enter Copy: ");
//        intInput = sc.nextInt();
//        item.setCopy(intInput);
////        itemDao.addItem(item);
//        itemDao.updateItem(item);
//
//        System.out.println(item);
    }
}
