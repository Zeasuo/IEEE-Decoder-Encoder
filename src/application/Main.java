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
		Label note = new Label("Special Value: Enter 'NaN', 'infinity', or '-inifinity' to get corresponding IEEE754 values (Case Sensative)");
		Label note_2 = new Label("Note: 0 and -0 gives different values");
		
		//Buttons
		Button convert = new Button("Convert");
		
		//CheckBoxs
		CheckBox input_dec = new CheckBox("Decimal Number");
		CheckBox input_floating = new CheckBox("Floating Point");
		
		//Event handlers
		input_dec.setOnAction(new DecCheckBoxEventHandler(input_dec, input_floating));
		input_floating.setOnAction(new FloatingCheckBoxEventHandler(input_dec, input_floating));
		convert.setOnAction(new ConvertButtonEventHandler(input_num, input_dec, input_floating, output_num));
		
		//Attach to Scene
		root.add(input_lab, 0 ,0);
		root.add(input_num, 0, 1);
		root.add(input_dec, 1, 1);
		root.add(input_floating, 2, 1);
		root.add(output_lab, 0, 2);
		root.add(output_num, 0, 3);
		root.add(convert, 0, 4);
		root.add(note, 0, 5);
		root.add(note_2, 0, 6);
		
		stage.setTitle("IEEE Converter");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
