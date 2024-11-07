package com.bank.app.Controllers.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import com.bank.app.Models.Model;

public class AdminController implements Initializable {

    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, old, newV) -> {
            switch(newV) {
                case CLIENTS -> {
                    try {
                        admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case DEPOSIT -> {
                    try {
                        admin_parent.setCenter(Model.getInstance().getViewFactory().getDepositView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    try {
                        admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
