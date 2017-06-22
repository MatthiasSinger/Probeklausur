package application;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;

public class Betankung {
	private DoubleProperty gefahreneStrecke;
	private DoubleProperty getankterKraftstoff;
	private DoubleProperty preisProLiter ;
	private LocalDate datum;
	private DoubleProperty bezahlt;
	private DoubleProperty durchschnittVerbrauch;
	private DoubleProperty kostenProKM;
	
	public Betankung(double gefahreneStrecke,
			double getankterKraftstoff, double preisProLiter,
			LocalDate datum) {
		this.gefahreneStrecke.set(gefahreneStrecke);
		this.getankterKraftstoff.set(getankterKraftstoff);
		this.preisProLiter.set(preisProLiter);
		this.datum = datum;
		
		bezahlt.bind(this.getankterKraftstoff.multiply(this.preisProLiter));
		durchschnittVerbrauch.bind(this.gefahreneStrecke.divide(getankterKraftstoff));
		kostenProKM.bind((this.getankterKraftstoff.multiply(preisProLiter)).divide(this.gefahreneStrecke));
	}
	
	public String toString()
	{
		return datum.toString() + " | " + gefahreneStrecke.toString() + " | " +preisProLiter.toString() + " | " +
				getankterKraftstoff.toString() + " | " + durchschnittVerbrauch.toString() + " | " + 
				bezahlt.toString() + " | " + kostenProKM.toString();
	}
	
	

}
