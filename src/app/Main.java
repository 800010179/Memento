package app;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {

	public static void main(String[] args) {
		Arvuuttaja arvuuttaja = new Arvuuttaja();
		Scanner skanneri = new Scanner(System.in);  
		
		System.out.println("Montako pelaajaa?");
		int pelaajat = skanneri.nextInt(); 
		CountDownLatch latch = new CountDownLatch(pelaajat);
		for(int i = 0; i < pelaajat; i++) {
			String nimi = "Pelaaja " + (i+1);
			Asiakas pelaaja = new Asiakas(nimi, arvuuttaja, latch);
			Thread pelaajaSaie = new Thread(pelaaja);
			pelaajaSaie.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Peli ohi, kaikki pelaajat arvasivat oikein.");
	}

}
