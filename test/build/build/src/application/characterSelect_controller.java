package application;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class characterSelect_controller implements Initializable {
	int usernumber;
	String[] charNames;
	String[] charIds;
	String[] charClasses;
	@FXML
	ComboBox<String> characterSelect_cb_select;
	@FXML
	Button characterSelect_btn_open, characterSelect_btn_delete, characterSelect_btn_create;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		characterSelect_btn_open.setOnAction(this::selectUser_handle_open);
		characterSelect_btn_delete.setOnAction(this::selectUser_handle_delete);
		characterSelect_btn_create.setOnAction(this::selectUser_handle_create);
		// characterSelect_cb_select.getItems().clear();
		// characterSelect_cb_select.getItems().addAll("jacob.smith@example.com",
		// "isabella.johnson@example.com",
		// "ethan.williams@example.com", "emma.jones@example.com",
		// "michael.brown@example.com");
		setCbData();
	}

	private void selectUser_handle_open(ActionEvent event) {
		String characterSelected = characterSelect_cb_select.getValue().toString();
		System.out.println(characterSelected);

	}

	private void selectUser_handle_delete(ActionEvent event) {
	}

	private void selectUser_handle_create(ActionEvent event) {
	}

	public void setCbData() {

		usernumber = Metodos_logica.getUsernumber();
		List<String[]> characters = Metodos_logica.getPlayers(usernumber);
		charNames = new String[characters.size()];
		charIds = new String[characters.size()];
		charClasses = new String[characters.size()];
		int i = 0;
		
		for (int j = 0; j < characters.size(); j++) {
		    System.out.println(j + ": " + Arrays.toString(characters.get(j)));
		}
		
		
		for (String[] array : characters) {
			System.out.println(array[1]);
			charIds[i] = array[0];
			charNames[i] = array[1];
			charClasses[i] = array[2];
			i++;

		}
		for(int k = 0; k< charNames.length;k++) {
		characterSelect_cb_select.getItems().add(charNames[k]);
		}
	}

}
