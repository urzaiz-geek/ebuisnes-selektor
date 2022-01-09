module com.urzaizcoding.elektordektop {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.urzaizcoding.ulangerproxy;
	
    

    opens com.urzaizcoding.elektordektop to javafx.fxml;
    exports com.urzaizcoding.elektordektop;
}