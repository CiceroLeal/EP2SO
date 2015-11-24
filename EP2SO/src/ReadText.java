import java.io.*;

class ReadText{
	BufferedReader text;
	//String[] bd = new String[36242];
	
	public ReadText(String filePath, String[] bd){	
		try{ 
			text = new BufferedReader(new FileReader(filePath));
			for(int i=0;i<bd.length;i++){
				bd[i]=text.readLine();
			}
			//System.out.println(text.readLine());
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