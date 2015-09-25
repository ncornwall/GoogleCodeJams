import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Puzzle {

	public int numTestCases = 0;
	public String inputFileName;
	public ArrayList<PuzzleTestCase> testCases;

	public Puzzle(String filename){
		this.inputFileName = filename;
	}
	
	public void solve(){
		this.loadInput();
		this.outputSolution();	
	}
	
	public void loadInput(){
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFileName));
			String line = in.readLine();
			int lineNum = 0;

			while (line != null) {
				
				if (lineNum == 0){
					numTestCases = Integer.parseInt(line);
					testCases = new ArrayList<PuzzleTestCase>();
				}
				//header line
				else if (testCases.size() == 0 || getLast().remainingArgs > 0) {
					createTestCase(line);
				}
				else {
					addTestCaseDetail(line);
				}
				line = in.readLine();
				lineNum++;
			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void createTestCase(String line){
		PuzzleTestCase testCase = new PuzzleTestCase(splitLine(line));
		testCases.add(testCase);
	}
	
	public void addTestCaseDetail(String line){
		PuzzleTestCase testCase = getLast();
		testCase.addArg(line);
	}
	
	public int [] splitLine(String line){
		
		String[] exploded = line.split(" ");
		int [] parsedLine = new int[exploded.length];
		for (int i = 0; i < exploded.length; i++){
			parsedLine[i] = Integer.parseInt(exploded[i]);
		}
		
		return parsedLine;
	}
	
	public void outputSolution(){		
		String output = "";
		
		for (int i = 0; i < testCases.size(); i ++){
			output += "Case #" + (i + 1) + ": " + testCases.get(i).solve() + "\n";
		}
		
		System.out.println(output);
		printOutput(inputFileName + "-solution.txt", output);	
	}
	
	public void printOutput(String filename, String output){

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			writer.write(output);
		} catch (IOException ex) {

		} finally {
			try {
				writer.close();
			} catch (Exception ex) {/*ignore*/}
		}

	}
	
	public PuzzleTestCase getLast(){
		return testCases.get(testCases.size()-1);
	}
	
}
