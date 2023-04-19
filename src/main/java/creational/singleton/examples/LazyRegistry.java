package creational.singleton.examples;

public class LazyRegistry {

    private LazyRegistry() {

    }

    private static LazyRegistry INSTANCE;

    public LazyRegistry getInstance() {
        if (INSTANCE == null) INSTANCE = new LazyRegistry();

        return INSTANCE;
    }
}
