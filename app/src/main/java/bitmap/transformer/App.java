
package bitmap.transformer;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.Locale;

public class App {

    public static void main(String[] args) {

        System.out.println("********************************");
        String str = args[0].toString();
        BitMap image = new BitMap(str);
        String transform =args[2];
        String path = args[1];
        if(transform.toLowerCase().equals("invert")) {
            image.invert(path);
        }
        else if(transform.toLowerCase().equals("mirrorimage")) {
                image.mirrorImage(path);
        }

        else if(transform.toLowerCase().equals("blackandwhite")){
            image.BlackAndWhite(path);
        }
        else {
//            System.out.println(args[1]);
            System.out.println("Please choose the trasnform from these: invert, mirrorImage, or BlackAndWhite");
        }
    }
}


