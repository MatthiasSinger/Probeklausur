package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;

public class MainController {

	
	
	@FXML ListView<Betankung> listView1;
	@FXML Button butAdd;
	@FXML Button butDelete;
	
	@FXML
	private void openDataEntry() throws IOException
	{
		Stage dialog = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EingabeView.fxml"));
		Parent root = loader.load();
		EingabeController ec = loader.getController();
		ec.setMC(this);
		dialog.setScene(new Scene(root));
		dialog.showAndWait();
	}
	
	public void addToList(Betankung b)
	{
		listView1.getItems().add(b);
	}

	@FXML public void delete() 
	{
		int index = listView1.getSelectionModel().getSelectedIndex();
		if (index > -1)
		{
			listView1.getItems().remove(index);
		}
	}
}
