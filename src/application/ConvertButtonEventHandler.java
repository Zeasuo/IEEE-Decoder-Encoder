package application;

import javafx.event.*;
import javafx.scene.control.*;
public class ConvertButtonEventHandler implements EventHandler<ActionEvent>{
	
	private TextField input;
	private CheckBox dec;
	private CheckBox floating;
	private TextField output;
	
	public ConvertButtonEventHandler(TextField newInput, CheckBox newDec, CheckBox newFloating, TextField newOutput) {
		this.input = newInput;
		this.dec = newDec;
		this.floating = newFloating;
		this.output = newOutput;
	}
	@Override
	public void handle(ActionEvent arg0) {
		String output_value;
		if (this.dec.isSelected()) {
			IEEE_Encoder input_value = new IEEE_Encoder(this.input.getText());
			output_value = input_value.to_floating_point();
		}
		else if (this.floating.isSelected()){
			IEEE_Decoder input_value = new IEEE_Decoder(this.input.getText());
			output_value = input_value.to_decimal_num();
		}
		else {
			output_value = "";
		}
		this.output.setText(output_value);
	}
	

}
