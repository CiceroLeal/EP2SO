public class Main {
	
	public static String[] bd = new String[36242];
	public static double tempoComLE;
	public static String mediasComLE="";
	public static double tempoSemLE;
	public static String mediasSemLE="";
	
	public static void main(String []args){
		new ReadText("src//bd.txt",bd);
		TextWriter esc = new TextWriter();
		//define a quantidade inicial de leitores
		
		int leitor = 100;
		
		//executa com 100 leitores e vai reduzindo até chegar em zero leitores
		while(leitor != -1){
			//executa 50 Threads com o mesmo numero de leitores
			for(int i=0; i<50; i++){
				new ExecutaThread(leitor);
			}
			
			//grava a media de tempo que as threads demoraram para realizar as execuções
			mediasComLE += (leitor+":" + (tempoComLE/50)+"\n");
			tempoComLE = 0;
			leitor--;
		}
		
		//escreve um txt na forma "quantidade de leitores":"media de 50 execuções"
		esc.escrever_arq_sub(mediasComLE, "src\\logComLE.txt");
		
		//faz exatamente o mesmo porém sem utilizar o esquema de leitor e escritor
		leitor = 100;
		while(leitor != -1){
			for(int i=0; i<50; i++){
				new ExecutaThread2(leitor);
			}
			mediasSemLE += (leitor+":"+tempoSemLE/50+"\n");
			tempoSemLE = 0;
			leitor--;
		}
		
		esc.escrever_arq_sub(mediasSemLE, "src\\logSemLE.txt");
		
	}
}
