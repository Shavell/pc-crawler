package com.shavell.gui.util;

import com.google.gson.Gson;
import com.shavell.gui.Controller;
import com.shavell.gui.dto.Computer;
import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Utils {
    static final Logger logger = LoggerFactory.getLogger(Utils.class.getName());
    private static Gson gson = new Gson();

    public static void sendData(Computer computerDetails) {
        try{
            HttpResponse response = (HttpResponse) createRequest(computerDetails);
            if (response.getStatusLine().getStatusCode() != 200) {
                Controller.createAnyDialog(Alert.AlertType.ERROR, "Hata Oluştu!", null, "Sunucu Hatası");
                logger.debug("Being problem of server based");
            }
            else {
                logger.debug("All data sended.");
                Controller.createAnyDialog(Alert.AlertType.CONFIRMATION, "Bilgiler Gönderildi!", null, "Uygulamayı Kapatabilirsiniz!");
            };
        } catch (IOException e) {
            e.printStackTrace();
            Controller.createAnyDialog(Alert.AlertType.ERROR, "Hata Oluştu!", null, "Sunucu Bağlantı Problemi");
        }
    }

    private static HttpResponse createRequest(Computer computer) throws IOException {
        String s = gson.toJson(computer);
        return Request.Post("http://localhost:8000/sendHardwareInfo")
                .bodyString(s, ContentType.APPLICATION_JSON)
                .execute().returnResponse();
    }

}
