package chap11_Thread;

public class P166 {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State s = Thread.currentThread().getState();

        System.out.println("현재 쓰레드 이름="+name );
        System.out.println("현재 쓰레드 ID="+id );
        System.out.println("현재 쓰레드 우선순위 값="+priority );
        System.out.println("현재 쓰레드 상태="+s );


    }
}
