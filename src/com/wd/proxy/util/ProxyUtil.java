package com.wd.proxy.util;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyUtil {

    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});
        String paths = clazz.getResource(".").getPath().replace("%20", " ");
        System.out.println(paths);
        FileOutputStream fos = null;
        try {
            File file = new File(paths + proxyName + ".class");
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            if (file.exists()) file.delete();
            file.createNewFile();
            fos = new FileOutputStream(file);
            fos.write(proxyClassFile);
            fos.flush();
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
