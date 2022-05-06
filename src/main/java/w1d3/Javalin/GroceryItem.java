package w1d3.Javalin;

public class GroceryItem {
    private String itemName;
    public GroceryItem(){
    }
    public GroceryItem(String itemName){
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
}
