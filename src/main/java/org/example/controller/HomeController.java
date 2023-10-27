package org.example.controller;
import org.example.controller.impl.IHomeController;
import org.example.utils.AppException;
import org.example.utils.StringUtil;
import org.example.view.HomePage;

import static org.example.utils.AppInput.enterInt;
import static org.example.utils.Utils.println;
import static org.example.utils.Utils.println;

public class HomeController implements IHomeController {
    private final HomePage homePage;
    private final AuthController authController;
    private final CategoryController categoryController;
    private final ProductController productController;
    private final CartController cartController;

    public HomeController(AuthController authController) {
        homePage = new HomePage();
        this.authController = authController;
        productController = new ProductController();
        categoryController = new CategoryController(this);
        cartController = new CartController();
    }


    @Override
    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtil.ENTER_CHOICE);
            if (choice == 1) {
                categoryController.printMenu();
            } else if (choice == 2) {
                productController.showProducts(0);
            } else if (choice == 3) {
                cartController.printCart();
            } else if (choice == 4) {

            } else if (choice == 5) {
                authController.authMenu();
            } else {
                invalidChoice(new AppException(StringUtil.INVALID_CHOICE));
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
