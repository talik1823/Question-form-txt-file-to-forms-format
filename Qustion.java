import javafx.css.Size;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Qustion {

    private final int SIZE = 4; // number of qustions
    private String qustion;
    private String a1;
    private String a2;
    private String a3;
    private String a4;

    private ToggleGroup toggleGroup;
    private RadioButton [] rbs;


    public Qustion() {
        this.qustion = "";
        this.a1 = "";
        this.a2 = "";
        this.a3 = "";
        this.a4 = "";
        rbs = new RadioButton[SIZE];
        toggleGroup  = new ToggleGroup();
    }

    public RadioButton[] getRbs() {
        return rbs;
    }

    public Qustion(String qustion, String a1, String a2, String a3, String a4) {
        this.qustion = qustion;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        rbs = new RadioButton[SIZE];
        toggleGroup  = new ToggleGroup();

    }

    public String getQustion() {
        return qustion;
    }

    public void setQustion(String qustion) {
        this.qustion = qustion;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public void setButton() {
        ToggleGroup group = new ToggleGroup();
        rbs[0] = new RadioButton(this.a1);
        rbs[1] = new RadioButton(this.a2);
        rbs[2] = new RadioButton(this.a3);
        rbs[3] = new RadioButton(this.a4);

        for (RadioButton r : rbs)
            r.setToggleGroup(toggleGroup);


    }
}
