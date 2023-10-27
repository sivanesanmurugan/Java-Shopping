package org.example.controller;

import org.example.controller.impl.IAppController;
import org.example.view.WelcomePage;

public class AppController implements IAppController {

    private final WelcomePage welcomePage;
    private final AuthController authController;

    public AppController() {
        welcomePage = new WelcomePage();
        authController = new AuthController(this);
    }

    @Override
    public void init()  {
        welcomePage.welcome();
        authController.authMenu();
    }

    public void printAuthMenu() {
        welcomePage.printAuthMenu();
    }
}
