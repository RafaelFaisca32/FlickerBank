package com.bank.app;

import java.io.IOException;

import javafx.stage.Stage;

import com.bank.app.Models.Model;

public class BankApplication extends javafx.application.Application {

    @Override
    public void start(Stage stage){
        try {
            Model.getInstance().getViewFactory().showLoginWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
