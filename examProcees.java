import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class examProcees {

    @FXML
    private GridPane mGrid;
    private int index = 0;

    private ArrayList<Qustion> q1;
    private final int SPACES = 5;
    private final int QUSTION_PER_LINE= 5;
    private final int CORRECT_ANSWER = 0; // the place of the correct answer.


    public void initialize() {

        initQustionArray();
        for(Qustion r : q1)
            if(r != null)
                r.setButton();

        for(Qustion r: q1) {
            if(r != null)
                genarateAnswer(r);
        }

    }


    private void genarateAnswer(Qustion r) {
        int column = index / QUSTION_PER_LINE;
        int row = index % QUSTION_PER_LINE;

        Label label = new Label((index + 1) + ". " + r.getQustion() );
        mGrid.add(label ,column, row * SPACES);
        for(int i = 0; i < 4; i++) {
            mGrid.add( r.getRbs()[i], column, row * SPACES+ i + 1 );
        }
        index++;

    }

    private void initQustionArray() {

        q1 = new ArrayList<>();

        try {

            Scanner scan = new Scanner(getFile());

            while( scan.hasNext() )
                q1.add( createQustion(scan) );

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Found error!");
            alert.setHeaderText("File not found in the System.");
            alert.showAndWait();
        }



    }


    private File getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("select a file");
        fileChooser.setInitialDirectory(new File("."));
        return fileChooser.showOpenDialog(null);
    }


    private Qustion createQustion(Scanner scan) {
        String [] arr = new String [5];
        int i = 0;
        try {

            while(scan.hasNext() && i < 5) {
                String s = scan.nextLine().trim();
                if( !s.isEmpty() ) {
                    arr[i] = s;
                    i++;
                }
            }
            if( i >= 5) {
                Qustion r = new Qustion(arr[0],arr[1],arr[2],arr[3],arr[4]);
                return r;
            }
            else
                return null;
        }
        catch (Exception e) {
            System.out.println("fsdgfssgsgsgsgagsag!!!!");
            return null;
        }

    }

    @FXML
    void finishCheack(MouseEvent event) {
        int counter = 0;
        double scorePresantge;
        for (Qustion r : q1) {
            if ( r.getRbs()[ CORRECT_ANSWER ].isSelected() )
                counter++;
        }
        scorePresantge = (double) counter/q1.size() * 100;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exam Score");
        alert.setHeaderText("You have achieved in the exam a score of " + scorePresantge);
        alert.showAndWait();
    }

    @FXML
    void restartTest(MouseEvent event) {
        for(Qustion r :q1)
            for(int i = 0; i < 4; i++)
                r.getRbs()[i].getToggleGroup().selectToggle(null);
    }

}
