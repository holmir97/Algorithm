import java.awt.*;

public class InverseImageConverter implements Converter{
    @Override
    public Color converterTo(Color color) {

        int outputRed = 255 - color.getRed();
        int outputGreen = 255 - color.getGreen();
        int outputBlue = 255 - color.getBlue();

        Color newColor = new Color(outputRed, outputGreen, outputBlue);


        return newColor;
    }

    @Override
    public void converterName(ImageInfo imageInfo) {
        imageInfo.setiName("i_" + imageInfo.getIName());
    }

}
