import java.awt.image.BufferedImage;

public class ImageInfo {
    private String iName;
    private BufferedImage image;

    public ImageInfo(String iName, BufferedImage image){
        this.iName = iName;
        this.image = image;
    }

    public String getIName() { return iName; }
    public BufferedImage getImage() { return image; }
    public void setiName(String iName) { this.iName = iName; }

}
