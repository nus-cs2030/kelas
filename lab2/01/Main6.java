import java.util.Scanner;

class Main6{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int A = sc.nextInt();
	Cruise[] cruises = new Cruise[A];
	for(int i=0;i<A;i++){
		String id = sc.next();
		if (id.charAt(0) == 'B'){
			int time = sc.nextInt();
			double length = sc.nextDouble();
			double passengers = sc.nextDouble();
			cruises[i] = new BigCruise(id,time, length, passengers);
		} else {
			int time = sc.nextInt();
			cruises[i] = new SmallCruise(id,time);
		}
	}
	Loader6[] loaders = new Loader6[50];
	for (int l=0;l<50;l++){
		loaders[l] = new Loader6(l+1);
	}
	for (int i=0;i<A;i++){
		for (int k=0; k < cruises[i].getNumOfLoadersRequired(); k++){
			for (int j=0;j<loaders.length;j++){
				if (loaders[j].canServe6(cruises[i])){
					loaders[j] = loaders[j].serve6(cruises[i]);
					System.out.println(loaders[j]);
					break;
				}
			}
		}
	}
	}
}
