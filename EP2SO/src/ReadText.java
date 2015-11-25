import java.io.*;

class ReadText{
	BufferedReader text;
	
	public ReadText(String filePath, String[] bd){	
		try{ 
			text = new BufferedReader(new FileReader(filePath));
			for(int i=0;i<bd.length;i++){
				bd[i]=text.readLine();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}	
	
	public void MediaComLE(){
		double media;
		TextWriter esc = new TextWriter();
		try{
			for(int j = 0; j<101; j++){
				media = 0;
				for(int i=0; i<50;i++){
					text = new BufferedReader(new FileReader("src//logComLE"+j+".txt"));
					media += Double.parseDouble(text.readLine());
				}
				media = media/50;
				esc.escrever_arq_sub(""+media, "src//logComLE"+j+".txt");
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void MediaSemLE(){
		double media;
		TextWriter esc = new TextWriter();
		try{
			for(int j = 0; j<101; j++){
				media = 0;
				for(int i=0; i<50;i++){
					text = new BufferedReader(new FileReader("src//logSemLE"+j+".txt"));
					media += Double.parseDouble(text.readLine());
				}
				media = media/50;
				esc.escrever_arq_sub(""+media, "src//logSemLE"+j+".txt");
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void PrintArray(String[] bd){
		for(int i=0;i<bd.length;i++){
			System.out.println(bd[i]);
		}
	}

}