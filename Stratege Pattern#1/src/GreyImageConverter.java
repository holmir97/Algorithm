import java.awt.Color;

public class GreyImageConverter implements Converter {

    @Override
    public Color converterTo(Color color) {

        int outputRed = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int outputGreen = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int outputBlue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

        Color newColor = new Color(outputRed, outputGreen, outputBlue);

        return newColor;
    }

    @Override
    public void converterName(ImageInfo imageInfo) {
        imageInfo.setiName("g_" + imageInfo.getIName());
    }

}
