package com.urzaizcoding.elektordesktop.controllers;

import java.io.IOException;

import com.urzaizcoding.elektordesktop.App;
import com.urzaizcoding.ulangerproxy.graphics.BaseControllerLanguageHandlable;
import com.urzaizcoding.ulangerproxy.graphics.FXUtilities;
import com.urzaizcoding.ulangerproxy.lang.LanguageParser;
import com.urzaizcoding.ulangerproxy.log.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootController extends BaseControllerLanguageHandlable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView imageViewHide;

	@FXML
	private ImageView imageViewRestore;

	@FXML
	private ImageView imageViewClose;

	@FXML
	private Label labelUserName;

	@FXML
	private ImageView imageViewUserPic;

	@FXML
	private Button buttonOrders;

	@FXML
	private Button buttonInventory;

	@FXML
	private Button buttonSales;

	@FXML
	private Button buttonClients;

	@FXML
	private Button buttonSuppliers;

	@FXML
	private Button buttonReports;

	@FXML
	private Button buttonHelp;

	@FXML
	private Button buttonSettings;

	@FXML
	private Button buttonLogout;

	@FXML
	private Label labelInfos;

	@SuppressWarnings("exports")
	public RootController(LanguageParser currentLanguage) {
		super(currentLanguage);
	}

	@FXML
	void handleButtonClientsAction(ActionEvent event) {
		try {
			AnchorPane parent = (AnchorPane) FXUtilities.loadFXML(App.class.getResource("fxml/clients.fxml"),
					new ClientsController(getCurrentLanguage()));
			rootPane.getChildren().add(parent);
			AnchorPane.setBottomAnchor(parent, 0.0);
			AnchorPane.setRightAnchor(parent, 0.0);
			AnchorPane.setTopAnchor(parent, 0.0);
			AnchorPane.setLeftAnchor(parent, 0.0);
		} catch (IOException e) {
			e.printStackTrace();
			Logger.loggerObject.writeError(getClass().getName(),
					"Unable to load clients.fxml due to : \n" + Logger.getExceptionMessage(e));
		}
	}

	@FXML
	void handleImageViewCloseClicked(MouseEvent event) {
		close();
	}

	@FXML
	void handleImageViewHideClicked(MouseEvent event) {
		hide();
	}

	@FXML
	void handleReduceImageViewClicked(MouseEvent event) {
		Stage stage = (Stage) root.getScene().getWindow();
		fullScreen(stage.maximizedProperty().not().get());
	}
}
