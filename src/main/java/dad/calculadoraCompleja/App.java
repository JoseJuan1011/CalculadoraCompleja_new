package dad.calculadoraCompleja;

import dad.calculadoraCompleja.resources.Complejo;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class App extends Application {

	// model

	private DoubleProperty realN1Property = new SimpleDoubleProperty(0);
	private DoubleProperty imaginarioN1Property = new SimpleDoubleProperty(0);

	private DoubleProperty realN2Property = new SimpleDoubleProperty(0);
	private DoubleProperty imaginarioN2Property = new SimpleDoubleProperty(0);

	private DoubleProperty realResultadoProperty = new SimpleDoubleProperty(0);
	private DoubleProperty imaginarioResultadoProperty = new SimpleDoubleProperty(0);

	// view

	// VBox signosBox
	private ComboBox<String> signoComboBox;

	// VBox datosBox
	// HBox N1Box
	private TextField realN1TextField;
	private TextField imaginarioN1TextField;

	// HBox N2Box
	private TextField realN2TextField;
	private TextField imaginarioN2TextField;

	// HBox resultadoBox
	private TextField realResultadoTextField;
	private TextField imaginarioResultadoTextField;

//	//VBox igualBox
//	private Button igualButton;
//	
	private VBox signosBox;

	private HBox n1Box;
	private HBox n2Box;
	private HBox resultadoBox;

	private VBox datosBox;

//	private VBox igualBox;
//	
	private HBox root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		signoComboBox = new ComboBox<String>();
		signoComboBox.getItems().addAll("+", "-", "*", "/");

		signosBox = new VBox(signoComboBox);
		signosBox.setAlignment(Pos.CENTER_RIGHT);

		realN1TextField = new TextField("0");
		realN1TextField.setMaxWidth(50);
		realN1TextField.setAlignment(Pos.CENTER);

		imaginarioN1TextField = new TextField("0");
		imaginarioN1TextField.setMaxWidth(50);
		imaginarioN1TextField.setAlignment(Pos.CENTER);

		n1Box = new HBox(realN1TextField, new Label("+"), imaginarioN1TextField, new Label("i"));
		n1Box.setSpacing(5);

		realN2TextField = new TextField("0");
		realN2TextField.setMaxWidth(50);
		realN2TextField.setAlignment(Pos.CENTER);

		imaginarioN2TextField = new TextField("0");
		imaginarioN2TextField.setMaxWidth(50);
		imaginarioN2TextField.setAlignment(Pos.CENTER);

		n2Box = new HBox(realN2TextField, new Label("+"), imaginarioN2TextField, new Label("i"));
		n2Box.setSpacing(5);

		realResultadoTextField = new TextField("0");
		realResultadoTextField.setMaxWidth(50);
		realResultadoTextField.setAlignment(Pos.CENTER);
		realResultadoTextField.setDisable(true);

		imaginarioResultadoTextField = new TextField("0");
		imaginarioResultadoTextField.setMaxWidth(50);
		imaginarioResultadoTextField.setAlignment(Pos.CENTER);
		imaginarioResultadoTextField.setDisable(true);

		resultadoBox = new HBox(realResultadoTextField, new Label("+"), imaginarioResultadoTextField, new Label("i"));
		resultadoBox.setSpacing(5);

		datosBox = new VBox(n1Box, n2Box, new Separator(), resultadoBox);
		datosBox.setAlignment(Pos.CENTER);

		root = new HBox(signosBox, datosBox);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Calculadora Compleja");
		primaryStage.setScene(scene);
		primaryStage.show();

		realN1TextField.textProperty().bindBidirectional(realN1Property, new NumberStringConverter());
		imaginarioN1TextField.textProperty().bindBidirectional(imaginarioN1Property, new NumberStringConverter());

		realN2TextField.textProperty().bindBidirectional(realN2Property, new NumberStringConverter());
		imaginarioN2TextField.textProperty().bindBidirectional(imaginarioN2Property, new NumberStringConverter());

		signoComboBox.getSelectionModel().selectedItemProperty().addListener((obv, ov, nv) -> {
			Complejo complejo = operacionSwitch(nv);
			realResultadoProperty.set(complejo.getReal());
			imaginarioResultadoProperty.set(complejo.getImaginario());
		});

		realResultadoTextField.textProperty().bindBidirectional(realResultadoProperty, new NumberStringConverter());
		imaginarioResultadoTextField.textProperty().bindBidirectional(imaginarioResultadoProperty,
				new NumberStringConverter());
	}
	
	private Complejo operacionSwitch(String nv) {
		switch (nv) {
		case "+":
			return Complejo.sumaComplejo(new Complejo(realN1Property.get(), imaginarioN1Property.get()),
					new Complejo(realN2Property.get(), imaginarioN2Property.get()));
		case "-":
			return Complejo.restaComplejo(new Complejo(realN1Property.get(), imaginarioN1Property.get()),
					new Complejo(realN2Property.get(), imaginarioN2Property.get()));
		case "*":
			return Complejo.multiplicacionComplejo(
					new Complejo(realN1Property.get(), imaginarioN1Property.get()),
					new Complejo(realN2Property.get(), imaginarioN2Property.get()));
		case "/":
			return Complejo.divisionComplejo(new Complejo(realN1Property.get(), imaginarioN1Property.get()),
					new Complejo(realN2Property.get(), imaginarioN2Property.get()));
		default:
			return new Complejo();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
