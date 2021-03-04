package bank.applogictier;

import bank.applogictier.DAO.AdministratorImpl;
import bank.applogictier.DAO.DAOAdministrator;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServerBankApp {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(2000);
        try {
            DAOAdministrator administrator = new AdministratorImpl();
            registry.bind("server", new ServerRMIImpl(administrator));
            System.out.println("Server object is bound to the registry");
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
