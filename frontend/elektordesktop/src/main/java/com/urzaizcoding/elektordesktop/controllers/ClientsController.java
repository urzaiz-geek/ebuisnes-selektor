package com.urzaizcoding.elektordesktop.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.urzaizcoding.ulangerproxy.graphics.BaseControllerLanguageHandlable;
import com.urzaizcoding.ulangerproxy.lang.LanguageParser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClientsController extends BaseControllerLanguageHandlable {

	@FXML
	private Button addClientButton;

	@FXML
	private Button editClientButton;

	@FXML
	private Button deleteClientButton;

	@FXML
	private Button reloadButton;

	@FXML
	private TextField searchTextField;

	@FXML
	private TableView<?> tableViewDisplayClients;
	
	@FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> phoneColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> ordersColumn;


	@FXML
	private Pagination clientPagination;

	@SuppressWarnings("exports")
	public ClientsController(LanguageParser currentLanguage) {
		super(currentLanguage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		nameColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.2));
		emailColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.19));
		addressColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.17));
		typeColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.12));
		phoneColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.2));
		ordersColumn.prefWidthProperty().bind(tableViewDisplayClients.widthProperty().multiply(0.12));
	}
	
	
}
