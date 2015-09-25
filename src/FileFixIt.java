import java.util.ArrayList;
import java.util.HashSet;

public class FileFixIt extends Puzzle{
		
	public FileFixIt(String filepath) {
		super(filepath);
	}	

	public void createTestCase(String line) {
		FixItTestCase testCase = new FixItTestCase(splitLine(line));
		testCases.add(testCase);		
	}
	
	public static void main(String[] args) {
		String filename = "A-large-practice-File-Fixit.in";
		FileFixIt puzzle = new FileFixIt(filename);
		puzzle.solve();
	}
	
	private class FixItTestCase extends PuzzleTestCase{
		
		ArrayList<String> directoriesOnComp; 
		ArrayList<String> directoriesToAdd;

		public FixItTestCase(int[] header) {
			super(header);
			remainingArgs = header[0] + header[1];
			this.directoriesOnComp = new ArrayList<>();
			this.directoriesToAdd = new ArrayList<>();
		}
		
		public void addArg(String line){
			if (directoriesOnComp.size() < header[0]){
				directoriesOnComp.add(line);
			}
			else {
				directoriesToAdd.add(line);
			}
			remainingArgs--;
		}

		public String solve() {
			
			HashSet<String> directoriesNeeded = new HashSet<String>();
						
			for (String directory : directoriesToAdd){
				int index = 0;
				while (index != -1){
					index = directory.indexOf("/", index + 1);
					if (index != -1) {
						directoriesNeeded.add(directory.substring(0, index));
					}
				}
				directoriesNeeded.add(directory);
			}
			
			int commands = 0;
			for (String directory : directoriesNeeded){
				if (!directoriesOnComp.contains(directory)){
					commands ++;
				}
			}
			return Integer.toString(commands);
		}
	}

}
