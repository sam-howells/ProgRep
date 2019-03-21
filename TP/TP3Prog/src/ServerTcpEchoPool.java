import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTcpEchoPool {


    public Socket client;
    public BufferedWriter out;
    public BufferedReader in;
    public ServerSocket serveur;
    public int nbClients;
    private int TaillePool = 10;

    public ServerTcpEchoPool(int nbClients) throws IOException {
        this.serveur = new ServerSocket();
        this.nbClients = nbClients;
        serveur.bind(new InetSocketAddress("10.203.9.95",64000));
    }

    public void connexion() throws IOException {

        ExecutorService pool = Executors.newFixedThreadPool(TaillePool);
        for (int i = 1; i <= nbClients; i++) {

            this.client = serveur.accept();
            Thread monThread = new Thread(new TaskServerEcho(this.client));
            pool.execute(monThread);
        }
        serveur.close();
    }
}
