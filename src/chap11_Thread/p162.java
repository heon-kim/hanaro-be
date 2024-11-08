package chap11_Thread;

class TimerThread extends Thread{
    public TimerThread (String str){
        super(str);
    }
    int n = 0;
    public void run(){
        for(int i = 0; i<10;i++){
            System.out.println(i+" "+getName());
            try{
                System.out.println(i+"번 작업 쓰레드");
                Thread.sleep((long) (Math.random()+1)*1000);
            }
            catch (Exception e) {}
        }
        System.out.println("작업 완료 "+ getName());
    }
}

public class p162 {
    public static void main(String[] args) {
        new TimerThread("Thread1").start();
        new TimerThread("Thread2").start();
    }
}
