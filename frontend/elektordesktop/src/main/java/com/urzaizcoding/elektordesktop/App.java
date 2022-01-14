package com.urzaizcoding.elektordesktop;

import static com.urzaizcoding.ulangerproxy.graphics.FXUtilities.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import com.urzaizcoding.elektordesktop.controllers.LoginController;
import com.urzaizcoding.ulangerproxy.exceptions.ContextClassNotProvidedException;
import com.urzaizcoding.ulangerproxy.exceptions.IncompletePathException;
import com.urzaizcoding.ulangerproxy.graphics.FXUtilities.StageSettings;
import com.urzaizcoding.ulangerproxy.lang.ApplicationDescription;
import com.urzaizcoding.ulangerproxy.lang.LanguageParser;

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
	@SuppressWarnings("exports") public static final ApplicationDescription desc;
	
	
	static {
		desc = new ApplicationDescription("elektorDesktop", "0.0.1-SNAPSHOT");
	}
	

	@Override
	public void start(@SuppressWarnings("exports") Stage stage) throws IOException, IncompletePathException, URISyntaxException, Exception, ClassNotFoundException, ContextClassNotProvidedException {
		
		Properties p = loadProperties(App.class.getResource("home.properties").getFile());
		
		
		settings = buildSettingsFromProperties(p);
		ArrayList<LanguageParser> retrievedLanguages = availableLanguagesFromSettings(settings, desc);
		
		settings.setController(new LoginController(retrievedLanguages));
		
		
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