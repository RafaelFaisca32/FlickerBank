module com.bank.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens com.bank.app to javafx.fxml;
    exports com.bank.app;
    exports com.bank.app.Controllers;
    exports com.bank.app.Controllers.Admin;
    exports com.bank.app.Controllers.Client;
    exports com.bank.app.Models;
    exports com.bank.app.Views;
}
