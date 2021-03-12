import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    final static String HOUSE = "house.png"; // 원본 영상 파일 이름
    BufferedImage image = ImageIO.read(new File(HOUSE));

    public Main() throws IOException { }

    public ImageInfo[] createImageArray(){
        ImageInfo[] imageLists = new ImageInfo[4];
        for(int i = 0; i < imageLists.length; i++) {
            imageLists[i] = new ImageInfo(HOUSE, image);
        }
        return imageLists;
    }


    public static void main(String[] args) throws IOException {
        Main m = new Main();
        ImageInfo[] img= m.createImageArray();

        ImageContext imageContext = new ImageContext(new GreyImageConverter());
        imageContext.changeImage(img[1]);
        System.out.println("흑백 저장 완료");

        imageContext.setConverter(new InverseImageConverter());
        imageContext.changeImage(img[2]);
        System.out.println("반전 저장 완료");

        imageContext.setConverter(new SepiaImageConverter());
        imageContext.changeImage(img[3]);
        System.out.println("세피아 저장 완료");


    }
}
