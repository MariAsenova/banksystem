package bank.presentationtier;

import bank.DTOClient;
import bank.applogictier.Administrator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdminClientImpl implements AdminClient{
      private Administrator administratorServer;

    public AdminClientImpl() {
        initRMIClient();
    }

    @Override
    public void createAccountResult(String result) throws RemoteException {
        System.out.println(result);
    }

    @Override
    public void createAccount(int id, String name, double balance) {
        try {
            administratorServer.createAccount(new DTOClient(id, name, balance));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void initRMIClient()
    {
        try {
            Registry registry = LocateRegistry.getRegistry(2000);
            administratorServer = (Administrator) registry.lookup("server");
            System.out.println("The server object is found");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
