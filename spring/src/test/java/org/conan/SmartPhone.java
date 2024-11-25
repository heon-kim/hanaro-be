package org.conan;

public class SmartPhone {
//    private Battery b;
    private Chargeable c;
    SmartPhone() {
//        b = new Battery();
    }
    public void setBattery(Chargeable c){
        this.c = c;
    }
    public void charge(){
        System.out.printf("%s으로 충전", c.getMode());
    }
}
