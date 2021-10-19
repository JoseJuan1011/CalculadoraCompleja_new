package dad.calculadoraCompleja.resources;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real;
	
	private DoubleProperty imaginario;
	
	public Complejo() {
		real = new SimpleDoubleProperty();
		imaginario = new SimpleDoubleProperty();
	}

	public Complejo(double real, double imaginario) {
		super();
		this.real = new SimpleDoubleProperty(real);
		this.imaginario = new SimpleDoubleProperty(imaginario);
	}
	
	public static Complejo sumaComplejo(Complejo n1, Complejo n2) {
		return new Complejo(n1.getReal()+n2.getReal(), n1.getImaginario()+n2.getImaginario());
	}
	
	public static Complejo restaComplejo(Complejo n1, Complejo n2) {
		return new Complejo(n1.getReal()-n2.getReal(), n1.getImaginario()-n2.getImaginario());
	}
	
	public static Complejo multiplicacionComplejo(Complejo n1, Complejo n2) {
		// (a,b) * (c,d) = (ac - bd, ad - bc)
		return new Complejo(
				(n1.getReal()*n2.getReal()) - (n1.getImaginario()*n2.getImaginario()),
				(n1.getReal()*n2.getImaginario()) + (n1.getImaginario()*n2.getReal())
		);
	}
	
	public static Complejo divisionComplejo(Complejo n1, Complejo n2) {
		// (a,b) / (c,d) = 
		// real = (ac + bd / c2 + d2)
		// imaginario = (bc - ad / c2 + d2)
		return new Complejo(
				( 
					(n1.getReal()*n2.getReal()) + (n1.getImaginario()*n2.getImaginario())
				) 
					/ 
				(
					Math.pow(n2.getReal(), 2) + Math.pow(n2.getImaginario(), 2)
				)
				,
				(
					(n1.getImaginario()*n2.getReal()) -	(n1.getReal()*n2.getImaginario())
				)
					/
				(
					Math.pow(n2.getReal(), 2) + Math.pow(n2.getImaginario(), 2)
				)
		);
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}
	

	public final double getReal() {
		return this.realProperty().get();
	}
	

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}
	

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}
	

	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}
	
	@Override
	public String toString() {
		return "Complejo = ("+getReal()+","+getImaginario()+")";
	}
}
