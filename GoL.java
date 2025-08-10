public class GoL {
    int width, height;
    int[] world;

    GoL(int width, int height) {
        assert width >= 1 && height >= 1;
        this.width = width + 2;   // ergänze "unsichtbaren" Rand links und rechts
        this.height = height + 2; // ergänze "unsichtbaren" Rand oben und unten
        this.world = new int[this.width * this.height];
    }

    GoL set(int row, int col) {
        assert row >= 1 && row < height - 1 : "1 <= row < " + (height - 1);
        assert col >= 1 && col < width - 1 : "1 <= col < " + (width - 1);
        world[row * width + col] = 1;
        return this;
    }

    int countNeighbors(int row, int col) {
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue; // skip self
                sum += world[(row + i) * width + (col + j)];
            }
        }
        return sum;
    }
void tick() {
    int[] next = new int[width * height];
    for (int row = 1; row < height - 1; row++) {
        for (int col = 1; col < width - 1; col++) {
            int pos = row * width + col;
            int neighbors = countNeighbors(row, col);
            if (world[pos] == 1) {
                next[pos] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
            } else {
                next[pos] = (neighbors == 3) ? 1 : 0;
            }
        }
    }
    world = next;
    System.out.println(this);
}



    @Override public String toString() {
        String s = "";
        char[] symbols = new char[]{'.', '*'};
        for (int row = 1; row < height - 1; row++) {
            for (int col = 1; col < width - 1; col++) {
                int pos = row * width + col;
                s += symbols[world[pos]];
            }
            s += row != height ? "\n" : "";
        }
        return s;
    }
    
}

