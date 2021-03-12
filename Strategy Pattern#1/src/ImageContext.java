import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ImageContext {
    Converter converter;

    public ImageContext(Converter converter){this.converter = converter;}
    public void setConverter(Converter converter){this.converter = converter;}

    public void changeImage(ImageInfo imageinfo) throws IOException {
        for(int y = 0; y < imageinfo.getImage().getHeight(); y++) {
            for(int x = 0; x < imageinfo.getImage().getWidth(); x++) {
                Color color = new Color(imageinfo.getImage().getRGB(x, y));
                Color newColor = converter.converterTo(color);
                imageinfo.getImage().setRGB( x, y, newColor.getRGB());
            }
        }
        converter.converterName(imageinfo);
        ImageIO.write(imageinfo.getImage(), "png", new File(imageinfo.getIName()));
        System.out.println(imageinfo.getIName());
    }
}
