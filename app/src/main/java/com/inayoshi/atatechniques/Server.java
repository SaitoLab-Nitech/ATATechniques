package com.inayoshi.atatechniques;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Server extends AsyncTask<String,Void,Void> {
    public String hostIPAddr;
    public int hostPort;

    public Server(String addr, int port) {
        hostIPAddr = addr;
        hostPort = port;
    }

    @Override protected void onPreExecute() {}
    @Override protected Void doInBackground(String... params) {
        String postData = "Data from client: "+params[0];
        try {
            send(postData);
        } catch (IOException e) {
            Log.e(MainActivity.TAG, e.getMessage());
        }
        return null;
    }

    public void send(String data) throws IOException {
        Socket socket;
        BufferedWriter sockout;

        socket = new Socket(hostIPAddr, hostPort);
        sockout = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        sockout.write(data);
        sockout.flush();

        sockout.close();
        socket.close();
    }
}
