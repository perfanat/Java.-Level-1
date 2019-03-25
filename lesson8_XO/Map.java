package lesson8_XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    int mode;
    int count=0;
    private static Random rnd = new Random();
    int movePkY;
    int movePkX;
    String movePk;
    boolean winIs = false;

    int fieldSizeX;
    int fieldSizeY;

    int[][] field;

    int winLen;

    int cellheigth;
    int cellWidth;

    boolean isInitialized = false;

    public Map() {

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });

    }

    void update(MouseEvent e) {
        if (!isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellheigth;
        int checkDot;
        String textCheckDot;

        if ((count)%2==0){
            checkDot=1;
            textCheckDot="Крестики";
        } else {
            checkDot=2;
            textCheckDot="Нолики";
        }

        if (mode==1){
            field [cellY][cellX]=checkDot;
            count++;
        } else {
            field [cellY][cellX]=1;
        }

        repaint();

        if (checkWin(checkDot)){
            JOptionPane.showMessageDialog(null, (textCheckDot+" победили!"));
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeX; j++) {
                    field[i][j]=0;
                }
            }
            winIs = true;
            isInitialized = false;
            repaint();
            return;
        }

        if (isFieldFull()){
            JOptionPane.showMessageDialog(null, ("Ничья!"));
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeX; j++) {
                    field[i][j]=0;
                }
            }
            winIs = true;
            isInitialized = false;
            repaint();
            return;
        }

        if (mode==0){
            PkMove();
            field[movePkY][movePkX]=2;
            System.out.println(movePk);
            if (checkWin(2)){
                JOptionPane.showMessageDialog(null, ("Нолики победили!"));
                for (int i = 0; i < fieldSizeX; i++) {
                    for (int j = 0; j < fieldSizeX; j++) {
                        field[i][j]=0;
                    }
                }
                winIs = true;
                isInitialized = false;
                repaint();
                return;
            }
            if (isFieldFull()){
                JOptionPane.showMessageDialog(null, ("Ничья!"));
                for (int i = 0; i < fieldSizeX; i++) {
                    for (int j = 0; j < fieldSizeX; j++) {
                        field[i][j]=0;
                    }
                }
                winIs = true;
                isInitialized = false;
                repaint();
                return;
            }
            repaint();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {

        if (!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeigth = getHeight();

        cellheigth = panelHeigth / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        if (!winIs){
            for (int i = 0; i < fieldSizeY; i++) {
                int y = i * cellheigth;
                g.drawLine(0,y,panelWidth,y);
            }

            for (int i = 0; i < fieldSizeX; i++) {
                int x = i * cellWidth;
                g.drawLine(x,0,x,panelHeigth);
            }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(cellWidth/15F));
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j]==1){
                    g2d.drawLine(j*cellWidth+cellWidth/8,i*cellheigth+cellWidth/8,j*cellWidth+cellWidth-cellWidth/8,i*cellheigth+cellheigth-cellWidth/8);
                    g2d.drawLine(j*cellWidth+cellWidth/8,i*cellheigth+cellheigth-cellWidth/8,j*cellWidth+cellWidth-cellWidth/8,i*cellheigth+cellWidth/8);
                } else if (field[i][j]==2){
                    g2d.drawOval(j*cellWidth+cellWidth/8,i*cellheigth+cellWidth/8, cellWidth-cellWidth/4,cellheigth-cellWidth/4);
                }
            }}
        }
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        this.mode=mode;
        field = new int[fieldSizeY][fieldSizeX];

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j]=0;
            }
        }

        isInitialized = true;
        repaint();
    }

    // проверка выигрыша
    private boolean checkWin (int dot){
        return check4Ver(dot)||check4Hor(dot)||check4DiagLeft(dot)||check4DiagRight(dot);
    }

    // проверка выигрыша по вертикали
    private boolean check4Ver (int dot){
        boolean res = false;
        for (int i = 0; i < field.length-winLen+1; i++) {
            for (int j = 0; j < field.length; j++) {
                res=true;
                for (int k = 0; k < winLen; k++) {
                    res&=field[i+k][j]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыша по горизонтали
    private boolean check4Hor (int dot){
        boolean res = false;
        for (int[] ints : field) {
            for (int j = 0; j < field.length - winLen + 1; j++) {
                res = true;
                for (int k = 0; k < winLen; k++) {
                    res &= ints[j + k] == dot;
                }
                if (res) break;
            }
            if (res) break;
        }
        return res;
    }

    // проверка выигрыша по левой диагонали
    private boolean check4DiagLeft (int dot){
        boolean res = false;
        for (int i = 0; i < field.length-winLen+1; i++) {
            for (int j = 0; j < field.length-winLen+1; j++) {
                res=true;
                for (int k = 0; k < winLen; k++) {
                    res&=field[i+k][j+k]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // проверка выигрыша по правой диагонали
    private boolean check4DiagRight (int dot){
        boolean res = false;
        for (int i = winLen-1; i < field.length; i++) {
            for (int j = 0; j < field.length-winLen+1; j++) {
                res=true;
                for (int k = 0; k < winLen; k++) {
                    res&=field[i-k][j+k]==dot;
                }
                if (res)break;
            }
            if (res)break;
        }
        return res;
    }

    // ход компьютера
    private void PkMove (){
        //int x=0, y=0;
        String bl="";
        String rn="";
        //boolean res=false;
        //int block=0;
        //int block2=0;
        int blockY=0;
        int blockX=0;
        int score=0;
        // блокировка левой диагонали
        for (int i = 0; i <= field.length-winLen; i++) {
            for (int j = 0; j <= field.length-winLen; j++) {
                score=0;
                for (int k = 0; k < winLen; k++) {
                    if (field[i+k][j+k] == 1) {
                        score++;
                    } else if (field[i+k][j+k] == 2){
                        score=0;
                        break;
                    } else {
                        blockY = i+k;
                        blockX = j+k;
                    }
                } if (score>1){
                    break;
                }
            } if (score>1){
                break;
            }
        }
        if (score>1){
            movePkY=blockY;
            movePkX=blockX;
            bl = " (блокирует левую диагональ)";
            movePk=("Ход компьютера: "+(movePkY+1)+" "+(movePkX+1)+bl+rn);
            return;
        }
        // блокировка правой диагонали
        for (int i = winLen-1; i < field.length; i++) {
            for (int j = 0; j <= field.length-winLen; j++) {
                score=0;
                for (int k = 0; k < winLen; k++) {
                    if (field[i-k][j+k] == 1) {
                        score++;
                    } else if (field[i-k][j+k] == 2){
                        score=0;
                        break;
                    } else {
                        blockY = i-k;
                        blockX = j+k;
                    }
                }if (score>1){
                    break;
                }
            }if (score>1){
                break;
            }
        }
        if (score>1){
            movePkY=blockY;
            movePkX=blockX;
            bl = " (блокирует правую диагональ)";
            movePk=("Ход компьютера: "+(movePkY+1)+" "+(movePkX+1)+bl+rn);
            return;
        }
        // блокировка горизонтали
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j <= field.length - winLen; j++) {
                score = 0;
                for (int k = 0; k < winLen; k++) {
                    if (field[i][j + k] == 1) {
                        score++;
                    } else if (field[i][j + k] == 2){
                        score=0;
                        break;
                    }
                    else {
                        blockY = i;
                        blockX = j+k;
                    }
                }
                if (score > 1 ) {
                    break;
                }
            }
            if (score > 1) {
                break;
            }
        }
        if (score > 1) {
            movePkY = blockY;
            movePkX = blockX;
            bl = " (блокирует горизонталь)";
            movePk=("Ход компьютера: "+(movePkY+1)+" "+(movePkX+1)+bl+rn);
            return;
        }
        // блокировка вертикаль
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j <= field.length - winLen; j++) {
                score = 0;
                for (int k = 0; k < winLen; k++) {
                    if (field[j + k][i] == 1) {
                        score++;
                    }
                    else if (field[j + k][i] == 2){
                        score=0;
                        break;
                    } else {
                        blockY = j+k;
                        blockX = i;
                    }
                }
                if (score > 1 ) {
                    break;
                }
            }
            if (score > 1 ) {
                break;
            }
        }
        if (score > 1) {
            movePkY = blockY;
            movePkX = blockX;
            bl = " (блокирует вертикаль)";
            movePk=("Ход компьютера: "+(movePkY+1)+" "+(movePkX+1)+bl+rn);
            return;
        }

        // случайный ход, если нет блокировок
        do {
            movePkY = rnd.nextInt(field.length);
            movePkX = rnd.nextInt(field.length);
            rn=" (случайный ход)";
        } while (field[movePkY][movePkX]!=0);
        movePk=("Ход компьютера: "+(movePkY+1)+" "+(movePkX+1)+bl+rn);
    }

    // проверка заполненности поля
    private boolean isFieldFull (){
        for (int[] ints : field) {
            for (int j = 0; j < field.length; j++) {
                if (ints[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
