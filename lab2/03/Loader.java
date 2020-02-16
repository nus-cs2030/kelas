/*
        1. Be careful of indentation! Currently is 8 spaces per tab! 
        Ya needa find a way to fix this in your vimrc / code editor!

        2. Good to declare main class as public. 
*/
class Loader{
        private final int i;
        private final Cruise cruise;

        Loader(int i){
                this.i = i;
                this.cruise = null;
        }
        
        Loader(int i, Cruise cruise){
                this.i = i;
                this.cruise = cruise;
        }

        public int getID(){
                return i;
        }

        public Loader serve(Cruise cruiser){
                if(this.canServe(cruiser)){
                    return new Loader(this.i, cruiser);
                }
                return null;
        }

        public String toString(){
                if(this.cruise == null){
                        return "Loader " + i;
                } else {
                        return "Loader " + this.i + " serving " + this.cruise.toString();
                }
        }

        public boolean canServe(Cruise cruiser){
                if (cruiser == null || this.cruise == null){
                        return true;
                } else {
                        return this.cruise.getServiceCompletionTime() <=  cruiser.getArrivalTime();
                }
        }
}
