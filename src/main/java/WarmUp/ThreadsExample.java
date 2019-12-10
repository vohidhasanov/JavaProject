package WarmUp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.omg.PortableServer.THREAD_POLICY_ID;

public class ThreadsExample {

    public static void main(String[] args) {
    ThreadTest t1 = new ThreadTest(new Customer ("Sam") );
     t1.start();
    ThreadTest t2 = new ThreadTest(new Customer ("Sue") );
      t2.start();
    ThreadTest t3 = new ThreadTest(new Customer ("Sid") );
      t3.start();

    }
}

class Customer {
    public String name;
    public Customer(String name) {
    this.name= name;}
}

class BankAccount {
    static BankAccount accout;
    static int balance = 100;
    static Customer cust;
    public static  BankAccount getAccout(Customer cust)
        {
            if (accout == null) { accout = new BankAccount();}
            BankAccount.cust=cust;
            return accout;
        }


    public synchronized  void withDraw (int bal) {
        try {
            if (balance>= bal) {
                System.out.println(cust.name+" requested $ "+ bal);
                Thread.sleep(1000);
                balance-=   bal;
                System.out.println(cust.name+ " recieved $ "+ bal);
            }
            else {
                System.out.println(cust.name + " tried to excee balance");
            }
        }catch (Exception e) {e.printStackTrace();}
     System.out.println("Current Balance is "+ balance);
     System.out.println();
    }
    public static int getBalance() {
        return balance;
    }
}

class ThreadTest extends Thread implements Runnable {
    Customer cust;
    public ThreadTest(Customer cust) {this.cust= cust;}


public void run () {
    for (int i =0 ; i<4; i++) {
        try {
            BankAccount account = BankAccount.getAccout(cust);
            account.withDraw(10);
            Thread.sleep(1000);
        } catch (Exception e) {e.printStackTrace();}
    }
}
}
class MyThread implements Runnable {

    public void run() {
        System.out.println("Active threads "+ Thread.activeCount());
        System.out.println("Start thread "+ Thread.currentThread().getName());
        try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {e.printStackTrace();}

        System.out.println("End thread "+ Thread.currentThread().getName());
    }



}

