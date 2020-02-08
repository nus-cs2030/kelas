import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int numberCruise = sc.nextInt();

        for ( int i = 1; i <= numberCruise ; i++){
            String ID = sc.next();
            int counter = 1;
            Loader l = new Loader(counter);
            Cruise cr = null;

            if (ID.charAt(0) == 'B'){
                cr = new BigCruise(ID, sc.nextInt(),sc.nextInt(),sc.nextInt());
            }else if  (ID.charAt(0) == 'S'){
                cr = new SmallCruise(ID, sc.nextInt());
            }
            

            if (l.canServe(cr)){
                l.serve(cr);
            }else{
                while(l.canServe(cr) == false){
                    counter++;
                    l = new Loader(counter);
                }
                l.serve(cr);
            }
        }
    }
            
}
