package chap11_Thread;

public class P168_1 {
    static class TimerThread extends Thread{
        int n = 0;
        @Override
        public void run(){
            while(true){
                System.out.println(n);
                n++;
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        TimerThread th = new TimerThread();
        th.start();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        th.interrupt();
    }
}
