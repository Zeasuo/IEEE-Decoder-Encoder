package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		initUI(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void initUI(Stage stage) {
		//Pane
		GridPane root = new GridPane();
		
		//TextFields
		TextField input_num = new TextField();
		TextField output_num = new TextField();
		
		//Labels
		Label input_lab = new Label("Input:");
		Label output_lab = new Label("Output:");
		
		//Buttons
		Button convert = new Button("Convert");
		
		//CheckBoxs
		CheckBox input_dec = new CheckBox("Decimal Number");
		CheckBox input_floating = new CheckBox("Floating Point");
		
		//Attach to Scene
		root.add(input_lab, 0 ,0);
		root.add(input_num, 0, 1);
		root.add(input_dec, 1, 1);
		root.add(input_floating, 2, 1);
		root.add(output_lab, 0, 2);
		root.add(output_num, 0, 3);
		root.add(convert, 0, 4);
		
		stage.setTitle("IEEE Converter");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
