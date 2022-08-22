package Utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class Utils {
    private String email;
    private String password;
    private String email2;
    private String password2;
    JSONArray jsonArray = new JSONArray();
    @Test
    public void writeUserInfo(String email, String password) throws IOException, ParseException {
        JSONObject userObj = new JSONObject();
        userObj.put("email", email);
        userObj.put("password", password);

        jsonArray.add(userObj);
        try {
            FileWriter file = new FileWriter("C:/Users/samawat/IdeaProjects/TestNG/TestNG/src/test/resources/user.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomPassword ( int len){
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                + "jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    public int generateRandomNumber ( int min, int max){
        int randomId = (int) (Math.random() * (max - min + min));
        return randomId;
    }


}
