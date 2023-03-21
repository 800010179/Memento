package app;

public class Arvuuttaja {
	
	public Object arvoLuku(){
		int min = 1;
		int max = 11;
		int arvottuLuku = (int) (Math.random() * ( max - min )) + min;
		return new Memento(arvottuLuku);
	}
	
	public boolean arvaa(Object obj, int arvaus) {
		Memento memento = (Memento) obj;
		if(memento.luku == arvaus) {
			return true;
		}
		return false;
	}
	
	private class Memento{
		private int luku;
		public Memento(int luku){
			this.luku = luku;
		}
	}
	
}
