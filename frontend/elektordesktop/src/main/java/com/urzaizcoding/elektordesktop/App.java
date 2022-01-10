package com.urzaizcoding.elektordesktop;

import static com.urzaizcoding.ulangerproxy.FXUtilities.buildSettingsFromProperties;
import static com.urzaizcoding.ulangerproxy.FXUtilities.loadFXML;
import static com.urzaizcoding.ulangerproxy.FXUtilities.loadProperties;
import static com.urzaizcoding.ulangerproxy.FXUtilities.sceneFromSettings;

import java.io.IOException;
import java.util.Properties;

import com.urzaizcoding.ulangerproxy.FXUtilities.StageSettings;
import com.urzaizcoding.ulangerproxy.exceptions.IncompletePathException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private static StageSettings settings;

	@Override
	public void start(@SuppressWarnings("exports") Stage stage) throws IOException, IncompletePathException {
		
		Properties p = loadProperties(App.class.getResource("home.properties").getFile());
		System.out.println(p);
		settings = buildSettingsFromProperties(p);
		settings.updatePath(App.class.getResource(settings.getFxmlPath()));
		scene = sceneFromSettings(settings);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(App.class.getResource(fxml)));
	}

	public static void main(String[] args) {
		launch();
	}

}