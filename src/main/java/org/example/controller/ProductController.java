package org.example.controller;

import org.example.controller.impl.IProductController;
import org.example.models.Product;
import org.example.util.AppException;
import org.example.util.LoadUtils;
import org.example.util.StringUtils;
import org.example.view.ProductsPage;

import java.util.ArrayList;

import static org.example.util.AppInput.enterInt;
import static org.example.util.Utils.println;

public class ProductController implements IProductController {
    private int catId = 0;
    private final HomeController homeController;
    private final ProductsPage productsPage;
    private final CartController cartController;

    public ProductController(HomeController homeController) {
        this.homeController = homeController;
        this.productsPage = new ProductsPage();
        this.cartController =new CartController(homeController);
    }

    @Override
    public void showProducts(int catId) {

        this.catId = catId;
        ArrayList<Product> products = LoadUtils.getProducts();
        ArrayList<Product> catProducts = new ArrayList<>();
        for(Product product:products){
            if(product.getCategory().getId()==catId){
                catProducts.add(product);
            }
        }
        productsPage.printProducts(catProducts);
        try {
            showAllProducts();
            int choice = enterInt(StringUtils.ENTER_CHOICE);
            int validProductId = 0;

            if (choice == 99) {
                homeController.printMenu();
            } else {
                for (Product product : products) {
                    if (product.getId() == choice) {
                        validProductId = product.getId();
                        break;
                    }
                }

                if (validProductId != 0) {
                    cartController.addToCart(validProductId);
                    productsPage.printSuccess();
                    showProducts(catId);
                } else {
                    invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
                }
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    @Override
    public void showAllProducts() {
        ArrayList<Product> products = LoadUtils.getProducts();
        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.addAll(products);
        productsPage.printAllProducts(allProducts);
    }
    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        showProducts(catId);
    }
}
