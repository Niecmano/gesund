/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komun;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Primalac {
    private ObjectInputStream in;

    public Primalac(Socket skt) {
        try {
            in = new ObjectInputStream(skt.getInputStream());
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

public synchronized Object primi() {
try {
return in.readObject();
} catch (IOException ex) {
try (
FileWriter fw = new FileWriter("server_error.log", true);
PrintWriter pw = new PrintWriter(fw)
) {
pw.println("GRESKA U PRIMALAC.primi()");
ex.printStackTrace(pw);
} catch (Exception e) {
e.printStackTrace();
}

} catch (ClassNotFoundException ex) {

try (
FileWriter fw = new FileWriter("server_error.log", true);
PrintWriter pw = new PrintWriter(fw)
) {
pw.println("GRESKA U PRIMALAC.primi()");
ex.printStackTrace(pw);
} catch (Exception e) {
e.printStackTrace();
}
}

return null;
}
}
