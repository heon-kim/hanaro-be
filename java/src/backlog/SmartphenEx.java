package backlog;

interface MyButton{
    void click();
}

public class SmartphenEx {
    public static void main(String[] args) {
        MyButton btnCall = new MyButton(){
            public void click(){
                System.out.println("backlog.Hello World");
            }
        };
        btnCall.click();

        MyButton btnStop = new MyButton(){
            public void click(){
                System.out.println("backlog.Hello World");
            }
        };
        btnStop.click();
    }
}
