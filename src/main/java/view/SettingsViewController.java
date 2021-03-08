package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import model.UserCredentialHandler;

import java.io.IOException;

/**
 * Controller class for Settings.fxml
 */
public class SettingsViewController {

    public RadioButton onRadio;
    public RadioButton offRadio;
    public Slider volumeSlider;
    public Text loggedUser;
    private StageManager stageManager;
    private boolean isSelected = true;

    /**
     * Setting screen's Back-Button loads to MainMenu.fxml
     *
     * @param actionEvent
     * @throws IOException
     */
    public void settingsBackButton(ActionEvent actionEvent) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        Scene menuScene = new Scene(menuParent);

        stageManager = StageManager.getInstance();
        stageManager.getPrimaryStage().setTitle("The Grand Myllypuro");
        stageManager.getPrimaryStage().setScene(menuScene);
        stageManager.getPrimaryStage().show();

    }

    /**
     * Initializes Logged in as-text at the top corner
     */
    public void initialize() {
        if (UserCredentialHandler.getInstance().getLoggedInUser() != null) {
            loggedUser.setText("Logged in as: " + UserCredentialHandler.getInstance().getLoggedInUser().getUserName());
        }
    }

    /**
     * Turns tips ON or OFF
     */
    public void turnTips(){
        if(offRadio.isSelected()) {
            isSelected = false;
            System.out.println("Tips are now OFF");
        }else if(onRadio.isSelected()) {
            isSelected = true;
            System.out.println("Tips are now ON");
        }
    }

    /**
     * Checks if the tips are ON or OFF
     * @return - Returns true if tips are ON and false if they are OFF
     */
    public boolean getSelected() {
        return isSelected;
    }
}