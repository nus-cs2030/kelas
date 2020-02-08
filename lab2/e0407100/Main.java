import java.util.Scanner;
import java.util.ArrayList;
class Main{

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		ArrayList<Loader> list = new ArrayList<Loader>();
		ArrayList<Loader> schedule = new ArrayList<Loader>();
		int ID = 1;
		for(int i = 0; i<size; i++){
			Cruise cruise;
			String name = sc.next();
			int arrivalTime = sc.nextInt();
			switch(name.charAt(0)){
				case 'S':
					cruise = new SmallCruise(name,arrivalTime);
					break;
				case 'B':
					double length = sc.nextDouble();
					double passengers = sc.nextDouble();
					cruise = new BigCruise(name,arrivalTime,length,passengers);
					break;
				default:
					cruise = null;
			}	
			int n = cruise.getNumOfLoadersRequired(); 
			//need to issue n number of loaders
			while(n>0){
				boolean assign = false;
				for(int t = 0; t<list.size(); t++){
					Loader currentLoader = list.get(t);
					if(currentLoader.canServe(cruise)){
						list.set(t, currentLoader.serve(cruise));
						schedule.add(currentLoader.serve(cruise));
						assign = true;
						break;
					}else{
						continue;
					}
				}
				if(!assign){
					list.add(new Loader(ID).serve(cruise));
					schedule.add(new Loader(ID).serve(cruise));
					ID++;
				}
				n--;
			}



		}
		//print all schedule
		for(int k = 0;k<schedule.size();k++){
			System.out.println(schedule.get(k));
		}

	}

}

