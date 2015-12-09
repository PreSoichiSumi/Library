package classes;

class Pair<F, S> {
    public final F first;
    public final S second;

    Pair (F first, S second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean equals (Object obj) {
        if (! (obj instanceof Pair))
            return false;
        Pair pair = (Pair) obj;
        return (first.equals (pair.first) && second.equals (pair.second));
    }

    @Override
    public int hashCode () {
        return first.hashCode () ^ second.hashCode ();
    }
}
