public class Main {

    public static void main(String[] args){
        new Server();
        Client client = new Client("192.168.100.8", 6666);
        client.sendMessage("pene");
        //client.sendMessage("hi");
    }
}
