public class RopeIntranet extends Puzzle{
	
	public RopeIntranet(String filepath) {
		super(filepath);
	}

	public void createTestCase(String line) {
		RopeIntranetTestCase testCase = new RopeIntranetTestCase(splitLine(line));
		testCases.add(testCase);		
	}
	
	private class RopeIntranetTestCase extends PuzzleTestCase{
		
		Wire[] wires;

		public RopeIntranetTestCase(int[] header) {
			super(header);
			this.wires = new Wire[header[0]];
		}
		
		public void addArg(String line){		
			Wire elm = new Wire(line);
			wires[remainingArgs-1] = elm;
			remainingArgs--;
		}
		
		public String solve(){
						
			int numIntersects = 0;
			
			for (int i = 0; i< wires.length; i ++ ){
				for (int k = i+1; k < wires.length; k ++){
					Wire a = wires[i];
					Wire b = wires[k];
					/*if (wires[i].intersects(wires[k])){
						numIntersects ++;
					}*/
				}
			}
			
			return Integer.toString(numIntersects);
		}
		
	}

	public static void main(String[] args) {
		String filename = "A-large-practice-Rope-Intranet.in";
		RopeIntranet puzzle = new RopeIntranet(filename);
		puzzle.solve();
	}

	
}
