package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminLoginControllor {

    @FXML
    private Button IoginIn;

    @FXML
    private PasswordField passwd_Text;

    @FXML
    private TextField Nametxt;

    @FXML
    void loginInAccount(ActionEvent event) throws Exception{
		String Name = Nametxt.getText();
		String paswd= passwd_Text.getText();
		if(Name.contentEquals("anas") && paswd.contentEquals("anas")) {	
			try {
				AnchorPane root;
				root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdminPanelPage.fxml"));
				Scene scene = new Scene(root,600,500);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch (Exception err) {
				System.out.println(err);
				throw new Exception();
			}  	
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Incorrect User Name or Password!!!");
			alert.showAndWait();  
		}
    }
}
