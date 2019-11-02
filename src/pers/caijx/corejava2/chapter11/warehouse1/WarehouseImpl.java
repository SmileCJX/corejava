package pers.caijx.corejava2.chapter11.warehouse1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WarehouseImpl
 * @Description: TODO
 * @Author Think
 * @Date 2019/9/26
 * @Version V1.0
 **/
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

    private Map<String,Double> prices;

    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<>();
        prices.put("Blackwell",24.95);
        prices.put("ZapXpress Microwave Oven",49.95);
    }

    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return null == price ? 0 : price;
    }
}
