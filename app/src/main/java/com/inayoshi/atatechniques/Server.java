/*
    Test suite with anti-taint-analysis techniques.
    Copyright (C) 2021  Nagoya Institute of Technology, Hiroki Inayoshi

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
