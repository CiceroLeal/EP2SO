public class Main {
	
	public static String[] bd = new String[36242];
	public static double tempoComLE;
	public static String mediasComLE;
	public static double tempoSemLE;
	public static String mediasSemLE;
	
	public static void main(String []args){
		new ReadText("src//bd.txt",bd);
		TextWriter esc = new TextWriter();
		
		int leitor = 100;
		while(leitor != -1){
			for(int i=0; i<50; i++){
				new ExecutaThread(leitor);
			}
			mediasComLE += (leitor+":" + (tempoComLE/50)+"\n");
			leitor--;
		}
		
		esc.escrever_arq_fim(mediasComLE, "src\\logComLE.txt");
		
		leitor = 100;
		while(leitor != -1){
			for(int i=0; i<50; i++){
				new ExecutaThread2(leitor);
			}
			mediasSemLE += (leitor+":"+tempoSemLE/50+"\n");
			leitor--;
		}
		
		esc.escrever_arq_fim(mediasSemLE, "src\\logSemLE.txt");
		
	}
}
