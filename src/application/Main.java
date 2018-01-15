package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		  //Thread.sleep(6000);
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/View.fxml"));		
	            Parent root = loader.load();
	            Scene scene = new Scene(root);
	            primaryStage.setScene(scene);
	            primaryStage.initStyle(StageStyle.DECORATED);       
	            primaryStage.show();
	            
//	          
	            
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
