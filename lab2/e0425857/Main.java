import java.util.Scanner;

public class Main {

	public static Cruise[] readCruise() { //create array of cruises

		Scanner sc = new Scanner(System.in); 
		Cruise[] cruiseArr = new Cruise[sc.nextInt()]; // first input is size of cruise array

		for (int i = 0; i < cruiseArr.length; i++) {
			String cruiseid = sc.next(); // store id else it will be gone

			if (cruiseid.charAt(0) == 'S') { // small cruise
				cruiseArr[i] = new SmallCruise(cruiseid, sc.nextInt());
			} else { // big cruise
				cruiseArr[i] = new BigCruise(cruiseid, sc.nextInt(), sc.nextDouble(), sc.nextDouble());
			}
		}

		return cruiseArr;
	}

	public static void CruiseSchedule(Cruise[] cruiseArr) {

		Loader[] loaderArr = new Loader[9 * cruiseArr.length]; //array of loaders
		int totalcount = 1; // total no. of loaders created
		Loader init_loader = new Loader(totalcount); // create first loader
		loaderArr[0] = init_loader; 		   // & put inside array

		for (Cruise cruise : cruiseArr) {
			int thiscount = 0; // no. of loaders used for each cruise

			for (int i = 0; i < totalcount && thiscount < cruise.getNumOfLoadersRequired(); i++) {

				if (loaderArr[i].canServe(cruise)) {
					loaderArr[i] = loaderArr[i].serve(cruise);
					thiscount++;
					System.out.println(loaderArr[i]);

				} else { // cant serve
				}
			
			}
	
			while (thiscount < cruise.getNumOfLoadersRequired()) {

				Loader currentloader = new Loader(totalcount + 1).serve(cruise);
				loaderArr[totalcount] = currentloader;
				thiscount++;
				totalcount++;
				System.out.println(currentloader);
			}
		}
	}

	public static void main(String[] args) {

		Cruise[] cruiseArr = readCruise();

		if (cruiseArr.length == 0) {

		} else { 
		CruiseSchedule(cruiseArr);
		}
	}
}

