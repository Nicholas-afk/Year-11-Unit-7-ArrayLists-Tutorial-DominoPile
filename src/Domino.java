public class Domino implements Comparable<Domino> {
    private int top;
    private int bottom;

    public Domino() {
        this.top = 0;
        this.bottom = 0;
    }

    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public String toString() {
        return top + "/" + bottom;
    }

    public void flip() {
        int temp = top;
        top = bottom;
        bottom = temp;
    }

    public void settle() {
        if (bottom < top) {
            flip();
        }
    }

    public int compareTo(Domino other) {
        int thisMin = Math.min(this.top, this.bottom);
        int otherMin = Math.min(other.top, other.bottom);

        if (thisMin < otherMin) {
            return -1;
        } else if (thisMin > otherMin) {
            return 1;
        } else {
            int thisMax = Math.max(this.top, this.bottom);
            int otherMax = Math.max(other.top, other.bottom);

            if (thisMax < otherMax) {
                return -1;
            } else if (thisMax > otherMax) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int compareToWeight(Domino other) {
        int thisWeight = this.top + this.bottom;
        int otherWeight = other.top + other.bottom;

        if (thisWeight < otherWeight) {
            return -1;
        } else if (thisWeight > otherWeight) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean canConnect(Domino other) {
        return this.top == other.top ||
                this.top == other.bottom ||
                this.bottom == other.top ||
                this.bottom == other.bottom;
    }
}
