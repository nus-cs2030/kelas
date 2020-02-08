import java.util.Scanner;

public class Main {
	static Cruise[] readCruises() {
		Scanner sc = new Scanner(System.in);
		Cruise[] cruises = new Cruise[sc.nextInt()];
		for (int i = 0; i < cruises.length; i++) {
			String id = sc.next();
			if (id.charAt(0) == 'B') {
				cruises[i] = new BigCruise(id, sc.nextInt(), sc.nextInt(), sc.nextInt());
			} else {
				cruises[i] = new SmallCruise(id, sc.nextInt());
			}
		}
		return cruises;
	}

	static void assignLoaders(Cruise[] cruises) {
		Loader[] loaders = new Loader[9];
		for (int i = 0; i < 9; i++) {
			loaders[i] = new Loader(i + 1);
		}

		for (int i = 0; i < cruises.length; i++) {
			int lNum = cruises[i].getNumOfLoadersRequired();
			for (int j = 0; j < 9; j++) {
				if (loaders[j].canServe(cruises[i])) {
					loaders[j] = loaders[j].serve(cruises[i]);
					System.out.println(loaders[j]);
					lNum--;
				}
				if (lNum == 0) {
					break;
				}
			}
		}
	}

	public static void main(String args[]) {
		assignLoaders(readCruises());
	}
}
