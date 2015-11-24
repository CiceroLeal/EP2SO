public class Main {
	
	public static String[] bd = new String[36242];
	
	public static void main(String []args){
		ReadText leitura = new ReadText("src//bd.txt",bd);
		leitura.PrintArray(bd);
		ExecutaThread teste = new ExecutaThread();
		leitura.PrintArray(bd);
	}
}
