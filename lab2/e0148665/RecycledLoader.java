public class RecycledLoader extends Loader {
	public RecycledLoader(int id) {
		super(id);
	}

	@Override
	public String toString() {
		if (super.sCruise != null) {
			return "Loader " + super.id + " (recycled) " + super.sCruise;
		} else {
			return "Loader " + super.id;
		}
	}
}
