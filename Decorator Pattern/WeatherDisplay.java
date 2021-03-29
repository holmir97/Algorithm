import java.awt.Dimension;
import javax.swing.*;


public class WeatherDisplay extends DisplayDecorator {
    LabelPanel labelPanel;
    Display displayComponent;

    WeatherDisplay(Display display, int width, int height) {
        super(display, width, height);
        this.displayComponent = display;
        this.labelPanel = new LabelPanel();
    }

    @Override
    public JPanel create() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,1 ));
        JPanel subPanel = displayComponent.create();
        jPanel.add(subPanel);
        jPanel.add(labelPanel.createPanel(getWidth(), getHeight()));
        jPanel.setPreferredSize((new Dimension(getWidth(), getHeight())));
        return jPanel;
    }

    @Override
    public void show() {
        displayComponent.show();
        labelPanel.updateText("Weather: 온도: 20 , 습도: 60 ");
    }

    //데코레이트하여 기존의 높이에서 더한다.
    public int getHeight(){
        return displayComponent.getHeight() + super.getHeight();
    }

    public int getWidth(){
        return displayComponent.getWidth() + super.getWidth();
    }
}
