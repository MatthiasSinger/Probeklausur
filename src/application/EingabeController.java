package application;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EingabeController {

	
	@FXML Button butSpeichern;
	@FXML Label labDurchschnitt;
	@FXML Label labKosten;
	@FXML Label labGesamt;
	@FXML DatePicker datePicker1;
	@FXML TextField tfPreis;
	@FXML TextField tfGetankt;
	@FXML TextField tfGefahren;
	
	private double gefahren;
	private double preis;
	private double getankt;
	private double durchschnittVerbrauch;
	private double kostenProKm;
	private double gesamtKosten;
	private LocalDate datum;
	
	private MainController mc;
	
	@FXML
	public void initialize()
	{
		tfPreis.textProperty().addListener(cl -> {
			this.preis = (tfPreis.getText().isEmpty()) ? 0 : Double.valueOf(tfPreis.getText());
			calculate();
		});
		tfGetankt.textProperty().addListener(cl -> {
			this.getankt = (tfGetankt.getText().isEmpty()) ? 0 : Double.valueOf(tfGetankt.getText());
			calculate();
		});
		tfGefahren.textProperty().addListener(cl -> {
			this.gefahren = (tfGefahren.getText().isEmpty()) ? 0 : Double.valueOf(tfGefahren.getText());
			calculate();
		});
		datePicker1.valueProperty().addListener(cl -> {
			this.datum = datePicker1.getValue();
		});
	}
	
	public void setMC(MainController mc)
	{
		this.mc = mc;
	}
	
	private void calculate()
	{
		//Gesamtkosten
		if (!tfPreis.getText().isEmpty() && !tfGetankt.getText().isEmpty()) 
		{
			this.gesamtKosten = this.preis * this.getankt;
			labGesamt.setText(String.valueOf(this.gesamtKosten));
		}
		else
		{
			labGesamt.setText("");
		}
		//Durchschnittsverbrauch
		if (!tfGefahren.getText().isEmpty() && !tfGetankt.getText().isEmpty())
		{
			this.durchschnittVerbrauch = this.getankt / this.gefahren;
			labDurchschnitt.setText(String.valueOf(this.durchschnittVerbrauch));
		}
		else
		{
			labDurchschnitt.setText("");
		}
		//Kosten pro KM
		if (!tfGefahren.getText().isEmpty() && !tfGetankt.getText().isEmpty() && !tfPreis.getText().isEmpty())
		{
			this.kostenProKm = (this.preis * this.getankt) / this.gefahren;
			labKosten.setText(String.valueOf(this.kostenProKm));
		}
		else
		{
			labGesamt.setText("");
		}
	}

	@FXML public void speichern() 
	{
		Betankung b = new Betankung(gefahren, getankt, preis, datum, gesamtKosten, durchschnittVerbrauch, kostenProKm);
		mc.addToList(b);
	}
	
}
