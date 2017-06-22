package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private void openDataEntry() throws IOException
	{
		Stage dialog = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EingabeView.fxml"));
		Parent root = loader.load();
		dialog.setScene(new Scene(root));
		dialog.showAndWait();
	}
}
