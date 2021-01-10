package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class FloatingCheckBoxEventHandler implements EventHandler<ActionEvent>{
	CheckBox dec;
	CheckBox floating;
	
	public FloatingCheckBoxEventHandler(CheckBox newDec, CheckBox newFloating) {
		this.dec = newDec;
		this.floating = newFloating;
	}

	@Override
	public void handle(ActionEvent arg0) {
		dec.setSelected(false);
	}
}
