package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShowResultController {

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
    String CurrentPage= "ShowResults.fxml";
    String file;
    
    @FXML
    private TableView<Results> TableResult;

    @FXML
    private TableColumn<Results, String> SymbolName;

    @FXML
    private TableColumn<Results, String> Belonging;

    @FXML
    private TableColumn<Results, Integer> Votes;

    @FXML
    private TableColumn<Results, String> Name;
    
	@FXML
	void initialize() throws Exception{
		Name.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getcandidateName()));
		Belonging.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getBelongTo()));
		SymbolName.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getAlocatedSymbol()));
		Votes.setCellValueFactory(cellData->	new SimpleIntegerProperty(cellData.getValue().getVoteCount()).asObject());	
		ObservableList<Results> emplist = mySqlDBHandler.getAllRecords();		
		if(emplist==null) {
			System.out.println("Hello  I am empty");
		}
		TableResult.setItems(emplist);	
	}
            
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
    	Results.setStyle("-fx-background-color: none; ");
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
    	Results.setStyle("-fx-background-color: none; ");
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
    	Results.setStyle("-fx-background-color: none; ");
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
    	Results.setStyle("-fx-background-color: none; ");
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
    	Results.setStyle("-fx-background-color: none; ");
    	
    	
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
    void ShowResults(ActionEvent event) throws Exception {
    	Party.setStyle("-fx-background-color: none;");
    	Symbol.setStyle("-fx-background-color: none; ");
    	Logout.setStyle("-fx-background-color: none; ");
    	Cadandiate.setStyle("-fx-background-color: none; ");
    	Home.setStyle("-fx-background-color: none;");
    	Results.setStyle(bgcolor);
    	// Add the Home Page Loading
    	file="ShowResults.fxml";
    	loadScene(event);
    }
    
}
