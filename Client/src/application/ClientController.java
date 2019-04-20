package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ClientController  implements Initializable {
	
    PrintStream streamToServer;
    BufferedReader streamFromServer;
    Socket toServer;
    
    @FXML
	public void serverMainPage(ActionEvent event) throws IOException {
		
    	connectToServer(event);
    	
    }
    
    private void connectToServer(ActionEvent event) throws IOException
    {
    	
    	Parent root = FXMLLoader.load(getClass().getResource("ServerMainPage.fxml"));
    	
    	Object eventSource = event.getSource(); 

    	Node sourceAsNode = (Node) eventSource ;

    	Scene oldScene = sourceAsNode.getScene();

    	Window window = oldScene.getWindow();

    	Stage stage = (Stage) window ;

    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    	
    	while(true) {  
    		
    		System.out.println("Welcome to Server");
    		
    		try{
            String name;
            toServer = new Socket("192.168.56.1",1000);
            streamFromServer = new BufferedReader(new InputStreamReader((toServer.getInputStream())));
            streamToServer = new PrintStream(toServer.getOutputStream());
            System.out.println("Enter Connection Name");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();   
            streamToServer.println(name);
            String str = streamFromServer.readLine();
            System.out.println("The Server Says "+str);  
            break;
        }
        catch(Exception e)
        {
                System.out.println("Exception "+e);
        }       
    	
      }	
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
}
