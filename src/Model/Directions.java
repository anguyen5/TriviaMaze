package Model;

 public enum Directions{
     Up (1), Down (2), Left (3), Right(4);

    private final int direct;

    Directions(final int code) {
        this.direct = code;
    }

    public int getDirectionCode() {
        return this.direct;
    }
}
