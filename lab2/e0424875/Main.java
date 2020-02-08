import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int noOfCruise = sc.nextInt();
		sc.nextLine();
		Cruise[] cruises = new Cruise[noOfCruise];
		Loader[] myLoaders = new Loader[270];

		for (int i = 0; i < noOfCruise; i++) {
			String identifier = sc.next();
			if (identifier.charAt(0) == 'S'){
				cruises[i] = new SmallCruise(identifier, sc.nextInt());
				sc.nextLine();
			} else {
				cruises[i] = new BigCruise(identifier, sc.nextInt(), sc.nextInt(), sc.nextInt());
				sc.nextLine();
			}
		}

		for (int j = 0; j < 270; j++) {
			myLoaders[j] = new Loader(j + 1);
		}

		for (int k = 0; k < noOfCruise; k++) {
			int loadersReq = cruises[k].getNumOfLoadersRequired();
			
			int helper = 0;
				for (int j = 0; j < 270; j++) {
					if (helper == loadersReq) {
						break;
					} else if (myLoaders[j].canServe(cruises[k])){
						helper++;
						myLoaders[j] = myLoaders[j].serve(cruises[k]);
						System.out.println(myLoaders[j]);
						continue;
					} else {
						continue;
					}
				}


		}
	}
}
