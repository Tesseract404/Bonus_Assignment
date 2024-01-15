package com.java.arnob;

public class Consumer implements Runnable {
	private Buffer buffer;
    public Consumer (Buffer buffer) {
    	this.buffer = buffer;
    	Thread Consumer = new Thread (this, "c");
    	Consumer.start();
    }
    public void Start() {
    	Thread Consumer = new Thread (this, "c");
    	Consumer.start();
   	}
    @Override
	public void run() {
		while (true) {
			buffer.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
		}
	}

}
