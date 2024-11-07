package com.bank.app.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import com.bank.app.Models.Client;
import com.bank.app.Models.Model;
import com.bank.app.Views.ClientCellFactory;

public class ClientsController implements Initializable {
    public ListView<Client> clients_listview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initClientsList();
        clients_listview.setItems(Model.getInstance().getClients());
        clients_listview.setCellFactory(e -> new ClientCellFactory());
    }

    private void initClientsList() {
        if (Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClients();
        }
    }
}
