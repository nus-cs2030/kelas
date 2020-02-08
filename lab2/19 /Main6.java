import java.util.Scanner;

public class Main6 {

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
					Loader newloader = loaderArr[i].serve(cruise);
					loaderArr[i] = newloader;
					thiscount++;
					System.out.println(loaderArr[i]);

				} else { // cant serve
				}
			
			}
	
			while (thiscount < cruise.getNumOfLoadersRequired()) {

				if ((totalcount + 1) % 3 == 0) {

					loaderArr[totalcount] = new RecycledLoader(totalcount + 1).serve(cruise);
		
				} else {
					loaderArr[totalcount] = new Loader(totalcount + 1).serve(cruise);
				}

				System.out.println(loaderArr[totalcount]);
				thiscount++;
				totalcount++;
			}
		}	
	} 

	public static void main(String[] args) { 

		Cruise[] cruiseArr = readCruise();
		CruiseSchedule(cruiseArr);
	}
}

