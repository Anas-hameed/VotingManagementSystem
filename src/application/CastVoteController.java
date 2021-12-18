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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CastVoteController {

    @FXML
    private Button Vote;

    @FXML
    private Button Logout;

    @FXML
    private Button ShowsOptions;

    @FXML
    private Button CastVote;
    
    
    int Setid=-1;

    @FXML
    void Logoutaction(ActionEvent event)throws Exception {
    	String file="LoginScreen.fxml";
    	BorderPane root;
		root = (BorderPane)FXMLLoader.load(getClass().getResource(file));
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();

    }

    @FXML
    void AddVote(ActionEvent event) {
    	// Null
    }

    @FXML
    void CastVoteAction(ActionEvent event) {    	
    	if(Setid==-1) {
    		showDialog("Please select the symbol first");
    	}
    	boolean con= Candidiate.CastVote(Setid);
    	if(con) {
    		showDialog("Sucessfully casted the vote");
    	}else {
    		showDialog("Failed to cast the vote");
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
