package application;

import java.text.NumberFormat;
import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class EingabeController {

	@FXML VBox rootVBox;
	@FXML Button butSpeichern;
	@FXML Label labDurchschnitt;
	@FXML Label labKosten;
	@FXML Label labGesamt;
	@FXML DatePicker datePicker1;
	@FXML TextField tfPreis;
	@FXML TextField tfGetankt;
	@FXML TextField tfGefahren;
	
	private DoubleProperty gefahren;
	private DoubleProperty preis;
	private DoubleProperty getankt;
	private DoubleProperty durchschnittVerbrauch;
	private DoubleProperty kostenProKm;
	private DoubleProperty gesamtKosten;
	private LocalDate datum;
	
	private MainController mc;
	
	@FXML
	public void initialize()
	{
		this.gefahren = new SimpleDoubleProperty();
		this.preis = new SimpleDoubleProperty();
		this.getankt = new SimpleDoubleProperty();
		this.durchschnittVerbrauch = new SimpleDoubleProperty();
		this.kostenProKm = new SimpleDoubleProperty();
		this.gesamtKosten = new SimpleDoubleProperty();
		
		Bindings.bindBidirectional(tfGefahren.textProperty(),this.gefahren,new NumberStringConverter());
		Bindings.bindBidirectional(tfGetankt.textProperty(),this.getankt,new NumberStringConverter());
		Bindings.bindBidirectional(tfPreis.textProperty(),this.preis,new NumberStringConverter());
		
		this.gesamtKosten.bind(this.getankt.multiply(this.preis));
		Bindings.bindBidirectional(labGesamt.textProperty(), this.gesamtKosten, new NumberStringConverter());
		
		this.durchschnittVerbrauch.bind(this.getankt.divide(this.gefahren));
		Bindings.bindBidirectional(labDurchschnitt.textProperty(), this.durchschnittVerbrauch,new NumberStringConverter());
		
		this.kostenProKm.bind(this.gesamtKosten.divide(this.gefahren));
		Bindings.bindBidirectional(labKosten.textProperty(), this.kostenProKm, new NumberStringConverter());
		
		datePicker1.valueProperty().addListener(cl -> {
			this.datum = datePicker1.getValue();
		});
	}
	
	public void setMC(MainController mc)
	{
		this.mc = mc;
	}
	

	@FXML 
	private void speichern() 
	{
		Betankung b = new Betankung(gefahren.doubleValue(), getankt.doubleValue(), preis.doubleValue(),
				datum, gesamtKosten.doubleValue(), durchschnittVerbrauch.doubleValue(), kostenProKm.doubleValue());
		mc.addToList(b);
		close();
	}
	
	@FXML
	private void cancel()
	{
		close();
	}

	private void close()
	{
		((Stage) rootVBox.getScene().getWindow()).close();
	}
	
}
