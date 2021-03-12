import java.awt.*;

public class SepiaImageConverter implements Converter{

    @Override
    public Color converterTo(Color color) {

        int grey = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int outputRed = 230 * grey / 255;
        int outputGreen = 180 * grey / 255;
        int outputBlue =  150 * grey / 255;

        Color newColor = new Color(outputRed, outputGreen, outputBlue);

        return newColor;

    }
    @Override
    public void converterName(ImageInfo imageInfo) {
        imageInfo.setiName("s_" + imageInfo.getIName());
    }

}
