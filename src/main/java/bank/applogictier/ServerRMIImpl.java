package bank.applogictier;

import bank.DTOClient;
import bank.applogictier.DAO.DAOAdministrator;
import bank.datatier.JdbcConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;

public class ServerRMIImpl extends UnicastRemoteObject implements Administrator {

    private DAOAdministrator daoAdministrator;

    protected ServerRMIImpl(DAOAdministrator daoAdministrator) throws RemoteException {
        this.daoAdministrator = daoAdministrator;
    }

    @Override
    public void createAccount(DTOClient client) throws RemoteException {
        daoAdministrator.createAccount(client);
    }
}
