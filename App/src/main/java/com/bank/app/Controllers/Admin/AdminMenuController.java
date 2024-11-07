package com.bank.app.Controllers.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import com.bank.app.Models.Model;
import com.bank.app.Views.AdminMenuOptions;
import com.bank.app.Views.ClientMenuOptions;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        create_client_btn.setOnAction(actionEvent -> onCreateClient());
        clients_btn.setOnAction(actionEvent -> onClients());
        deposit_btn.setOnAction(actionEvent -> onDeposit());
        logout_btn.setOnAction(actionEvent -> {
            try {
                onLogout();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENTS);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout() throws IOException {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();
        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
}
