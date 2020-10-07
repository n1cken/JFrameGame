package ni.preliators.game.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    public String path;
    public int width;
    public int height;

    public int[] pixels;

    public SpriteSheet(String path) {  //Contructor for getting Spritesheet image
        BufferedImage image = null;  //initialize
        try {
            image = ImageIO.read(SpriteSheet.class.getResource(path));  //Läser nästa dataenhet i strömmen.   //write() för att skriva i stream
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image == null) {
            return;
        }

        this.path = path;
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = image.getRGB(0, 0, width, height, null, 0, width);

        for ( int i = 0; i < pixels.length; i++ ) {
            pixels[i] = (pixels[i] & 0xff)/64; //put in 0, 1, 3, 4 into the spritesheet
            System.out.print(pixels[i]);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(pixels[i]);
            //0
            //85
            //
        }
    }
}
