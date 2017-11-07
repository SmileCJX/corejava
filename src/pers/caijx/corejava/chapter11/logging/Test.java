package pers.caijx.corejava.chapter11.logging;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/11/5/005.
 */
public class Test {

    public static void main(String[] args) {
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File -> Open menu item selected");
    }
}
