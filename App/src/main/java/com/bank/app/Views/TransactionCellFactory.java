package com.bank.app.Views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import com.bank.app.Controllers.Client.TransactionCellController;
import com.bank.app.Models.Transaction;

public class TransactionCellFactory extends ListCell<Transaction> {

    @Override
    protected void updateItem(Transaction transaction, boolean bool) {
        super.updateItem(transaction, bool);
        if(bool){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/Fxml/Client/TransactionCell.fxml"));
            TransactionCellController controller = new TransactionCellController(transaction);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            setText(null);
            setGraphic(null);
        }
    }
}
