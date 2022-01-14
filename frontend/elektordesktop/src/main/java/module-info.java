module com.urzaizcoding.elektordesktop {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.urzaizcoding.ulangerproxy;
	requires javafx.base;

    opens com.urzaizcoding.elektordesktop to javafx.fxml;
    exports com.urzaizcoding.elektordesktop;
    exports com.urzaizcoding.elektordesktop.controllers;
    opens com.urzaizcoding.elektordesktop.controllers to javafx.fxml,com.urzaizcoding.ulangerproxy;
}