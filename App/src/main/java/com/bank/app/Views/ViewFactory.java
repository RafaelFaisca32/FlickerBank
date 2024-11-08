package com.bank.app.Views;

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.bank.app.Controllers.Admin.AdminController;
import com.bank.app.Controllers.Client.ClientController;

public class ViewFactory {

    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositView;
    private final ObjectProperty<ClientMenuOptions> selectedMenuItem;
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AccountType accountType;

    public ViewFactory() {
        this.accountType = AccountType.CLIENT;
        this.selectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public ObjectProperty<ClientMenuOptions> getSelectedMenuItem() {
        return selectedMenuItem;
    }

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AnchorPane getDashboardView() throws IOException {
        if(dashboardView == null) {
            dashboardView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/Dashboard.fxml")).load();
        }
        return dashboardView;
    }

    public AnchorPane getTransactionsView() throws IOException {
        if(transactionsView == null) {
            transactionsView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/Transactions.fxml")).load();
        }
        return transactionsView;
    }

    public AnchorPane getAccountsView() throws IOException {
        if(accountsView == null) {
            accountsView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/Accounts.fxml")).load();
        }
        return accountsView;
    }

    public AnchorPane getCreateClientView() throws IOException {
        if(createClientView == null) {
            createClientView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Admin/CreateClient.fxml")).load();
        }
        return createClientView;
    }

    public AnchorPane getClientsView() throws IOException {
        if(clientsView == null) {
            clientsView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Admin/Clients.fxml")).load();
        }
        return clientsView;
    }

    public AnchorPane getDepositView() throws IOException {
        if(depositView == null) {
            depositView = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Admin/Deposit.fxml")).load();
        }
        return depositView;
    }

    public void showLoginWindow() throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Login.fxml"));
       Scene scene = new Scene(loader.load());
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/Logo.png"))));
       stage.setResizable(false);
       stage.setTitle("Login");
       stage.show();
    }

    public void showClientWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/Client.fxml"));
        ClientController controller = new ClientController();
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/Logo.png"))));
        stage.setResizable(false);
        stage.setTitle("FlickerBank");
        stage.show();
    }

    public void showAdminWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/Logo.png"))));
        stage.setResizable(false);
        stage.setTitle("FlickerBank");
        stage.show();
    }

    public void showMessageWindow(String pAddress, String messageText) {
        StackPane pane = new StackPane();
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Label sender = new Label(pAddress);
        Label message = new Label(messageText);
        hBox.getChildren().addAll(sender, message);
        pane.getChildren().add(hBox);
        Scene scene = new Scene(pane, 300, 100);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Message");
        stage.setScene(scene);
        stage.show();
    }
}
