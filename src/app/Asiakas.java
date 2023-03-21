package app;

import java.util.concurrent.CountDownLatch;

public class Asiakas implements Runnable{
	private String nimi;
	private Object obj;
	private Arvuuttaja arvuuttaja;
	
	private CountDownLatch latch;
	public Asiakas(String nimi, Arvuuttaja arvuuttaja, CountDownLatch latch) {
		
		this.nimi = nimi;
		this.arvuuttaja = arvuuttaja;
		this.obj = arvuuttaja.arvoLuku();
		this.latch = latch;
	}
	
	public boolean arvaa() {
		int min = 1;
		int max = 11;
		int arvottuLuku = (int) (Math.random() * ( max - min )) + min;
		System.out.println(nimi + " arvaa " + arvottuLuku);
		if(arvuuttaja.arvaa(obj, arvottuLuku)) {
			System.out.println(nimi + " arvasi oikein!");
			
		}
		else {
			System.out.println(nimi + " arvasi väärin!");
		}
		return arvuuttaja.arvaa(obj, arvottuLuku);
	}
	
	@Override
	public void run() {
		boolean arvattiinkoOikein = arvaa();
		while(!arvattiinkoOikein) {
			arvattiinkoOikein = arvaa();
		}
		if(latch != null) {
			latch.countDown();
		}
	}
	
	
	
}
