package ni.preliators.game.gfx;

public class Screen {

    public static final int MAP_WIDTH = 64;
    public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;

    //public int[] tiles = new int[MAP_WIDTH * MAP_WIDTH];
    //public int[] colours = new int[MAP_WIDTH * MAP_WIDTH * 4]; //FOUR COLOURS ON SPRITESHEET

    public int[] pixels;

    public int xOffset = 0;
    public int yOffset = 0;

    public int width;
    public int height;

    public SpriteSheet sheet;

    public Screen(int width, int height, SpriteSheet sheet) {
        this.width = width;
        this.height = height;
        this.sheet = sheet;

        pixels = new int[width * height];
    }
/*
    public void render(int[] pixels, int offset, int row) {
        for (int yTile = yOffset >> 3; yTile <= (yOffset + height) >> 3; yTile++) { //MULTIPLIES - MOVE BITS WITH THREE
            int yMin = yTile * 8 - yOffset; //blocks are 8*8
            int yMax = yMin + 8;
            if (yMin < 0) yMin = 0;
            if (yMax > height) yMax = height;

            for (int xTile = xOffset >> 3; xTile <= (xOffset + width) >> 3; xTile++) { //MULTIPLIES - MOVE BITS WITH THREE
                int xMin = xTile * 8 - yOffset; //blocks are 8*8
                int xMax = xMin + 8;
                if (xMin < 0) xMin = 0;
                if (xMax > width) xMax = width;


                int tileIndex = (xTile & (MAP_WIDTH_MASK)) + yTile & (MAP_WIDTH_MASK) * MAP_WIDTH;   //Gives index of what tile we're on. sheetpixel

                for (int y = yMin; y < yMax; y++) {
                    int sheetPixel = ((y + yOffset) & 7) * sheet.width + ((xMin + xOffset) & 7);
                    int tilePixel = offset + xMin + y * row; //gets tilepixel

                    for (int x = xMin; x < xMax; x++) {
                        int colour = tileIndex * 4 + sheet.pixels[sheetPixel++]; // gets the colour from the spritesheet
                        pixels[tilePixel++] = colours[colour];
                    }
                }
            }
        }
    }
*/


    public void render(int xPos, int yPos, int tile, int colour) {
        xPos -= xOffset;
        yPos -= yOffset;

        int xTile = tile % 32;
        int yTile = tile % 32;

        int tileOffset = (xTile << 3 ) + (yTile << 3 ) * sheet.width;
        for (int y = 0; y < 8; y++) {
            if(y + yPos < 0  || y + yPos >= height) continue;
            int ySheet = y;
            for (int x = 0; x < 8; x++) {
                if(x + xPos < 0  || x + xPos >= height) continue;
                int xSheet = x;
                int col = (colour >> (sheet.pixels[xSheet + ySheet * sheet.width + tileOffset] * 8)) & 255;  // gets colour data 0, 1, 2, 4 * 255 into the colours[]
                if (col < 255 ) pixels[(x + xPos) + (y + yPos) * width] = col;
            }
        }
    }
}

