package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminPanelController {

    @FXML
    private Button Party;

    @FXML
    private Button Symbol;

    @FXML
    private Button Logout;

    @FXML
    private Button Cadandiate;

    @FXML
    private Button Home;
    
    @FXML
    private Button Results;

    

    String bgcolor="-fx-background-color: #fff; -fx-text-fill: black;";
    String CurrentPage= "AdminPanelPage.fxml";
    String file;
    
    
    void loadScene(ActionEvent event) throws Exception{
    	if(CurrentPage.equalsIgnoreCase(file)) {
    		return;
    	}
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource(file));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		CurrentPage= file;
    	
    }
    
    
    @FXML
    void loadHome(ActionEvent event) throws Exception {
    	
    	Party.setStyle("-fx-background-color: none;");
    	Symbol.setStyle("-fx-background-color: none; ");
    	Logout.setStyle("-fx-background-color: none; ");
    	Cadandiate.setStyle("-fx-background-color: none; ");
    	Home.setStyle(bgcolor);
    	
    	// Add the Home Page Loading
    	file="AdminPanelPage.fxml";
    	loadScene(event);
    	

    }

    @FXML
    void AddSymbol(ActionEvent event) throws Exception {
    	
    	Home.setStyle("-fx-background-color: none;");
    	Party.setStyle("-fx-background-color: none;");
    	Symbol.setStyle(bgcolor);
    	Logout.setStyle("-fx-background-color: none; ");
    	Cadandiate.setStyle("-fx-background-color: none; ");
    	// Add the Symbol Page Load    	
    	file="Addsymbol.fxml";
    	loadScene(event);
    	
    	
    	
    	
    }

    @FXML
    void AddParty(ActionEvent event) throws Exception{
    	Home.setStyle("-fx-background-color: none;");
    	Party.setStyle(bgcolor);
    	Symbol.setStyle("-fx-background-color: none; ");
    	Logout.setStyle("-fx-background-color: none; ");
    	Cadandiate.setStyle("-fx-background-color: none; ");
    	
    	// Add the Party Page Loading
    	file="AddParty.fxml";
    	loadScene( event);

    }

    @FXML
    void AddCandidiate(ActionEvent event) throws Exception {
    	
    	Home.setStyle("-fx-background-color: none;");
    	Party.setStyle("-fx-background-color: none;");
    	Symbol.setStyle("-fx-background-color:none; ");
    	Logout.setStyle("-fx-background-color:none; ");
    	Cadandiate.setStyle(bgcolor);
    	
    	file="AddCandidiate.fxml";
    	loadScene( event);

    }

    @FXML
    void loadlogoutAction(ActionEvent event) throws Exception {
    	Home.setStyle("-fx-background-color: none;");
    	Party.setStyle("-fx-background-color: none;");
    	Symbol.setStyle("-fx-background-color:none; ");
    	Logout.setStyle(bgcolor);
    	Cadandiate.setStyle("-fx-background-color:none; ");
    	file="AdminloginPage.fxml";
    	BorderPane root;
		root = (BorderPane)FXMLLoader.load(getClass().getResource(file));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
		CurrentPage= file;    	
    }
    
    @FXML
    void ShowResults(ActionEvent event) {

    }


}
