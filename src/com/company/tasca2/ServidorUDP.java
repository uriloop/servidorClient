package com.company.tasca2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
    DatagramSocket socket;
    SecretNum sNum= new SecretNum();
    //Instanciar el socket
    int intents=0;
    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void runServer() throws IOException {
        byte [] receivingData = new byte[1024];
        byte [] sendingData;
        InetAddress clientIP;
        int clientPort;

        // es pensa un numero secret quan inicia el server
        sNum.pensa(10);

        while(true) {
            DatagramPacket packet = new DatagramPacket(receivingData,1024);
            socket.receive(packet);
            sendingData = processData(packet.getData(),packet.getLength());
            //Llegim el port i l'adreça del client per on se li ha d'enviar la resposta
            clientIP = packet.getAddress();
            clientPort = packet.getPort();
            packet = new DatagramPacket(sendingData,sendingData.length,clientIP,clientPort);
            socket.send(packet);
        }
    }

    //El server retorna al client un missatge depenent de la comprovació del num.  més gran, més petit, correcte.
    private byte[] processData(byte[] data, int lenght) {

        String msg = new String(data,0,lenght);
        intents++;

        //Imprimir el missatge que toca
        System.out.println((msg)+" "+intents+" intents");

        String result;

        // si el numero és correcte, es reinicia el numSecret i els intents
        if ((result = sNum.comprova(msg)).equals("Correcte")){
            intents=0;
            sNum.pensa(10);
            return (" Correcte! El numero secret és "+ new String(data,0,lenght) +"  Torna a començar").getBytes();
        }

        // retorna el resultat
        return (result+" | "+intents+" intents").getBytes();
    }

    public static void main(String[] args) {
        ServidorUDP server = new ServidorUDP();
        try {
            server.init(5555);
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}