package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddPartyController {

    @FXML
    private TextField CNIC_text11;
    
    @FXML
    private Button ShowsOptions;
    
    @FXML
    private Button Party;

    @FXML
    private Button Symbol;

    @FXML
    private TextField CNIC_text;

    @FXML
    private Button Logout;

    @FXML
    private Button Cadandiate;

    @FXML
    private Button Home;

    @FXML
    private Button Addparty;
    
    @FXML
    private Button Results;
    
    String bgcolor="-fx-background-color: #fff; -fx-text-fill: black;";
    String CurrentPage= "AddParty.fxml";
    String file;
    int Setid=-1;
    

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
    void AddSymbol(ActionEvent event)throws Exception {
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
    void AddParty(ActionEvent event)throws Exception {
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
    
    @FXML
    void AddPartyAction(ActionEvent event) {
    	
    	String res= ShowsOptions.getText(); 
		if(res.contentEquals("Default")) {
			showDialog("Selected value Other than Default");
			return;
		}
		
		
		String PartyName  = CNIC_text.getText();
		String Agenda= CNIC_text11.getText(); 
		if(PartyName.isEmpty() || Agenda.isEmpty()) {
			showDialog("Please Enter the values");
			return;
		}
		if(Setid==-1) {
			showDialog("Select Symbol !!!!!!!!!!!");
		}
		Party p= new Party(Setid, PartyName, Agenda);
		boolean con = p.SaveParty();
		if(con) {
    		showDialog("Party added Sucessfully");
    		return;
    		
    	}
    	else {
    		showDialog("Failed in Running Querry");				
    	} 
    }
    
    @FXML
    void SelectSymbol(ActionEvent event ) {
    	List<String> choices = new ArrayList<>();
    	HashMap<Integer,String> Symbolfetch= Symbols.fetchSymbol();
    	if(Symbolfetch==null)
    	{
    		
    		return;
    	}    	
    	for(Map.Entry m : Symbolfetch.entrySet()){    
    		    System.out.println(m.getKey()+" "+m.getValue());    
    		    choices.add(m.getValue().toString());
    	}  
    	ChoiceDialog<String> dialog = new ChoiceDialog<>("Default", choices);
    	dialog.getDialogPane().lookupButton(ButtonType.OK).
        disableProperty().bind(dialog.selectedItemProperty().isNull());    	
    	dialog.setTitle("Allocate a Symbol to Party");
    	dialog.setHeaderText("Look, a Choice Dialog");
    	dialog.setContentText("Select a Symbol ::");
    	
    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()){
    		String res = result.get();
		    ShowsOptions.setText(res);	
		    Setid= -1;
			// Database Operation goes Here
			for(Map.Entry m : Symbolfetch.entrySet()){    
			  if(res.contentEquals(m.getValue().toString())) {
				Setid= (Integer)m.getKey();  
			  }
			}  
    	}
    	else {
    		showDialog("Please Allocate a Symbol to Party");
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
    
    

}
