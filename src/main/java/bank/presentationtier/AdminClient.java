package bank.presentationtier;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminClient extends Remote {
    void createAccountResult(String result) throws RemoteException;
    void createAccount(int id, String name, double balance) throws RemoteException;
}
