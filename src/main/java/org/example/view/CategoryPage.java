package org.example.view;

import org.example.models.Category;
import org.example.util.StringUtils;

import java.util.ArrayList;

import static org.example.util.Utils.println;

public class CategoryPage {
    public void printMenu(ArrayList<Category> categories) {
        try {
            println("#---------------------#");
            println(StringUtils.CATEGORY_MENU);
            println("#---------------------#");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Category cat:categories){
            System.out.println(cat.getId()+" "+cat.getCategoryName());
        }
        println(StringUtils.BACK_OPTION);
    }
}
