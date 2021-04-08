package self_suficient_snippets;

public class TenarySnippet {
	public static void main(String... args){
	    if(checkArgs(args)){
	       System.out.println("Verdadeiro");  
	    }else{
	       System.out.println("Falso");  
	    }
	    
	    System.out.println(checkArgs(args)?"Verdadeiro":"Falso");
	  }
	
	public static Boolean checkArgs(String... args) {
		return args.length > 0 && Boolean.parseBoolean(args[0]);
	}
}
