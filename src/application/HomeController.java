package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button Adminlogin;

    @FXML
    private Button VoterLogin;

    
    @FXML
    void AdminLoginScreen(ActionEvent event) throws Exception { 
    	try {
			BorderPane root;
			root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminloginPage.fxml"));
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
    

    @FXML
    void Voter_login(ActionEvent event) throws Exception{
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