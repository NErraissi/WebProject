package w1d3.Javalin;

import java.io.*;

public class GroceryDataAccessObject {
    File file;
    public GroceryDataAccessObject() {
        file = new File("src/main/resources/grocery.txt");
    }
    public GroceryItem[] getAllGroceryItems() throws IOException {
        BufferedReader groceryReader = new BufferedReader(new FileReader(file));
        GroceryItem[] groceryItems = new GroceryItem[16];
        String readLine;
        int numberOfItems = 0;
        do {
            readLine = groceryReader.readLine();
            if(readLine != null){
                groceryItems[numberOfItems] = new GroceryItem(readLine);
                numberOfItems++;
            }
        }
        while(readLine != null);{
            GroceryItem[] truncatedList = new GroceryItem[numberOfItems];
            for (int i = 0; i < numberOfItems; i++){
                truncatedList[i] = groceryItems[i];
            }
            groceryReader.close();
            return truncatedList;
        }
    }
    public void deleteGroceryList() throws IOException {
        file.delete();
    }
    public void addGroceryItem(GroceryItem g) throws IOException {
        BufferedWriter groceryWriter = new BufferedWriter(new FileWriter(file, true));
        groceryWriter.write("\n"+g.getItemName());
        groceryWriter.close();

    }
    public void createGroceryFile() {
        file = new File("src/main/resources/grocery.txt");
    }
}
