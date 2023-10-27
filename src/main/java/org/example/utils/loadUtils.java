package org.example.utils;

import org.example.models.Category;
import org.example.models.Product;

import java.util.ArrayList;
public class loadUtils {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();

    public static void load() {
        Category dressCategory = new Category(1, "Dress");
        categories.add(dressCategory);
        Category mobileCategory = new Category(2, "Mobile");
        categories.add(mobileCategory);

        Product tShirtProduct = new Product(1, "Tshirt", "Tshirt", 100, 10, dressCategory);
        Product shirtProduct = new Product(2, "Shirt", "Shirt", 105, 10, dressCategory);
        products.add(tShirtProduct);
        products.add(shirtProduct);

        Product iphoneProduct = new Product(3, "iPhone", "iPhone", 1000, 10, mobileCategory);
        Product samsungProduct = new Product(4, "Samsung", "Samsung", 1005, 10, mobileCategory);
        products.add(iphoneProduct);
        products.add(samsungProduct);

    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
