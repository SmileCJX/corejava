package pers.caijx.corejava2.chapter11.warehouse1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName Warehouse
 * @Description: 远程对象接口必须扩展Remote接口，接口中的所有方法还必须声明抛出RemoteException异常
 * @Author Think
 * @Date 2019/9/26
 * @Version V1.0
 **/
public interface Warehouse extends Remote {

    double getPrice(String description) throws RemoteException;
}
