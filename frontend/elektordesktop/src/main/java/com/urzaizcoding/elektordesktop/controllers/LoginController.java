package com.urzaizcoding.elektordesktop.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.urzaizcoding.elektordesktop.App;
import com.urzaizcoding.ulangerproxy.graphics.BaseControllerLanguageHandlable;
import com.urzaizcoding.ulangerproxy.graphics.FXUtilities;
import com.urzaizcoding.ulangerproxy.graphics.GraphicFacilities;
import com.urzaizcoding.ulangerproxy.lang.LanguageParser;
import com.urzaizcoding.ulangerproxy.log.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController extends BaseControllerLanguageHandlable {
	
	static ArrayList<LanguageParser> availableLanguages;
	
	@SuppressWarnings("exports")
	public LoginController(ArrayList<LanguageParser> ravailableLanguages) throws Exception {
		super(ravailableLanguages.get(0));
		LoginController.availableLanguages = ravailableLanguages;
	}

//	@FXML
//	private AnchorPane root;
	
	@FXML
	private Label labelLogin;
	
	@FXML
	private Label labelClose;

	@FXML
	private TextField textFieldUserName;

	@FXML
	private PasswordField passwordFieldPassHidden;
	
	@FXML
	private ComboBox<String> comboBoxLanguages;

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
	
	private String errorNotification;

	@FXML
	void handleButtonLoginAction(ActionEvent event) {

		System.out.println("login cliked");
		GraphicFacilities.getNotificationStyle()
				.setCssStyleSheet(App.class.getResource("css/notification.css").toExternalForm());
		GraphicFacilities.getNotificationStyle().setAutoClosure(true);
		GraphicFacilities.showNotification((AnchorPane) root, errorNotification, null);

		Stage stage = (Stage) ((Parent) root).getScene().getWindow();
		try {
			AnchorPane parent = (AnchorPane) FXUtilities.loadFXML(App.class.getResource("fxml/root.fxml"), new RootController(getCurrentLanguage()));
			stage.setScene(new Scene(parent));
			stage.setMaximized(true);
		} catch (IOException e) {
			e.printStackTrace();
			Logger.loggerObject.writeError(getClass().getName(),
					"Unable to load root.fxml due to : \n" + Logger.getExceptionMessage(e));
		}
	}
	
	@FXML
	void handleComboBoxAction(ActionEvent event) {
		
		this.setCurrentLanguage(availableLanguages.stream().filter((l) -> l.getLanguageDescription().getCodeName()
				.equals(comboBoxLanguages.getSelectionModel().getSelectedItem())).findFirst().get());
		try {
			this.updateFieldsAnText();
		} catch (Exception e) {
			Logger.loggerObject.writeError(getClass().getName(), Logger.getExceptionMessage(e)+"\nError due to language changing");
		}
	}

	@FXML
	void handleCloseLabelClicked(MouseEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		textFieldPassVisible.textProperty().bindBidirectional(passwordFieldPassHidden.textProperty());
		textFieldPassVisible.visibleProperty().bindBidirectional(checkBoxShowPassword.selectedProperty());
		passwordFieldPassHidden.visibleProperty().bind(checkBoxShowPassword.selectedProperty().not());
		labelUserName.visibleProperty().bind(textFieldUserName.focusedProperty());
		labelPassword.visibleProperty()
				.bind(passwordFieldPassHidden.focusedProperty().or(textFieldPassVisible.focusedProperty()));
		comboBoxLanguages.getItems().addAll(availableLanguages.stream()
				.map((l) -> l.getLanguageDescription().getCodeName()).collect(Collectors.toList()));
		comboBoxLanguages.getSelectionModel().selectFirst();
		try {
			this.updateFieldsAnText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.loggerObject.writeError(getClass().getName(), Logger.getExceptionMessage(e)+"\nError due to language applying on start");
		}
	}

}
