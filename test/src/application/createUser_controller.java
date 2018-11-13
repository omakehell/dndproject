package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class createUser_controller implements Initializable {
	String create_user = "";
	String create_password = "";
	String create_confirmation = "";
	String create_recoveryCode = "";
	@FXML
	TextField createUser_tf_user;
	@FXML
	Button createUser_btn_create, createUser_btn_back;
	@FXML
	PasswordField createUser_pf_password, createUser_pf_confirmation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createUser_btn_create.setOnAction(this::createUser_handle_create);
		createUser_btn_back.setOnAction(this::createUser_handle_back);

	}

	private void createUser_handle_back(ActionEvent event) {
		// get a handle to the stage
		Stage stage = (Stage) createUser_btn_back.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

	private void createUser_handle_create(ActionEvent event) {
		// Parent root;
		create_user = createUser_tf_user.getText().toString();
		create_password = createUser_pf_password.getText().toString();
		create_confirmation = createUser_pf_confirmation.getText().toString();
		create_recoveryCode = Metodos_logica.Recovery_code().toString();
		int comprobar = Metodos_logica.checkUser(create_user);
		System.out.println("comprobar" + comprobar);
		System.out.println(create_password + " , " + create_confirmation);
		if (create_password.equals(create_confirmation) && Metodos_logica.checkUser(create_user) == 0) {
			Usuario _user = new Usuario(comprobar, create_user, create_password, create_recoveryCode);
			Metodos_logica.login_btn_register(create_user, create_password, create_recoveryCode);
			System.out.println("creada cuenta: " + create_user + " | " + create_password);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("bien!");	
			alert.setHeaderText(null);
			alert.setContentText("Cuenta creada exitosamente!! Ahora vuelve atras y logueate:)");

			alert.showAndWait();
		} else {
			System.out.println("cuenta ya existe o contraseña no coincide");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No se pudo crear la cuenta en la BBDD.");
			alert.setHeaderText(null);
			alert.setContentText(
					"La cuenta que has introducido ya existe, o la contraseña que has introducido no coincide con su comprobación.");

			alert.showAndWait();
		}
	}
}
