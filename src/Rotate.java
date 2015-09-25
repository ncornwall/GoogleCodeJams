public class Rotate extends Puzzle{

	public Rotate(String filename) {
		super(filename);
	}
		
	public void createTesetCase(String line) {	
		RotateTestCase testCase = new RotateTestCase(splitLine(line));
		testCases.add(testCase);
	}
	
	private class RotateTestCase extends PuzzleTestCase{

		public RotateTestCase(int [] header) {
			super(header);
		}

		public String solve() {
			
			//TODO
			return "";
		}
	}
	
	public static void main(String[] args) {
		String filename = "A-small-practice-Rotate.in";
		Rotate puzzle = new Rotate(filename);
		puzzle.solve();
	}



}
