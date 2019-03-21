import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        ClientTcpEcho clientest=new ClientTcpEcho("10.203.9.96",12345);
        clientest.lancerBW();
    }
}
