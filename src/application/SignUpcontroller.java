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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SignUpcontroller {

    @FXML
    private Button SignUp;

    @FXML
    private TextField CNIC_text;

    @FXML
    private Button SignIn;

    @FXML
    private PasswordField passwd_Text;

    @FXML
    private TextField Nametxt;
    
    @FXML
    private Button GoBack;
    
    
    @FXML
    void goback(ActionEvent event)throws Exception  {
    	BorderPane root;
		root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void SignUpAccount(ActionEvent event) throws Exception {
    	String name= Nametxt.getText();
    	String text= CNIC_text.getText();
    	String paswd= passwd_Text.getText();
    	if(text.isEmpty() || paswd.isEmpty() || name.isEmpty()) {	
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Input field cann't be Empty");
    		alert.showAndWait();
    		return;
    	}
    	else {
    		Voter v= new Voter(name, text, paswd);
    		boolean check= v.Addvoter();
    		if(check) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Dialog");
    			alert.setHeaderText(null);
    			alert.setContentText("Account Created was Sucessfull, Go to login Page");
    			alert.showAndWait();    			
    		}
    		else {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Dialog");
    			alert.setHeaderText(null);
    			alert.setContentText("Failed to connect to database");
    			alert.showAndWait();  
    		}
    		
    		
    		
    	}    	
    }

    @FXML
    void SigInAccount(ActionEvent event) throws Exception {
    	try {
			BorderPane root;
			root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
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


