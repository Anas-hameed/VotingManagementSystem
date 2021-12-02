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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button SignInbtn;

    @FXML
    private Button Signup;

    @FXML
    private TextField CNIC_text;

    @FXML
    private PasswordField passwd_Text;

    @FXML
    private Button GoBack;
    

    @FXML
    void goback(ActionEvent event) throws Exception {
    	BorderPane root;
		root = (BorderPane)FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    @FXML
    void SignIn(ActionEvent event) throws Exception {
    	String text= CNIC_text.getText();
    	String paswd= passwd_Text.getText();
    	if(text.isEmpty() || paswd.isEmpty()) {	
    		showDialog("Input field cann't be Empty");
    		return;
    	}
    	else {
    		PresistentHandler p= new mySqlDBHandler();
    		boolean check= p.VerifyAccount(text, paswd);
    		if(check) { 			
    			AnchorPane root;
    			root = (AnchorPane)FXMLLoader.load(getClass().getResource("CastVote.fxml"));
    			Scene scene = new Scene(root,600,500);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			primaryStage.setScene(scene);
    			primaryStage.show();
    			  			
    		}
    		else {
    			showDialog("Invalid Credential, create a account first");
    		} 
    	}
    }
    
    private void showDialog(String Msg) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText(Msg);
    	alert.showAndWait();
    	return;
    }
    

    @FXML
    void SignUp(ActionEvent event) throws Exception {
    	try {
			BorderPane root;
			root = (BorderPane)FXMLLoader.load(getClass().getResource("SignUppage.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception err) {
			throw new Exception();
		}
    }

}
