import java.util.Scanner;

class Main6 {
	
	
	static Cruise[] readCruise() {
		Scanner sc = new Scanner(System.in);
		Cruise[] cruises = new Cruise[sc.nextInt()];
		
		for (int i = 0; i < cruises.length; i++) {
			String id = sc.next();
			if ( id.charAt(0) == 'S') {
				cruises[i] = new SmallCruise(id, sc.nextInt());
			} else {
				cruises[i] = new BigCruise(id, sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		}
		return cruises;
	}

	static void schedule(Cruise[] cruises) {

		Loader[] loaders = new Loader[270];
		for (int i = 0; i < 270; i++) {
			if ( (i+1) % 3 == 0) {
				loaders[i] = new rLoader(i+1);
			} else {
				loaders[i] = new Loader(i+1);
			}
		}

		for (Cruise c : cruises) {
			
			for (int i = 0; i < c.getNumOfLoadersRequired(); i++) {
				
				for (int j = 0; j < 270; j++) {
					if (loaders[j].canServe(c)) {
						loaders[j] = loaders[j].serve(c);
						System.out.println(loaders[j]);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Cruise[] cruises = readCruise();
		Main6.schedule(cruises);
	}
 	
}
