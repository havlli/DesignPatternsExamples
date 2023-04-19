package creational.singleton.examples;

public class LazyRegistrySynchronization {

    private LazyRegistrySynchronization() {

    }

    private static volatile LazyRegistrySynchronization INSTANCE;

    public LazyRegistrySynchronization getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyRegistrySynchronization.class) {
                if (INSTANCE == null) INSTANCE = new LazyRegistrySynchronization();
            }
        }

        return INSTANCE;
    }
}
