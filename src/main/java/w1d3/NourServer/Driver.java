package w1d3.NourServer;

public class Driver {
    public static void main(String[] args){
        String msg = "Hello server!";
        MyServer server = new MyServer(8080, msg);
        server.start();
    }
}
