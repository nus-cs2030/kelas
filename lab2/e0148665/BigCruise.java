public class BigCruise extends Cruise {
	public BigCruise(String a, int b, int c, int d) {
		super(a, b, (int)Math.ceil(c/40.0), (int)Math.ceil(d/50.0));
	}
}	
