package Services;

import Models.Item;
import Models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class ItemsService {
    private static ArrayList<Item> items = new ArrayList<Item>();

    public static void loadItems(){
        try{
            items = new ArrayList<>();
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/shoppingItems.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray)obj;

            for(Object item:ja){
                JSONObject o = (JSONObject)item;

                items.add(new Item(o.get("item").toString(), Integer.parseInt(o.get("price").toString())));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<Item> getItems() {
        return items;
    }
}
