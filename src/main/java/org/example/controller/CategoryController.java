package org.example.controller;

import org.example.models.Category;
import org.example.utils.AppException;
import org.example.utils.StringUtil;
import org.example.view.CategoryPage;

import java.util.ArrayList;

import static org.example.utils.AppInput.enterInt;
import static org.example.utils.Utils.println;
import static org.example.utils.loadUtils.getCategories;

public class CategoryController {
    private final CategoryPage categoryPage;
    private final ProductController productController;
    private final HomeController homeController;

    public CategoryController(HomeController homeController) {
        categoryPage = new CategoryPage();
        productController = new ProductController();
        this.homeController = homeController;
    }

    public void printMenu() {
        ArrayList<Category> categories = getCategories();
        categoryPage.printMenu(categories);

        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);

            if (choice == 99) {
                homeController.printMenu();
            } else {
                int validCategoryId = 0;

                for (Category category : categories) {
                    if (category.getId() == choice) {
                        validCategoryId = category.getId();
                        break;
                    }
                }

                if (validCategoryId != 0) {
                    productController.showProducts(validCategoryId);
                } else {
                    invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
                }
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }
    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        printMenu();
    }
}
