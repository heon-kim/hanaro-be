package backlog;

abstract class Car {
    Car(){
        System.out.println("backlog.Car 객체 생성");
    }
    abstract void run();
    void start(){
        System.out.println("시동을 건다.");
    }
}

class Porche extends Car{
    void run(){
        System.out.println("포르세가 달린다.");
    }
}

class CarEx{
    public static void main (String[] args){
        Car car = new Porche();
        car.start();
        car.run();
    }
}
