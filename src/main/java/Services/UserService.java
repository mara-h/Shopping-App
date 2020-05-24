package Services;

import Models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class UserService {
    private static ArrayList<User> users = new ArrayList<>();

    public static void loadUsers(){
        try{
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/usernames.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray)obj;

            for(Object user:ja){
                JSONObject o = (JSONObject)user;

                users.add(new User(o.get("username").toString(),o.get("password").toString(),o.get("role").toString()));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
