package org.conan;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("setting.txt");
        Scanner scan = new Scanner(fis);

        System.out.print(scan.nextLine());
        Class clazz = Class.forName(scan.nextLine());

        SmartPhone sp = new SmartPhone();
        Chargeable c = (Chargeable) clazz.newInstance();
        sp.setBattery(c);
        sp.charge();
    }
}



