package patterns.builder;

public class Box {
    public int length, breadth, height;

    private Box(Builder b) {
        this.breadth = b.breadth;
        this.height = b.height;
        this.length = b.length;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // Do not use the underlying type directly. WRONG: Box b; setLength(int length) {b.length = length;}
        // Declaring the underlying type may cause creation of heavyweight objects such as a file handle.
        int length, breadth, height;
        public Builder setLength(int length) {
            this.length = length;
            return this;
        }

        public Builder setBreadth(int breadth) {
            this.breadth = breadth;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Box build() {
            return new Box(this);
        }
    }
}
