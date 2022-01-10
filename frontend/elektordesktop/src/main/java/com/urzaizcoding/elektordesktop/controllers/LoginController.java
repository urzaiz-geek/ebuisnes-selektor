package com.urzaizcoding.elektordesktop.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
	private AnchorPane root;

	@FXML
	private Label labelClose;

	@FXML
	private TextField textFieldUserName;

	@FXML
	private PasswordField passwordFieldPassHidden;

	@FXML
	private Label labelUserName;

	@FXML
	private Label labelPassword;

	@FXML
	private CheckBox checkBoxShowPassword;

	@FXML
	private Button buttonLogin;

	@FXML
	private ImageView imageViewSettings;

	@FXML
	private TextField textFieldPassVisible;

	private double xOffset;
	private double yOffset;

	@FXML
	void handleDragEvent(MouseEvent event) {

		Window stage = root.getScene().getWindow();
		stage.setX(event.getScreenX() - xOffset);
		stage.setY(event.getScreenY() - yOffset);
	}

	@FXML
	void handleMousePressedEvent(MouseEvent event) {
		xOffset = event.getSceneX();
		yOffset = event.getSceneY();
	}

	@FXML
	void handleCloseLabelClicked(MouseEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		textFieldPassVisible.textProperty().bindBidirectional(passwordFieldPassHidden.textProperty());
		textFieldPassVisible.visibleProperty().bindBidirectional(checkBoxShowPassword.selectedProperty());
		passwordFieldPassHidden.visibleProperty().bind(checkBoxShowPassword.selectedProperty().not());
	}

}
