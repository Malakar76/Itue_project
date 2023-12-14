package application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class PollCreation {
	@FXML
    private Dialog<Void> addPollDialog;
    @FXML
    private TextField questionField;

    @FXML
    private RadioButton QCM;
   
    @FXML
    private TextField qcmOptionsField;
    private String[] options;
    @FXML
    private void addPoll_button() {
        // Affiche la boîte de dialogue pour ajouter un sondage
        addPollDialog.showAndWait();
    }
   	
    
    public PollCreation(TextField questionField, RadioButton QCM,  TextField qcmOptionsField) {
        this.questionField = questionField;
        this.QCM = QCM;
        this.qcmOptionsField = qcmOptionsField;
        extractFormData();
    }
    public void extractFormData() {
    	String text = qcmOptionsField.getText();
        this.options = text.split("\\s*,\\s*");
    }
    public void createSurvey() {
        String question =this.questionField.getText(); //questionField.getText();
        boolean isQCM = this.QCM.isSelected();//QCM.isSelected();
        extractFormData();
        
        
        // Logic to save survey to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            writer.write(question + "\n");
            if (!isQCM) {
                writer.write("BOOL\n");
            } else {
                writer.write("QCM\n");
                for (int i = 0; i < options.length; i++) {
                	writer.write( options[i] + "\n");
                }
            }

            System.out.println("Survey created and saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}



