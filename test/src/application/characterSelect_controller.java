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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class characterSelect_controller implements Initializable {
	int usernumber;
	String[] charNames;
	String[] charIds;
	String[] charClasses;
	@FXML
	ComboBox<String> characterSelect_cb_select;
	@FXML
	Button characterSelect_btn_open, characterSelect_btn_delete, characterSelect_btn_create;
	@FXML
	Button characterSelect_btn_npcs, characterSelect_btn_monsters, characterSelect_btn_items,
			characterSelect_btn_rollhistoric, characterSelect_btn_Mapgen, characterSelect_btn_changeUserDetails,
			characterSelect_btn_rollDice;
	@FXML
	Spinner characterSelect_cb_d4,
			characterSelect_lb_d6,
			characterSelect_lb_d8,
			characterSelect_lb_d10,
			characterSelect_lb_d12,
			characterSelect_lb_d20,
			characterSelect_lb_d100,
			characterSelect_lb_dxxx,
			characterSelect_lb_dxxx_dice,
			characterSelect_lb_modifier;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		characterSelect_btn_open.setOnAction(this::selectUser_handle_open);
		characterSelect_btn_delete.setOnAction(this::selectUser_handle_delete);
		characterSelect_btn_create.setOnAction(this::selectUser_handle_create);
		setCbData();
		setSpinnerData();
		characterSelect_btn_npcs.setOnAction(this::characterSelect_npcOpen);
		characterSelect_btn_monsters.setOnAction(this::characterSelect_monsterOpen);
		characterSelect_btn_items.setOnAction(this::characterSelect_itemOpen);
		characterSelect_btn_rollhistoric.setOnAction(this::characterSelect_rollhistoricOpen);
		characterSelect_btn_Mapgen.setOnAction(this::characterSelect_mapgenOpen);
		characterSelect_btn_changeUserDetails.setOnAction(this::characterSelect_changeuserdetailsOpen);
		characterSelect_btn_rollDice.setOnAction(this::characterSelect_rolldice);
	}

	private void characterSelect_npcOpen(ActionEvent event) {
	}

	private void characterSelect_monsterOpen(ActionEvent event) {
	}

	private void characterSelect_itemOpen(ActionEvent event) {
	}

	private void characterSelect_rollhistoricOpen(ActionEvent event) {
	}

	private void characterSelect_mapgenOpen(ActionEvent event) {
	}

	private void characterSelect_changeuserdetailsOpen(ActionEvent event) {
	}

	private void characterSelect_rolldice(ActionEvent event) {
		int 
		tf_d4 = (int) characterSelect_cb_d4.getValue(),
		tf_d6 = (int) characterSelect_cb_d4.getValue(),
		tf_d8 = (int) characterSelect_cb_d4.getValue(),
		tf_d10 = (int) characterSelect_cb_d4.getValue(),
		tf_d12 = (int) characterSelect_cb_d4.getValue(),
		tf_d20 = (int) characterSelect_cb_d4.getValue(),
		tf_d100 = (int) characterSelect_cb_d4.getValue(), 
		tf_dxxx = (int) characterSelect_cb_d4.getValue(),
		tf_dxxx_dice = (int) characterSelect_cb_d4.getValue();
		System.out.println("valor del spinner d4  :" + tf_d4);
		System.out.println("valor del spinner d6  :" + tf_d6);
		System.out.println("valor del spinner d8  :" + tf_d8);
		System.out.println("valor del spinner d10  :" + tf_d10);
		System.out.println("valor del spinner d12 :" + tf_d12);
		System.out.println("valor del spinner d20 :" + tf_d20);
		System.out.println("valor del spinner d100:" + tf_d100);
		System.out.println("valor del spinner dxxx:" + tf_dxxx);
		System.out.println("valor del spinner dx_c:" + tf_dxxx_dice);

		int[] resultado = Metodos_logica.tirarDados(tf_d4, tf_d6, tf_d8, tf_d10, tf_d12, tf_d20, tf_d100, tf_dxxx,tf_dxxx_dice);

	}

//////////////////////////////////////////////////////////////////////////////////////////

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
		for (int k = 0; k < charNames.length; k++) {
			characterSelect_cb_select.getItems().add(charNames[k]);
		}
	}
	public void setSpinnerData() {
		
		SpinnerValueFactory<Integer> vfd4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd10 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd12 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd20 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfd100 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfdxxx = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfdxxx_dice = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		SpinnerValueFactory<Integer> vfmodifier = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
		
		characterSelect_cb_d4.setValueFactory(vfd4);
		characterSelect_lb_d6.setValueFactory(vfd6);
		characterSelect_lb_d8.setValueFactory(vfd8);
		characterSelect_lb_d10.setValueFactory(vfd10);
		characterSelect_lb_d12.setValueFactory(vfd12);
		characterSelect_lb_d20.setValueFactory(vfd20);
		characterSelect_lb_d100.setValueFactory(vfd100);
		characterSelect_lb_dxxx.setValueFactory(vfdxxx);
		characterSelect_lb_dxxx_dice.setValueFactory(vfdxxx_dice);
		characterSelect_lb_modifier.setValueFactory(vfmodifier);
	}
}
