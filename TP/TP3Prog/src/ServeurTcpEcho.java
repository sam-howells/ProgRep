import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.GregorianCalendar;

public class ServeurTcpEcho {
    public Socket client;
    public BufferedWriter out;
    public BufferedReader in;
    public ServerSocket serveur;
    public int nbClients;

    public ServeurTcpEcho(int nbClients, int port) throws IOException {
        this.serveur = new ServerSocket(port);
        this.nbClients = nbClients;
    }

    public void connexion() throws IOException {


        for (int i = 1; i <= nbClients; i++) {
            this.client = serveur.accept();

            out = new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            String message = "";
            while (!message.equals("quit")) {
                message = in.readLine();
                out.write(message);
                out.newLine();
                out.flush(); // le flush n'est pas indispensable ici car avant un close
            }
            in.close();
            out.close();
            client.close();
        }

        serveur.close();
    }
}
