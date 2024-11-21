package chap11_Thread;

class AreaThread extends Thread{
    public AreaThread(String name) {
        super(name);
    }
    int percentage = 0;
    int increase = 0;
    @Override
    public void run(){
        while(percentage<100){
            increase = (int) (Math.random()*5+1);
            percentage += increase;
            if (percentage > 100) percentage = 100;
            String star = "*".repeat(Math.max(0, percentage));
            System.out.println(Thread.currentThread().getName()+" 개표율: "+percentage+"%(개표증가율:"+increase+"%)"+ star);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                return;
            }
        }
    }
}

public class ThreadEX {
    public static void main(String[] args) {
        AreaThread th1 = new AreaThread("제1지역구");
        AreaThread th2 = new AreaThread("제2지역구");
        AreaThread th3 = new AreaThread("제3지역구");

        th1.start();
        th2.start();
        th3.start();

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
