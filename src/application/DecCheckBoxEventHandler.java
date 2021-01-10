package application;

import javafx.event.*;
import javafx.scene.control.*;
public class DecCheckBoxEventHandler implements EventHandler<ActionEvent>{
	CheckBox dec;
	CheckBox floating;
	
	public DecCheckBoxEventHandler(CheckBox newDec, CheckBox newFloating) {
		this.dec = newDec;
		this.floating = newFloating;
	}

	@Override
	public void handle(ActionEvent arg0) {
		floating.setSelected(false);
		
	}

}
