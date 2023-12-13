package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccountPageController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label badgesLabel;

    private Model model; 

    /**
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        User user = model.getUser();

        nameLabel.setText("Name: " + user.getName());
        surnameLabel.setText("Surname: " + user.getSurname());
        ageLabel.setText("Age: " + user.getAge());
        emailLabel.setText("Email: " + user.getEmail());

        StringBuilder badgesText = new StringBuilder("Badges: ");
        boolean[] badges = user.getBadges();
        for (int i = 0; i < badges.length; i++) {
            if (badges[i]) {
                badgesText.append("Badge ").append(i + 1).append(", ");
            }
        }
        badgesText.setLength(badgesText.length() - 2);
        badgesLabel.setText(badgesText.toString());
    }

	/**
	 * Set the model
	 */
    public void set_model(Model model) {
		this.model = model;
		username_field.setText(model.getUser());
		
	}
	/**
	 * Change the Page to the FeedPoll Page
	 * @param event
	 * @throws IOException
	 */
	public void FeedPoll_button(ActionEvent event) throws IOException {
		return;
	}
	/**
	 *  Change the Page to the MyPolls page
	 * @param event
	 * @throws IOException
	 */
	public void MyPolls_button(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MyPolls.fxml"));
		root = loader.load();
		MyPollsController controller = loader.getController() ;
		controller.set_model(model);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		controller.show_MyPollsAnswered();
		stage.setScene(scene);
		stage.show();
		
	}
	/**
	 *  Change the Page to the MyAccount Page
	 * @param event
	 * @throws IOException
	 */
	 public void MyAccount_button(ActionEvent event) throws IOException {
		return;	
	}
	/**
	 *  Change the Page to the Login Page and show a pop-up with successful disconnection
	 * @param event
	 * @throws IOException
	 */
	 
	public void Logout_button(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnectionPage.fxml"));
		root = loader.load();
		AccountPageController controller = loader.getController() ;
		controller.set_model(model);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		AlertPopUp.afficherAlerte(AlertType.INFORMATION, "Logout Succesfull", "You have been correctly disconnected");
		
	}
}