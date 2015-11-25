public class Main {
	
	public static String[] bd = new String[36242];
	
	public static void main(String []args){
		ReadText ler = new ReadText("src//bd.txt",bd);
		TextWriter esc = new TextWriter();
		
		int leitor = 100;
		while(leitor != -1){
			for(int i=0; i<50; i++){
				new ExecutaThread(esc, leitor);
			}
			leitor--;
		}
		
		leitor = 100;
		while(leitor != -1){
			for(int i=0; i<50; i++){
				new ExecutaThread2(esc, leitor);
			}
			leitor--;
		}
		
		ler.MediaComLE();
		ler.MediaSemLE();
	}
}
