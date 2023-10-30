package org.example.view;

import org.example.models.CartProduct;
import org.example.models.Cart;
import org.example.models.User;
import org.example.util.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.util.FileUtil.getFilePath;
import static org.example.util.UserUtil.getLoggedUser;
import static org.example.util.Utils.println;

public class CartPage {
    public void printEmptyCart() {
        println(StringUtils.EMPTY_CART);
    }

    public void printCart(ArrayList<CartProduct> cartProducts) {
        println(StringUtils.CART);
        double total = 0;
        for (CartProduct cartProduct : cartProducts) {
            total += cartProduct.getCount() * cartProduct.getProduct().getPrice();
            println(cartProduct.getProduct().getTitle() + " x " + cartProduct.getCount());
        }
        println(StringUtils.TOTAL_PRICE + total);
//        User loggedInUser = getLoggedUser();
//        try {
//            String fileName = getFilePath() + loggedInUser.getId() + "-Cart"+ ".csv";
//            FileWriter fileWriter = new FileWriter(fileName);
//            fileWriter.append("Product Title,Quantity,Price\n");
//            for (CartProduct cartProduct : loggedInUser.getUserCart().getCartProducts()) {
//                String productTitle = cartProduct.getProduct().getTitle();
//                int quantity = cartProduct.getCount();
//                double price = total;
//                String csvLine = String.format("%s,%d,%.2f\n", productTitle, quantity, price);
//
//                fileWriter.append(csvLine);
//                total += price;
//            }
//            fileWriter.write(String.format("Total,%.2f\n", total));
//            fileWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    public void printCheckout() {
        println("#---------------------#");
        println(StringUtils.PRINT_CHECKOUT);
    }
    public void printBack() {
        println(StringUtils.BACK_OPTION);
    }
}
