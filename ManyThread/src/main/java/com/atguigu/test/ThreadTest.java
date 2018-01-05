package com.atguigu.test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//3个售票员卖30张票
public class ThreadTest {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(()-> {for (int i = 1; i <= 30; i++) {ticket.sale();}},"a").start();
		new Thread(()-> {for (int i = 1; i <= 30; i++) ticket.sale();},"b").start();
		new Thread(()-> {for (int i = 1; i <= 30; i++) ticket.sale();},"c").start();
		/* new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 30; i++) {
					ticket.sale();
				}
				
			}
		},"A").start();
		
		 new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				
				 for (int i = 1; i <= 30; i++) {
					 ticket.sale();
				 }
				 
			 }
		 },"B").start();
		
		 new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				 
				 for (int i = 1; i <= 30; i++) {
					 ticket.sale();
				 }
				 
			 }
		 },"C").start();*/
		
		
	}
}
class Ticket{
	private  int number=30;
	private Lock lock = new ReentrantLock();
	public void sale() {
		lock.lock();
		try {
			if(number>0) {
				System.out.println(Thread.currentThread().getName()+"卖的第："+(number--)+"剩余："+number);
			}
		} finally {
			lock.unlock();
		}
	}
}