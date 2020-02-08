import java.util.Scanner;

class Main {
	static Cruise[] readCruise() {
		Scanner sc = new Scanner(System.in);
		Cruise[] cruises = new Cruise[sc.nextInt()];
		for (int i = 0; i < cruises.length; i++) {
			String ID = sc.next();
			if (ID.contains("B")) {
				cruises[i] = new BigCruise(ID, sc.nextInt(), sc.nextDouble(), sc.nextDouble());
			} else {
				cruises[i] = new SmallCruise(ID, sc.nextInt());
			}
		}
		return cruises;
	}

	private static void allocate(Cruise[] cruises) {
		Loader[] loaders = new Loader[9 * cruises.length];
		loaders[0] = new Loader(1);
		int totalLoaders = 1;
		for (Cruise cruise: cruises) {

			int count = cruise.getNumOfLoadersRequired();

			for (int j = 0; j < totalLoaders && count > 0; j++) {
				if (loaders[j].canServe(cruise)) {
					loaders[j] = loaders[j].serve(cruise);
					System.out.println(loaders[j]);
					count--;
				}
			}

			while (count > 0) {
				int loaderID = totalLoaders + 1;
                loaders[totalLoaders] = new Loader(loaderID).serve(cruise);
				System.out.println(loaders[totalLoaders]);
				totalLoaders++;
				count--;        
			}
		}
	}

	public static void main(String[] args) {
		Cruise[] cruises = readCruise();
        if (cruises.length == 0) {
        } else {
		    allocate(cruises);
        }
	}
}
