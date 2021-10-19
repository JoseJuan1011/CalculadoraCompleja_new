package dad.calculadoraCompleja;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	//view
	
	//VBox signosBox
	private ComboBox<String> signoComboBox; 
	
	//VBox datosBox
	//HBox N1Box
	private TextField realN1TextField;
	private TextField imaginarioN1TextField;
	
	//HBox N2Box
	private TextField realN2TextField;
	private TextField imaginarioN2TextField;
	
	//HBox resultadoBox
	private TextField realResultadoTextField;
	private TextField imaginarioResultadoTextField;
	
	//VBox igualBox
	private Button igualButton;
	
	private VBox signosBox;
	
	private HBox n1Box;
	private HBox n2Box;
	private HBox resultadoBox;
	
	private VBox datosBox;
	
	private VBox igualBox;
	
	//model
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		signoComboBox = new ComboBox<String>();
		signoComboBox.getItems().addAll("+","-","*","/");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
