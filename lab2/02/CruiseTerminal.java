import java.util.ArrayList;
import java.util.List;

public class CruiseTerminal {
    private int numLoaders;
    private List<Loader> loaders;
    private List<Loader> loaderStatuses;

    public CruiseTerminal() {
        this.numLoaders = 0;
        this.loaders = new ArrayList<>();
        this.loaderStatuses = new ArrayList<>();
    }

    private void addLoaderStatus(Loader loader) {
        loaderStatuses.add(loader);
    }

    private boolean hasIncomingRecycledLoader() {
        return numLoaders % 3 == 0;
    }

    public void addALoader(Cruise cruise) {
        numLoaders++;
        Loader loader = new Loader(numLoaders);
        Loader loadingLoader = loader.serve(cruise);
        addLoaderStatus(loadingLoader);
        loaders.add(loadingLoader);
    }

    public void addALoader6(Cruise cruise) {
        numLoaders++;
        if (hasIncomingRecycledLoader()) {
            Loader loader = new RecycledLoader(numLoaders);
            Loader loadingLoader = loader.serve(cruise);
            addLoaderStatus(loadingLoader);
            loaders.add(loadingLoader);
        } else {
            Loader loader = new Loader(numLoaders);
            Loader loadingLoader = loader.serve(cruise);
            addLoaderStatus(loadingLoader);
            loaders.add(loadingLoader);
        }
    }

    public boolean hasAnyLoader() {
        return numLoaders != 0;
    }

    public void loadCruise6(Cruise cruise) {
        int numLoadersNeeded = cruise.getNumOfLoadersRequired(); 
        if (!hasAnyLoader()) {
            for (int l = 0; l < numLoadersNeeded; l++) {
                addALoader6(cruise);
            }
        } else {
            for (int l = 0; l < numLoaders; l++) {
                Loader loader = loaders.get(l);
                Loader loadedLoader = loader.serve(cruise);
                if (loadedLoader != null) {
                    loaders.set(l, loadedLoader);
                    addLoaderStatus(loadedLoader);
                    numLoadersNeeded--;
                    if (numLoadersNeeded == 0) {
                        break;
                    }
                }
            }

            for (int i = 0; i < numLoadersNeeded; i++) {
                addALoader6(cruise);
            }
        }
    }

    public void loadCruise(Cruise cruise) {
        int numLoadersNeeded = cruise.getNumOfLoadersRequired(); 
        if (!hasAnyLoader()) {
            for (int l = 0; l < numLoadersNeeded; l++) {
                addALoader(cruise);
            }
        } else {
            for (int l = 0; l < numLoaders; l++) {
                Loader loader = loaders.get(l);
                Loader loadedLoader = loader.serve(cruise);
                if (loadedLoader != null) {
                    loaders.set(l, loadedLoader);
                    addLoaderStatus(loadedLoader);
                    numLoadersNeeded--;
                    if (numLoadersNeeded == 0) {
                        break;
                    }
                }
            }

            for (int i = 0; i < numLoadersNeeded; i++) {
                addALoader(cruise);
            }
        }
    }

    public void printStatuses() {
        for (Loader loader : loaderStatuses) {
            System.out.println(loader);
        }
    }
}
