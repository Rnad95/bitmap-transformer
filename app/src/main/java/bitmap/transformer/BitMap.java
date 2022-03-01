package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitMap {
    public BufferedImage image;
    public String output;
    public int[][] array2D;
    public BitMap(String bitMapFile) {
        try{
            File file = new File("/home/renad/Desktop/LTUCTraining/Advance/bitmap-transformer/app/src/main/resources/"+bitMapFile);
            this.image = ImageIO.read(file);
            array2D = new int[image.getWidth()][image.getHeight()];
            for (int i = 0; i < image.getWidth(); i++) { // column
                for (int j = 0; j < image.getHeight(); j++) { // row
                   array2D[i][j] = image.getRGB(i,j);
                }


            }
        } catch (IOException err){
            System.out.println(err.getMessage());
        }
    }


    public String BlackAndWhite(String output) {
        System.out.println("Convert The image to Array");
        int[][] newArr =  new int[image.getWidth()][image.getHeight()];
        System.out.println("*********************");
        System.out.println("Change the Color");
        for (int i = 0; i < image.getWidth(); i++) { // column
            for (int j = 0; j < image.getHeight(); j++) { // row
              int p = image.getRGB(i,j);
              boolean alpha = false;
              Color color = new Color(p,alpha);

              int greyImg = (color.getRed() + color.getBlue() + color.getGreen())/3;
                int[] colorArr = new int[] { greyImg, greyImg, greyImg };
                String[] colorBnW = new String[colorArr.length];

                for (int k = 0; k <colorArr.length ; k++) {
                    if (colorArr[k] < 16) {
                        colorBnW[k] = "0" + Integer.toHexString(colorArr[k]);
                    } else {
                        colorBnW[k] = Integer.toHexString(colorArr[k]);
                    }
                }

                String hex = colorBnW[0] + "" + colorBnW[1] + "" + colorBnW[2];
                image.setRGB(i, j, Integer.parseInt(hex, 16));
            }

        }
        System.out.println("*********************");
        System.out.println("The Color is Changed");
       try{
           System.out.println("*********************");
           System.out.println("Try to Create a new image");
           File newImage = new File(output+"/BlackAndWhite.bmp");
           ImageIO.write(image,"bmp", newImage);
           System.out.println("The new image is created Successfully :)");
           System.out.println("****************************");
           return "The Color is Changed";
       }catch (IOException err){
           System.out.println(err.getMessage());
           System.out.println("****************************");
           return "Failed";
       }

    }

    public String invert(String output){
        System.out.println("*********************");
        System.out.println("Reading the image");
        int[][] newArr =  new int[image.getWidth()][image.getHeight()];
        System.out.println("*********************");
        System.out.println("Apply the invert operation");
        for (int i = 0; i < image.getWidth(); i++) { // column
            for (int j = 0; j < image.getHeight(); j++) { // row
                int color = image.getRGB(i, j);
                int p = -1* color;
                image.setRGB(i,j,p);

            }
        }
        System.out.println("The image is inverted");
        try{
            System.out.println("*********************");
            System.out.println("Try to create a new Image");
            File newImage = new File(output+"/invert.bmp");
            ImageIO.write(image,"bmp", newImage);
            System.out.println("The new image is created Successfully :)");
            System.out.println("****************************");
            return "The new image is created Successfully :)";



        }catch (IOException err){
            System.out.println(err.getMessage());
            System.out.println("****************************");
            return "failed";
        }
    }

    public String mirrorImage(String output){
        System.out.println("*********************");
        System.out.println("Reading the Image");
        int[][] newArr =  new int[image.getWidth()][image.getHeight()];
        BufferedImage mirrorImage = image;
        int lastIndex = image.getWidth() - 1;
        System.out.println("*********************");
        System.out.println("Change the color to gray - scale");
        for (int i = 0; i < image.getWidth(); i++) { // column
            for (int j = 0; j < image.getHeight(); j++) { // row
                    int p = image.getRGB(lastIndex,j);
                    image.setRGB(i,j,p);
            }
            lastIndex--;
        }
        System.out.println("The Mirror of image operation is applied");
        try{
            System.out.println("*********************");
            System.out.println("Try to create a new Image");
            File newImage = new File(output+"/MirrorImage.bmp");
            ImageIO.write(image,"bmp", newImage);

            System.out.println("The new image is created Successfully :)");
            System.out.println("****************************");
            return "The new image is created Successfully :)";
        }catch (IOException err){
            System.out.println(err.getMessage());
            System.out.println("****************************");
            return "Failed";
        }
    }


}
