package com.bank.app.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.bank.app.Models.Model;
import com.bank.app.Views.AccountType;

public class LoginController implements Initializable {

    public Label payflick_address_label;
    public TextField payee_address_field;
    public TextField password_field;
    public Button login_btn;
    public Label error_lbl;
    public ChoiceBox<AccountType> acc_selector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getAccountType());
        acc_selector.valueProperty().addListener(observable -> setAcc_selector());
        login_btn.setOnAction(e -> {
            try {
                onLogin();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void onLogin() throws IOException {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if(Model.getInstance().getViewFactory().getAccountType().equals(AccountType.CLIENT)) {
            Model.getInstance().evaluateClientCred(payee_address_field.getText(), password_field.getText());
            if(Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                stage.close();
            } else {
                payee_address_field.clear();
                password_field.clear();
                error_lbl.setText("No Login Credentials found");
            }
        } else {
            Model.getInstance().evaluateAdminCred(payee_address_field.getText(), password_field.getText());
            if(Model.getInstance().getAdminLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showAdminWindow();
                stage.close();
            } else {
                payee_address_field.clear();
                password_field.clear();
                error_lbl.setText("No Login Credentials found");
            }
        }
    }

    private void setAcc_selector(){
        Model.getInstance().getViewFactory().setAccountType(acc_selector.getValue());
        if(acc_selector.getValue().equals(AccountType.ADMIN)) {
            payflick_address_label.setText("Username:");
        } else {
            payflick_address_label.setText("PayFlickr Address:");
        }
    }
}
