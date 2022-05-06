package w1d3.Javalin;
import io.javalin.Javalin;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller {
    public static void main(String[] args) {
        GroceryDataAccessObject repository = new GroceryDataAccessObject();
        Javalin app = Javalin.create();
        app.start(5000);

        app.get("/", ctx->
                ctx.result("Hello Server!")
        );
        app.get("/grocery/", ctx->
                {
                    GroceryItem[] groceryList = repository.getAllGroceryItems();
                    ctx.json(groceryList);
                }
        );
        app.put("/grocery/", ctx->
                {
                    ObjectMapper mapper = new ObjectMapper();
                    GroceryItem item = mapper.readValue(ctx.body(), GroceryItem.class);
                    repository.addGroceryItem(item);
                }
        );
        app.delete("/grocery/", ctx->
                {
                    repository.deleteGroceryList();
                }
        );
        app.post(" ", ctx -> {
                    repository.createGroceryFile();
                }
        );
        app.get("/grocery/{groceryID}", ctx->{
                    String groceryIDString = ctx.pathParam("groceryID");
                    int groceryID = Integer.parseInt(groceryIDString);
                }
        );
    }
}
