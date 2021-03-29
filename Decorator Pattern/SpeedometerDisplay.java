import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SpeedometerDisplay extends DisplayDecorator {
    LabelPanel labelPanel;
    Display displayComponent;

    public SpeedometerDisplay(Display display, int width, int height) {
        super(display, width, height);
        displayComponent = display;
        labelPanel = new LabelPanel();
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
        Date date = new Date();
        labelPanel.updateText(date.toString());

    }
    //데코레이트하여 기존의 높이에서 더한다.
    public int getHeight(){
        return displayComponent.getHeight() + super.getHeight();
    }

    public int getWidth(){
        return displayComponent.getWidth() + super.getWidth();
    }
}
