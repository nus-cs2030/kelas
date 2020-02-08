public class LoaderRecycled extends Loader{
	public LoaderRecycled(int id){
		super(id);
	}

	public LoaderRecycled(int id, int time, Cruise cruise){
		super(id, time, cruise);
	}

	@Override
	public Loader serve(Cruise cruise) {
		if(cruise == null) {
			return new Loader(this.id);
		}else if(this.canServe(cruise)) {
			if(this.id % 3 == 0){
				return new LoaderRecycled(this.id, cruise.getServiceCompletionTime() + 60, cruise);
			}else{
				return new LoaderRecycled(this.id, cruise.getServiceCompletionTime(), cruise);
			}
		}else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		if(this.cruise == null) {
			return "Loader " + this.id;
		}else {
			if(this.id % 3 == 0){
				return "Loader " + this.id + " (recycled) serving " + this.cruise;
			}else{
				return "Loader " + this.id + " serving " + this.cruise;
			}
		}
	}
}
