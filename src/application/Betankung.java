package application;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;

public class Betankung {
	public Betankung(double gefahreneStrecke, double getankterKraftstoff, double preisProLiter, LocalDate datum,
			double gesamtkosten, double durchschnittVerbrauch, double kostenProKM)
	{
		super();
		this.gefahreneStrecke = gefahreneStrecke;
		this.getankterKraftstoff = getankterKraftstoff;
		this.preisProLiter = preisProLiter;
		this.datum = datum;
		this.gesamtkosten = gesamtkosten;
		this.durchschnittVerbrauch = durchschnittVerbrauch;
		this.kostenProKM = kostenProKM;
	}
	private double gefahreneStrecke;
	private double getankterKraftstoff;
	private double preisProLiter ;
	private LocalDate datum;
	private double gesamtkosten;
	private double durchschnittVerbrauch;
	private double kostenProKM;
	
	public String toString()
	{
		return datum.toString() + " | " + String.valueOf(this.gefahreneStrecke) + " | " + String.valueOf(this.getankterKraftstoff) + " | " +
				String.valueOf(this.preisProLiter) + " | " + String.valueOf(this.gesamtkosten) + " | " + String.valueOf(this.durchschnittVerbrauch) + " | " +
				String.valueOf(this.kostenProKM);
	}

}
