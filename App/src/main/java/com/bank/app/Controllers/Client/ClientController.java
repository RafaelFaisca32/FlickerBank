package com.bank.app.Controllers.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import com.bank.app.Models.Model;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getSelectedMenuItem().addListener((observableValue, old, newV) -> {
            switch(newV){
                case TRANSACTIONS -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case ACCOUNTS -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    try {
                        client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } );
    }
}
