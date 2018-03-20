package libcore.icu;

/**
 * Created by zsn on 2016/12/9 at 18:11.
 */
public final class Transliterator {
    private long peer;
    /**
     * Creates a new Transliterator for the given id.
     */
    public Transliterator(String id) {
        peer = create(id);
    }
    @Override
    protected synchronized void finalize() throws Throwable {
        try {
            destroy(peer);
            peer = 0;
        } finally {
            super.finalize();
        }
    }
    /**
     * Returns the ids of all known transliterators.
     */
    public static native String[] getAvailableIDs();
    /**
     * Transliterates the specified string.
     */
    public String transliterate(String s) {
        return transliterate(peer, s);
    }
    private static native long create(String id);
    private static native void destroy(long peer);
    private static native String transliterate(long peer, String s);
}