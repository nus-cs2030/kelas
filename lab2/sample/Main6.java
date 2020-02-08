import java.util.Scanner;

class Main6 {
  public static int MAX_LOADER = 9;
  public static int MAX_CRUISE = 30;

  static Loader buyLoader(int id) {
    if (id % 3 == 0) {
      return new RecycledLoader(id);
    } else {
      return new Loader(id);
    }
  }

  static void findLoaders(Cruise c, Loader[] loaders) {
    int count = 0;
    for (int i = 0; i < loaders.length; i++) {
      if (loaders[i] == null) {
        loaders[i] = buyLoader(i + 1);
      }
      if (loaders[i].canServe(c)) {
        loaders[i] = loaders[i].serve(c);
        System.out.println(loaders[i]);
        count ++;
        if (count == c.getNumOfLoadersRequired()) {
          return;
        }
      }
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Loader[] loaders = new Loader[MAX_LOADER*MAX_CRUISE];

    int numOfCruises = sc.nextInt();
    for (int i = 0; i < numOfCruises; i++) {
      String id = sc.next();
      int arrivalTime = sc.nextInt();
      Cruise c;
      if (id.charAt(0) == 'S') {
        c = new SmallCruise(id, arrivalTime);
      } else {
        int length = sc.nextInt();
        int numOfPassenger = sc.nextInt();
        c = new BigCruise(id, arrivalTime, length, numOfPassenger);
      }

      findLoaders(c, loaders);
      
    }
    sc.close();
  }
}
