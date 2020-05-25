package Services;

import Models.Item;
import Models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
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

    public static void addItem(Item i){
        items.add(i);
        ItemsService.writeItems();
    }

    public static void removeItem(Item x){
        Item a = null;

        for(Item i:items){
            if(i.equals(x)){
                a=i;
            }
        }
        items.remove(a);

        ItemsService.writeItems();
    }

    public static void writeItems(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/shoppingItems.json");
            JSONArray ja = new JSONArray();

            for(Item i:items){
                JSONObject jo = new JSONObject();
                jo.put("item",i.getName());
                jo.put("price",String.valueOf(i.getPrice()));

                ja.add(jo);
            }

            fw.write(ja.toJSONString());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                fw.flush();
                fw.close();
            }catch (Exception e){
                System.out.println();
            }
        }
    }
}
