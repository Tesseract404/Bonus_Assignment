package com.java.arnob;

public class Producer implements Runnable{
    private Buffer buffer;
    public Producer (Buffer buffer) {
    	this.buffer = buffer;
    	
    	
    }
   	public void Start() {
   		Thread producer = new Thread (this, "P");
   		producer.start();
   	}
    @Override
	public void run() {
    	int i =0;
		while (true) {
			buffer.set(i++);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
		}
	}

}
