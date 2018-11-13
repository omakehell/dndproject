package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login_controller implements Initializable {

	String user = "";
	String password = "";
	public int uid;

	@FXML
	Button login_btn_login, login_btn_create, login_btn_recover;
	@FXML
	TextField login_tf_user;
	@FXML
	PasswordField login_pf_password;

	public void initialize(URL location, ResourceBundle resources) {
		login_btn_login.setOnAction(this::login_handle_login);
		login_btn_create.setOnAction(this::login_handle_create);
		login_btn_recover.setOnAction(this::login_handle_recover);

	}

	// completo
	private void login_handle_create(ActionEvent event) {

		try {

			AnchorPane createUser = (AnchorPane) FXMLLoader
					.load(getClass().getClassLoader().getResource("application/createUser.fxml"));
			Stage stage = new Stage();
			stage.setTitle("prueba de segunda ventana");
			stage.setScene(new Scene(createUser));
			stage.show();
			stage.setResizable(false);
			// Hide this current window (if this is what you want)
			// ((Node) (event.getSource())).getScene().getWindow().hide();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// por hacer
	private void login_handle_recover(ActionEvent event) {
	}

	// falta manerjar excepcion de cuenta erronea
	private void login_handle_login(ActionEvent event) {
		Parent root;
		user = login_tf_user.getText();
		password = login_pf_password.getText();
		int usuarioexiste = Metodos_logica.login_comprobar(user, password);
		uid = usuarioexiste;
		System.out.println("syso captura campos: " + user + " " + password);
		if (usuarioexiste != 0) {
			try {
				AnchorPane characterSelect = (AnchorPane) FXMLLoader
						.load(getClass().getClassLoader().getResource("application/characterSelect.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(characterSelect));
				stage.show();
				stage.setResizable(false);
				// Hide this current window (if this is what you want)
				((Node) (event.getSource())).getScene().getWindow().hide();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("el usuario no existe!");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error!");
			alert.setHeaderText(null);
			alert.setContentText(
					"La cuenta no existe o has introducido los credenciales incorrectos. Si quieres recuperarla, dale a 'recover'.");
			alert.showAndWait();
		}
	}

}
