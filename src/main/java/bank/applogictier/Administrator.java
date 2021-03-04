package bank.applogictier;

import bank.DTOClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Administrator extends Remote {

    void createAccount(DTOClient client) throws RemoteException;
}
