package com.bank.app.Controllers.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import com.bank.app.Models.Model;
import com.bank.app.Views.ClientMenuOptions;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(actionEvent -> onDashboard());
        transaction_btn.setOnAction(actionEvent -> onTransactions());
        accounts_btn.setOnAction(actionEvent -> onAccounts());
        logout_btn.setOnAction(actionEvent -> {
            try {
                onLogout();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }

    private void onLogout() throws IOException {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setClientLoginSuccessFlag(false);
    }
}
