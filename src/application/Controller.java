package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

	@FXML 
	RadioButton radButFactorial, radButExponent, radButIsPrime, radButForAnalysis, radButForGCD, radButForLCM, radButForSQRRoot, radButForAbsValue, radButForPercentage;
	@FXML
	TextField txtFieldFactorial, txtFBase, txtFPower, txtFieldIsPrime, txtFieldAnalysisIsNumber, txtFieldGCDIsNumber, txtFieldLCMx, txtFieldLCMy, txtFieldSQRRootX, txtFieldSQRRootY, txtFieldAbsX, txtFieldAbsY, txtFieldPercentX, txtFieldPercentY;
	@FXML
	Label lblResult;
	@FXML
	ImageView btnCalc;
	private final Model model = new Model();
	
	@FXML
	public void userOptionCalculate() {

		if(radButFactorial.isSelected()) {
            lblResult.setText( String.valueOf(model.factorial(Integer.valueOf(txtFieldFactorial.getText()))));
		}else if(radButExponent.isSelected()) {
			lblResult.setText( Double.toString(model.exponent(Integer.parseInt(txtFBase.getText()),Integer.parseInt(txtFPower.getText()))));
		}else if(radButIsPrime.isSelected()) {
			String resultString = model.isPrime(Integer.valueOf(txtFieldIsPrime.getText()));
			lblResult.setText(resultString);
		}else if(radButForAnalysis.isSelected()) {		
			lblResult.setText( String.valueOf(model.calculatePrimeFactorization(Integer.valueOf(txtFieldAnalysisIsNumber.getText())).toString()));
		}else if(radButForGCD.isSelected()) {
			lblResult.setText("uck");
		}else if(radButForLCM.isSelected()) {
			lblResult.setText(String.valueOf(model.lcm(Integer.parseInt(txtFieldLCMx.getText()),Integer.parseInt(txtFieldLCMy.getText()))));
		}else if(radButForSQRRoot.isSelected()) {
			txtFieldSQRRootY.setText(String.valueOf(model.sqrRoot(Double.valueOf(txtFieldSQRRootX.getText()))));
		}else if(radButForAbsValue.isSelected()) {
			txtFieldAbsY.setText(String.valueOf(model.absoluteValue(Double.valueOf(txtFieldAbsX.getText()))));
		}else if(radButForPercentage.isSelected()) {
			lblResult.setText(String.valueOf(model.percentage(Double.valueOf(txtFieldPercentX.getText()), Double.valueOf(txtFieldPercentY.getText()))));
		}
	}
}
