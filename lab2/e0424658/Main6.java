class Main6 extends Main{
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        Cruise[] cruises = new Cruise[n];

        int nloader = 0;
        for (int i = 0; i < n; i++){
            String id = sc.next();
            if(id.charAt(0) == 'S'){
                int arrivalt = sc.nextInt();
                cruises[i] = new SmallCruise(id, arrivalt);
                nloader +=1;
            } else if (id.charAt(0) == 'B'){
                int arrivalt = sc.nextInt();
                int len_cr = sc.nextInt();
                int passen_num = sc.nextInt();
                cruises[i] = new BigCruise(id, arrivalt, len_cr, passen_num);
                nloader += cruises[i].getNumOfLoadersRequired();
            } else {
                int arrivalt = sc.nextInt();
                int loaders = sc.nextInt();
                int servet = sc.nextInt();
                cruises[i] = new Cruise(id, arrivalt, loaders, servet);
                nloader += loaders;
            }
        }

        Loader[] loaders = new Loader[270];

        for(int i = 0; i < nloader; i++){
            loaders[i] = (i+1)%3 == 0 ? new Loader6(i+1) : new Loader(i+1);
        }

        for(Cruise cruise : cruises){
            for(int i = 1; i <= cruise.getNumOfLoadersRequired(); i++){
                for(int t = 0; t <= nloader; t++){
                    if(loaders[t].canServe(cruise)){
                        loaders[t] = loaders[t].serve(cruise);
                        System.out.println(loaders[t]);
                        break;
                    } else{
                        continue;
                    }
                }
            }
        }



    }

}
