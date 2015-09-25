public class Wire {

	int[] args;
	Float slope;
	Float yIntersept;

	public Wire(String line){

		String[] exploded = line.split(" ");
		args = new int[exploded.length];

		for (int i = 0; i < exploded.length; i++){
			args[i] = Integer.parseInt(exploded[i]);
		}

		Float x1 = (float) 0;
		Float x2 = (float) 10;

		Float y1 = new Float(args[0]);
		Float y2 = new Float(args[1]);

		slope = (y2 - y1)/(x2 - x1);

		//y = mx +b
		//b = y - mx
		yIntersept = y1 - (slope * x1); 

	}

	public Boolean intersects(Wire other){

		//parallel
		if (this.slope == other.slope){
			return false;
		}

		Float denominator = (this.slope - other.slope);

		if (denominator == 0){
			return false;
		}

		Float x = (other.yIntersept - this.yIntersept)/denominator;
		Float y = this.slope * x + this.yIntersept;

		return x > 0 && y > 0 && x < 10;

	}

}
