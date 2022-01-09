package com.urzaizcoding.elektordektop;

import java.io.IOException;

import java.util.Properties;

import com.urzaizcoding.ulangerproxy.FXUtilities.StageSettings;
import static com.urzaizcoding.ulangerproxy.FXUtilities.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private static StageSettings settings;

	@Override
	public void start(@SuppressWarnings("exports") Stage stage) throws IOException {

		Properties p = loadProperties(getClass(), null);
		settings = buildSettingsFromProperties(p);

		scene = sceneFromSettings(getClass(), settings);
		stage.setScene(scene);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(App.class, fxml));
	}

	public static void main(String[] args) {
		launch();
	}

}