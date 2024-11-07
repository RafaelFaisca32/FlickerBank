package com.bank.app.Views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import com.bank.app.Controllers.Client.ClientCellController;
import com.bank.app.Controllers.Client.TransactionCellController;
import com.bank.app.Models.Client;
import com.bank.app.Models.Transaction;

public class ClientCellFactory extends ListCell<Client> {

    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/ClientCell.fxml"));
            ClientCellController controller = new ClientCellController(client);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
