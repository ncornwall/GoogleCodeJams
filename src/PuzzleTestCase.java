
public class PuzzleTestCase {

	public int[] header;
	public int[] args; 
	
	int remainingArgs = 0;
	
	public PuzzleTestCase(int[] header) {
		super();
		this.header = header;
		args = new int[header[0]];
		remainingArgs = header[0];
	}
	
	public PuzzleTestCase() {
		this.header = null;
	}
		
	public String solve(){
		return "";
	}
	
	public void addArg(String line){
		args[remainingArgs - args.length] = Integer.parseInt(line);
		remainingArgs --;
	}

}
