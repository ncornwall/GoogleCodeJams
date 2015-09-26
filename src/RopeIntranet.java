public class RopeIntranet extends Puzzle{
	
	public RopeIntranet(String filepath) {
		super(filepath);
	}

	public void createTestCase(String line) {
		RopeIntranetTestCase testCase = new RopeIntranetTestCase(splitLine(line));
		testCases.add(testCase);		
	}

	public static void main(String[] args) {
		String filename = "A-large-practice-Rope-Intranet.in";
		RopeIntranet puzzle = new RopeIntranet(filename);
		puzzle.solve();
	}

	private class RopeIntranetTestCase extends PuzzleTestCase{
		public int [][] wires; 		
		public Float x1 = (float) 0;
		public Float x2 = (float) 10;
		
		public RopeIntranetTestCase(int[] header) {
			super(header);
			wires = new int[remainingArgs][];
		}

		public void addArg(String line){
			wires[remainingArgs-1] = splitLine(line);
			remainingArgs --;
		}
		
		public String solve(){
			int numIntersects = 0;
			for (int i = 0; i< wires.length; i ++ ){
				for (int k = i+1; k < wires.length; k ++){
					if (intersects(wires[i], wires[k])){
						numIntersects ++;
					}
				}
			}
			return Integer.toString(numIntersects);
		}

		public Boolean intersects(int [] wireA, int [] wireB){
			Float slopeA = slope(wireA);
			Float yInterseptA = intersept(wireA);
			Float slopeB = slope(wireB);
			Float yInterseptB = intersept(wireB);

			//parallel lines
			if (slopeA == slopeB){
				return false;
			}

			Float denominator = (slopeA - slopeB);
			if (denominator == 0){
				return false;
			}

			Float x = (yInterseptB - yInterseptA)/denominator;
			Float y = slopeA * x + yInterseptA;
			return x > 0 && y > 0 && x < 10;
		}

		public Float slope(int [] wire){
			return new Float((wire[1] - wire[0])/(x2-x1));
		}

		public Float intersept(int[] wire){
			return new Float(wire[0] - (slope(wire) * x1)); 
		}

	}


}
