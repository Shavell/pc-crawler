package com.shavell.gui;


import com.shavell.gui.dto.Computer;
import com.shavell.gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField doorNo;

    private SystemDetails systemDetails = new SystemDetails();

    public void pressButton(ActionEvent event) throws InterruptedException {
        if(!doorNo.getText().isEmpty()){
            createWaitDialog();
            Computer computerDetails = systemDetails.callDetails(doorNo.getText());
            Utils.sendData(computerDetails);
        }else {
            createAnyDialog(Alert.AlertType.ERROR, "Hata Oluştu!", null, "Oda numaranızı giriniz!");
        }
    }

    public static void createAnyDialog(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void createWaitDialog() throws InterruptedException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bilgilendirme");
        alert.setHeaderText(null);
        alert.setContentText("Bilgiler Toplanıyor Lütfen Bekleyiniz!");
        alert.show();
        Thread.sleep(3000);
        alert.hide();
    }
}
