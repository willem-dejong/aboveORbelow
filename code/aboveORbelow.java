//Willem DeJong
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Is it Above or Below is a game where you guess if the next card is higher or lower.
 * 
 * @author (Willem DeJong) 
 * @version (12/2/2012)
 */
public class aboveORbelow extends JFrame implements ActionListener
{//start lvl (1:1,1.1.1.1.1)
    private String score=null;
    private Container pane1;
    private JButton start,resume,cont,above,below;
    private JPanel pane2,pane3,top,bot,center2,center1,leftcard,rightcard;
    private JLabel toptxt=new JLabel(""),bottxt=new JLabel(""),helptxt1,helptxt2,helptxt3,helptxt4,helptxt5,resulttxt;
    private Icon b=new ImageIcon("back.jpg"),p1=new ImageIcon("spadeA.jpg"),p2=new ImageIcon("spade2.jpg"),p3=new ImageIcon("spade3.jpg"),p4=new ImageIcon("spade4.jpg"),p5=new ImageIcon("spade5.jpg"),p6=new ImageIcon("spade6.jpg"),p7=new ImageIcon("spade7.jpg"),p8=new ImageIcon("spade8.jpg"),p9=new ImageIcon("spade9.jpg"),p10=new ImageIcon("spade10.jpg"),p11=new ImageIcon("spadeJ.jpg"),p12=new ImageIcon("spadeQ.jpg"),p13=new ImageIcon("spadeK.jpg"),p14=new ImageIcon("clubA.jpg"),p15=new ImageIcon("club2.jpg"),p16=new ImageIcon("club3.jpg"),p17=new ImageIcon("club4.jpg"),p18=new ImageIcon("club5.jpg"),p19=new ImageIcon("club6.jpg"),p20=new ImageIcon("club7.jpg"),p21=new ImageIcon("club8.jpg"),p22=new ImageIcon("club9.jpg"),p23=new ImageIcon("club10.jpg"),p24=new ImageIcon("clubJ.jpg"),p25=new ImageIcon("clubQ.jpg"),p26=new ImageIcon("clubK.jpg"),p27=new ImageIcon("heartA.jpg"),p28=new ImageIcon("heart2.jpg"),p29=new ImageIcon("heart3.jpg"),p30=new ImageIcon("heart4.jpg"),p31=new ImageIcon("heart5.jpg"),p32=new ImageIcon("heart6.jpg"),p33=new ImageIcon("heart7.jpg"),p34=new ImageIcon("heart8.jpg"),p35=new ImageIcon("heart9.jpg"),p36=new ImageIcon("heart10.jpg"),p37=new ImageIcon("heartJ.jpg"),p38=new ImageIcon("heartQ.jpg"),p39=new ImageIcon("heartK.jpg"),p40=new ImageIcon("diamondA.jpg"),p41=new ImageIcon("diamond2.jpg"),p42=new ImageIcon("diamond3.jpg"),p43=new ImageIcon("diamond4.jpg"),p44=new ImageIcon("diamond5.jpg"),p45=new ImageIcon("diamond6.jpg"),p46=new ImageIcon("diamond7.jpg"),p47=new ImageIcon("diamond8.jpg"),p48=new ImageIcon("diamond9.jpg"),p49=new ImageIcon("diamond10.jpg"),p50=new ImageIcon("diamondJ.jpg"),p51=new ImageIcon("diamondQ.jpg"),p52=new ImageIcon("diamondK.jpg");
    private JLabel back=new JLabel(b),c1=new JLabel(p1),c2=new JLabel(p2),c3=new JLabel(p3),c4=new JLabel(p4),c5=new JLabel(p5),c6=new JLabel(p6),c7=new JLabel(p7),c8=new JLabel(p8),c9=new JLabel(p9),c10=new JLabel(p10),c11=new JLabel(p11),c12=new JLabel(p12),c13=new JLabel(p13),c14=new JLabel(p14),c15=new JLabel(p15),c16=new JLabel(p16),c17=new JLabel(p17),c18=new JLabel(p18),c19=new JLabel(p19),c20=new JLabel(p20),c21=new JLabel(p21),c22=new JLabel(p22),c23=new JLabel(p23),c24=new JLabel(p24),c25=new JLabel(p25),c26=new JLabel(p26),c27=new JLabel(p27),c28=new JLabel(p28),c29=new JLabel(p29),c30=new JLabel(p30),c31=new JLabel(p31),c32=new JLabel(p32),c33=new JLabel(p33),c34=new JLabel(p34),c35=new JLabel(p35),c36=new JLabel(p36),c37=new JLabel(p37),c38=new JLabel(p38),c39=new JLabel(p39),c40=new JLabel(p40),c41=new JLabel(p41),c42=new JLabel(p42),c43=new JLabel(p43),c44=new JLabel(p44),c45=new JLabel(p45),c46=new JLabel(p46),c47=new JLabel(p47),c48=new JLabel(p48),c49=new JLabel(p49),c50=new JLabel(p50),c51=new JLabel(p51),c52=new JLabel(p52);
    private JLabel[] cards ={back,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52};
    private JMenuBar menubar;                                //above is the set up for the images for cards
    private JMenuItem helpm;
    private int chips=1000, choice,round=0,cardL,cardR; 
    private Font f = new Font("biger",Font.PLAIN,25);
    private deck dd=new deck("every day I'm shuffle'n");//any string in argument constructs a shuffled deck
    public void actionPerformed(ActionEvent e)//button actions
    {//start lvl (1:2,1.1.1.1.1)
        String s=e.getActionCommand();
        int x=Integer.parseInt(s);
        if(round==51||chips<=0)
        {//start lvl (1:3,1.1.1.1.1)
            x=4;
        }//end lvl (1:3,1.1.1.1.1)
        switch(x)
        {//start lvl (1:3,1.1.2.1.1)
            case 1://action for above it will depaint and repaint cards to display both cards and tell you if you were right or wrong aswell as update score.
                depaint();
                paintcards1();
                repaint();
                center2.remove(above);
                center2.remove(below);
                center2.add(cont);
                repaint();
                score(1);
                round=round+1;
                break;
            case 2://actions for below it will depaint and repaint cards to display both cards and tell you if you were right or wrong aswell as update score.
                depaint();
                paintcards1();
                repaint();
                center2.remove(above);
                center2.remove(below);
                center2.add(cont);
                repaint();
                score(-1);
                round=round+1;
                break;
            case 3://actions for continue(cont) it will depaint and repaint cards displaying only one card(the next card in deck).
                center2.remove(cont);
                center2.add(above);
                center2.add(below);
                depaint();
                paintcards2();
                toptxt();
                repaint();
                break;
            case 4://action for cont when end of deck or out of chips tels you if you lose or not if not then tells you your score.
                center2.remove(leftcard);
                center2.remove(rightcard);
                center2.remove(cont);
                repaint();
                center2.add(resulttxt);
                center2.add(start);
                toptxt.setText("Game Over");
                bottxt.setText("Play Again?");
                if (chips<=0)
                {//start lvl (1:4,1.1.2.1.1)
                    resulttxt.setText("                           You Lose!!");
                }//end lvl (1:4,1.1.2.1.1)
                else 
                {//start lvl (1:4,1.1.2.2.1)
                    resulttxt.setText("Congradulations, your score is "+chips);
                    repaint();
                }//end lvl (1:4,1.1.2.2.1)
                round=0;
                chips=1000;
                break;
            case 5://allows to play again
                center2.remove(resulttxt);
                center2.remove(start);
                toptxt();
                center2.add(leftcard);
                center2.add(rightcard);
                center2.add(above);
                center2.add(below);
                depaint();
                dd.shuffle();//shuffles deck for new game
                paintcards2();
                repaint();
                break;
            case 6://action for help displays help screen
                center1.remove(center2);
                center1.add(pane3);
                repaint();
                break;
            case 7://resumes game after help
                center1.remove(pane3);
                center1.add(center2);
                repaint();
                break;
        }//end lvl (1:3,1.1.2.1.1)
    }//end lvl (1:2,1.1.1.1.1)
    public void toptxt()//sets toptxt back to v v v v
    {//start lvl (1:2,1.2.1.1.1)
        toptxt.setText("Predict whether the next card is greater or less.");
    }//end lvl (1:2,1.2.1.1.1)
    public void score(int c)//updates score aswell as inform if right or wrong
    {//start lvl (1:2,1.3.1.1.1)
        if(c==1)//above
        {//start lvl (1:3,1.3.1.1.1)
            choice=dd.deck[round+1].compareFace(dd.deck[round]);
            if(choice>=0)
            {//start lvl (1:4,1.3.1.1.1)
                toptxt.setText(null);
                chips=chips+100;
                toptxt.setText("Correct!(+100)");
                printscore();
                repaint();
            }//end lvl (1:4,1.3.1.1.1)
            else
            {//start lvl (1:4,1.3.1.2.1)
                toptxt.setText(null);
                chips=chips-200;
                toptxt.setText("Incorrect!(-200)");
                printscore();
                repaint();
            }//end lvl (1:4,1.3.1.2.1)
        }//end lvl (1:3,1.3.1.1.1)
        else//below
        {//start lvl (1:3,1.3.2.1.1)
            choice=dd.deck[round+1].compareFace(dd.deck[round]);
            if(choice<=0)
            {//start lvl (1:4,1.3.2.1.1)
                chips=chips+100;
                toptxt.setText("Correct!(+100)");
                printscore();
                repaint();
            }//end lvl (1:4,1.3.2.1.1)
            else
            {//start lvl (1:4,1.3.2.2.1)
                chips=chips-200;
                toptxt.setText("Incorrect!(-200)");
                printscore();
                repaint();
            }//end lvl (1:4,1.3.2.2.1)
        }//end lvl (1:3,1.3.2.1.1)
    }//end lvl (1:2,1.3.1.1.1)
    public void depaint()//removes current cards
    {//start lvl (1:2,1.4.1.1.1)
        leftcard.removeAll();
        rightcard.removeAll();
        repaint();
    }//end lvl (1:2,1.4.1.1.1)
    public void paintcards1()//paints the cards for after guess.
    {//start lvl (1:2,1.5.1.1.1)
        cardL=dd.deck[round+1].getmast();
        cardR=dd.deck[round].getmast();
        leftcard.add(cards[cardL]);
        cards[cardL].setSize(250,350);
        rightcard.add(cards[cardR]);
        cards[cardR].setSize(250,350);
        repaint();
    }//end lvl (1:2,1.5.1.1.1)
    public void paintcards2()//paints the cards for before the guess
    {//start lvl (1:2,1.6.1.1.1)
        cardL=0;
        cardR=dd.deck[round].getmast();
        leftcard.add(cards[cardL]);
        cards[cardL].setSize(250,350);
        cards[cardL].setLocation(0,0);
        rightcard.add(cards[cardR]);
        cards[cardR].setSize(250,350);
        cards[cardR].setLocation(0,0);
        repaint();
    }//end lvl (1:2,1.6.1.1.1)
    public aboveORbelow() //game window
    {//start lvl (1:2,1.7.1.1.1)
        setSize(1000,700);
        setResizable(false);
        pane1=getContentPane();
        setLocation(0,0);
        setLayout(new BorderLayout());
        pane1.add(menubar=new JMenuBar(),BorderLayout.NORTH);
        menubar.add(helpm=new JMenuItem("Help"));
        helpm.addActionListener(this);
        helpm.setActionCommand("6");
        setTitle("More Or Less!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane1.add(pane2=new JPanel(),BorderLayout.CENTER);
        pane2.setLayout(new BorderLayout());
        pane2.add(top=new JPanel(),BorderLayout.NORTH);
        top.add(toptxt=new JLabel("Predict whether the next card is greater or less."));
        toptxt.setFont(f);
        top.setBackground(Color.RED);
        pane2.add(bot=new JPanel(),BorderLayout.SOUTH);
        bot.add(bottxt=new JLabel(""));
        printscore();
        bot.setBackground(Color.RED);
        bottxt.setFont(f);
        pane2.add(center1=new JPanel(),BorderLayout.CENTER);
        center1.setLayout(new BorderLayout());
        center1.add(center2=new JPanel(),BorderLayout.CENTER);
        center2.setLayout(null);
        center2.setBackground(Color.BLUE);
        center2.add(leftcard=new JPanel());
        leftcard.setSize(250,350);
        leftcard.setLocation(150,50);
        center2.add(rightcard=new JPanel());
        rightcard.setSize(250,350);
        rightcard.setLocation(500,50);
        paintcards2();
        center2.add(above=new JButton("Above"));
        above.setSize(250,50);
        above.setLocation(150,410);
        above.setFont(f);
        above.addActionListener(this);
        above.setActionCommand("1");
        center2.add(below=new JButton("Below"));
        below.setSize(250,50);
        below.setLocation(500,410);
        below.setFont(f);
        below.addActionListener(this);
        below.setActionCommand("2");
        cont=new JButton("Continue");
        cont.setSize(250,50);
        cont.setLocation(325,410);
        cont.setFont(f);
        cont.setActionCommand("3");
        cont.addActionListener(this);
        resulttxt=new JLabel();
        resulttxt.setSize(500,575);
        resulttxt.setLocation(250,0);
        resulttxt.setFont(f);
        start=new JButton("Play");
        start.setSize(250,50);
        start.setLocation(350,410);
        start.addActionListener(this);
        start.setActionCommand("5");
        start.setFont(f);
        helpsetup();
    }//end lvl (1:2,1.7.1.1.1)
    public void printscore()//updates the score text
    {//start lvl (1:2,1.8.1.1.1)
         score=""+(chips);
         bottxt.setText("                         Score: "+score);
    }//end lvl (1:2,1.8.1.1.1)
    public static void main (String[]args)
    {//start lvl (1:2,1.9.1.1.1)
        aboveORbelow frame=new aboveORbelow();
        frame.setVisible(true);
    }//end lvl (1:2,1.9.1.1.1)
    public void helpsetup()//sets up the help window
    {//start lvl (1:2,1.10.1.1.1)
        pane3=new JPanel();
        pane3.setSize(1000,600);
        pane3.setBackground(Color.WHITE);
        pane3.setLayout(null);
        pane3.add(resume=new JButton("Resume"));//resume resumes where you left off
        resume.setSize(250,50);
        resume.setLocation(350,410);
        resume.setFont(f);
        resume.setActionCommand("7");
        resume.addActionListener(this);
        pane3.add(helptxt1=new JLabel(""));//helptxts are the texts for the help window
        pane3.add(helptxt2=new JLabel(""));
        pane3.add(helptxt3=new JLabel(""));
        pane3.add(helptxt4=new JLabel(""));
        pane3.add(helptxt5=new JLabel(""));
        helptxt1.setSize(1000,50);
        helptxt2.setSize(1000,50);
        helptxt3.setSize(1000,50);
        helptxt4.setSize(1000,50);
        helptxt5.setSize(1000,50);
        helptxt1.setFont(f);
        helptxt2.setFont(f);
        helptxt3.setFont(f);
        helptxt4.setFont(f);
        helptxt5.setFont(f);
        helptxt2.setLocation(0,50);
        helptxt3.setLocation(0,100);
        helptxt4.setLocation(0,150);
        helptxt5.setLocation(0,200);
        helptxt1.setText("Welcome to \"Is It Above Or Below!\" the game where counting cards is Encouraged. ");
        helptxt2.setText("The rules are simple, you just guess whether the next card is greater or less than the");
        helptxt3.setText("previous card. Guess right you get 100 points, guess wrong you loss 200 points. Ties");
        helptxt4.setText("are always right. If you run out of points you lose. The game ends when you get through");
        helptxt5.setText("the deck or you lose. Enjoy!");
    }//end lvl (1:2,1.10.1.1.1)
    //added my two classes one for individual cards the ohter for deck(only 3 methods) I did this for your(Cate Sheller) ease as well I cut out the methods that are unused in the card class to keep the size to a minimal and to help you
    public class deck//the resone for deckk was to allow me to shuffle mostly as well to quicly create and populate a deck.
    {//start lvl (2:1,1.1.1.1.1)
        public card [] deck=new card[52];//deck
        public deck()//creates an ordered deck
        {//start lvl (2:2,1.1.1.1.1)
            for(int x=0;x<52;x++)
            {//start lvl (2:3,1.1.1.1.1)
                card c = new card(x+1);
                deck[x]=c; 
            }//end lvl (2:3,1.1.1.1.1)
        }//end lvl (2:2,1.1.1.1.1)
        public deck(String s) //creates a deck and shuffles for ease of programer
        {//start lvl (2:2,1.2.1.1.1)
            for(int x=0;x<52;x++)
            {//start lvl (2:3,1.2.1.1.1)
                card c = new card(x+1);
                deck[x]=c; 
            }//end lvl (2:3,1.2.1.1.1)
            this.shuffle();
        }//end lvl (2:2,1.2.1.1.1)
        public void shuffle()//shuffle or more technically creates a random generated card in each of the blocks of the array however it is looped so it will continue to generate 
        {//start lvl (2:2,1.3.1.1.1)                     //a random card till it asigns one that is not already assigned. the card(0) assigns is a card with no values not even zero except for the master value which is zero
            Random rg =new Random();//had to make the zero card in order to make this method and for it to work. it acts like a null asignment to the card.
            card c1=new card(0),c2=new card(0),c3=new card(0),c4=new card(0),c5=new card(0),c6=new card(0),c7=new card(0),c8=new card(0),c9=new card(0),c10=new card(0),c11=new card(0),c12=new card(0),c13=new card(0),c14=new card(0),c15=new card(0),c16=new card(0),c17=new card(0),c18=new card(0),c19=new card(0),c20=new card(0),c21=new card(0),c22=new card(0),c23=new card(0),c24=new card(0),c25=new card(0),c26=new card(0),c27=new card(0),c28=new card(0),c29=new card(0),c30=new card(0),c31=new card(0),c32=new card(0),c33=new card(0),c34=new card(0),c35=new card(0),c36=new card(0),c37=new card(0),c38=new card(0),c39=new card(0),c40=new card(0),c41=new card(0),c42=new card(0),c43=new card(0),c44=new card(0),c45=new card(0),c46=new card(0),c47=new card(0),c48=new card(0),c49=new card(0),c50=new card(0),c51=new card(0),c52=new card(0);
            card[] cs={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52};
            for(int x=0;x<52;x++)//this is the loop mentioned earlier
            {//start lvl (2:3,1.3.1.1.1)
                int f=rg.nextInt(52)+1;
                card cc=new card(f);
                if(!(cs[0].sameCardAs(cc))&&!(cs[1].sameCardAs(cc))&&!(cs[2].sameCardAs(cc))&&!(cs[3].sameCardAs(cc))&&!(cs[4].sameCardAs(cc))&&!(cs[5].sameCardAs(cc))&&!(cs[6].sameCardAs(cc))&&!(cs[7].sameCardAs(cc))&&!(cs[8].sameCardAs(cc))&&!(cs[9].sameCardAs(cc))&&!(cs[10].sameCardAs(cc))&&!(cs[11].sameCardAs(cc))&&!(cs[12].sameCardAs(cc))&&!(cs[13].sameCardAs(cc))&&!(cs[14].sameCardAs(cc))&&!(cs[15].sameCardAs(cc))&&!(cs[16].sameCardAs(cc))&&!(cs[17].sameCardAs(cc))&&!(cs[18].sameCardAs(cc))&&!(cs[19].sameCardAs(cc))&&!(cs[20].sameCardAs(cc))&&!(cs[21].sameCardAs(cc))&&!(cs[22].sameCardAs(cc))&&!(cs[23].sameCardAs(cc))&&!(cs[24].sameCardAs(cc))&&!(cs[25].sameCardAs(cc))&&!(cs[26].sameCardAs(cc))&&!(cs[27].sameCardAs(cc))&&!(cs[28].sameCardAs(cc))&&!(cs[29].sameCardAs(cc))&&
                !(cs[30].sameCardAs(cc))&&!(cs[31].sameCardAs(cc))&&!(cs[32].sameCardAs(cc))&&!(cs[33].sameCardAs(cc))&&!(cs[34].sameCardAs(cc))&&!(cs[35].sameCardAs(cc))&&!(cs[36].sameCardAs(cc))&&!(cs[37].sameCardAs(cc))&&!(cs[38].sameCardAs(cc))&&!(cs[39].sameCardAs(cc))&&!(cs[40].sameCardAs(cc))&&!(cs[41].sameCardAs(cc))&&!(cs[42].sameCardAs(cc))&&!(cs[43].sameCardAs(cc))&&!(cs[44].sameCardAs(cc))&&!(cs[45].sameCardAs(cc))&&!(cs[46].sameCardAs(cc))&&!(cs[47].sameCardAs(cc))&&!(cs[48].sameCardAs(cc))&&!(cs[49].sameCardAs(cc))&&!(cs[50].sameCardAs(cc))&&!(cs[51].sameCardAs(cc)))
                {//start lvl (2:4,1.3.1.1.1)
                    cs[x]=cc;
                    deck[x]=cc;  
                }//end lvl (2:4,1.3.1.1.1)
                else
                {//start lvl (2:4,1.3.1.2.1)
                    x--;//if card already exists it decress x so when the loop adds to x it will cancel leaving it at the same block of the array. 
                }//end lvl (2:4,1.3.1.2.1)
            }//end lvl (2:3,1.3.1.1.1)
        }//end lvl (2:2,1.3.1.1.1)
    }//end lvl (2:1,1.1.1.1.1)
    public class card// for your(Cate Sheller) ease I put the card class inside the aboveORbelow class aswell remove the methods that were not being used by anything in aboveORbelow
    {//start lvl (3:1,1.1.1.1.1)     the reason I removed them is because I already have my card class on my computer I'm not sure you do and you don't need all the methods of the card class to use this program.
        private Random rg = new Random(); //if you want the other parts all you need to do is grab them from program 3
        private/*static**/ boolean ace_high=false;
        private String sFace;
        private String sSuite;
        private int vFace;//vFace is the point value of a card reason for this and submast is because aces can have a value of 14(high) or 1(low)
        private int submastval;//sub master value is a number that corrosponds to a face 1(ace)-13(king)
        private int vSuite;//the number value that correspond to the suite
        private int mastervalue;//use for me give each card an index value in out of the 52 card deck.1-13spades 14-26clubs etc.
        //method setAce(boolean) unsed=>removed
        private void setSubmastval()//used when face is modified to keep the submastval consistant with the face
        {//start lvl (3:2,1.1.1.1.1)
            if(vFace==14)//this is for when aces are high
            {//start lvl (3:3,1.1.1.1.1)
                submastval=1;  
            }//end lvl (3:3,1.1.1.1.1)
            else//for all cases ecept aces when they are igh
            {//start lvl (3:3,1.1.2.1.1)
                submastval=vFace;
            }//end lvl (3:3,1.1.2.1.1)
        }//end lvl (3:2,1.1.1.1.1)
        private void fromsubmastval()//adjusts vface with submastval
        {//start lvl (3:2,1.2.1.1.1)
            if (ace_high==true)//when aces are high aces have the point value of 14
            {//start lvl (3:3,1.2.1.1.1)
                if(submastval==1) 
                {//start lvl (3:4,1.2.1.1.1)
                    vFace=14;  
                }//end lvl (3:4,1.2.1.1.1)
                else
                {//start lvl (3:4,1.2.1.2.1)
                    vFace=submastval;  
                }//end lvl (3:4,1.2.1.2.1)
            }//end lvl (3:3,1.2.1.1.1)
            else  //when aces are low aces have a point value of 1
            {//start lvl (3:3,1.2.2.1.1)
                vFace=submastval; 
            }//end lvl (3:3,1.2.3.1.1)
        }//end lvl (3:2,1.2.1.1.1)
        //method highOrlow() unused=>removed
        private void setsSuite()//sets the string version of the suite
        {//start lvl (3:2,1.3.1.1.1)
            switch(vSuite)
            {//start lvl (3:3,1.3.1.1.1)
                case 1:    
                sSuite="Spades";
                break;
                case 2:
                sSuite="Clubs";
                break;
                case 3:
                sSuite="Hearts";
                break;
                case 4:
                sSuite="Diamond";
                break;
                default:
                System.out.println("coding error plz fix me");
                break;
            }//end lvl (3:3,1.3.1.1.1)
        }//end lvl (3:2,1.3.1.1.1)
        private void setsFace()//sets the string version of the card face
        {//start lvl (3:2,1.4.1.1.1)
            switch(submastval)
            {//start lvl (3:3,1.4.1.1.1)
                case 1:   
                sFace="Ace";
                break;
                case 2:
                sFace="Two";
                break;
                case 3:
                sFace="Three";
                break;
                case 4:
                sFace="Four";
                break;
                case 5:
                sFace="Five";
                break;
                case 6:
                sFace="Six";
                break;
                case 7:
                sFace="Seven";
                break;
                case 8:
                sFace="Eight";
                break;
                case 9:
                sFace="Nine";
                break;
                case 10:
                sFace="Ten";
                break;
                case 11:
                sFace="Jack";
                break;
                case 12:
                sFace="Queen";
                break;
                case 13:
                sFace="King";
                break;
                default:
                System.out.println("coding error plz fix me");
                break;
            }//end lvl (3:3,1.4.1.1.1)
        }//end lvl (3:2,1.4.1.1.1)
        private void assignMasterValue()//assigns the idex value out of the 52 card possible
        {//start lvl (3:2,1.5.1.1.1)
            mastervalue=submastval+(vSuite-1)*13;//this equation will give a card its index vale base off the system i made: spades= 1(ace)-13(king) clubs 14-26 hearts 27-39 & diamonds 40-52
        }//end lvl (3:2,1.5.1.1.1)
        // method card() unused=>removed
        //method card(int,int) unused=>removed
        public card(int mast)//makes card that corresponds with the index value
        {//start lvl (3:2,1.6.1.1.1)
            this.mastTOcard(mast); 
        }//end lvl (3:2,1.6.1.1.1)
        public void mastTOcard(int mast)//allows the mutation of a card based off the index value
        {//start lvl (3:2,1.7.1.1.1)
            if (mast==0)
            {//start lvl (3:3,1.7.1.1.1)
                mastervalue=0; 
                return;
            }//end lvl (3:3,1.7.1.1.1)
            if ((mast<0||mast>52))//restricted range 1-52
            {//start lvl (3:3,1.7.2.1.1)//start lvl (3,1.11.1.1.1.1)
                System.out.println("mastTOcard(int) failed. Argument out of restricted range.");
                return; 
            }//end lvl (3:3,1.7.2.1.1)
            mastervalue=mast;
            if(mastervalue>39)
            {//start lvl (3:3,1.7.3.1.1)
                submastval=mastervalue-39;
                vSuite=4;
            }//end lvl (3:3,1.7.3.1.1)
            else if(mastervalue>26)
            {//start lvl (3:3,1.7.4.1.1)
                submastval=mastervalue-26;
               vSuite=3;
            }//end lvl (3:3,1.7.4.1.1)
            else if(mastervalue>13)
            {//start lvl (3:3,1.7.5.1.1)
                submastval=mastervalue-13;
                vSuite=2;
            }//end lvl (3:3,1.7.5.1.1)
            else if(mastervalue>0)
            {//start lvl (3:3,1.7.6.1.1)
                submastval=mastervalue;
                vSuite=1;
            }//end lvl (3:3,1.7.6.1.1)
            else
            {//start lvl (3:3,1.7.7.1.1)
                System.out.println("coding error plz fix me");
            }//end lvl (3:3,1.7.7.1.1)
            this.fromsubmastval();
            this.setsFace();
            this.setsSuite();
        }//end lvl (3:2,1.7.1.1.1)
        //method getvFace() unused=>removed
        //method getvSuite() unused=>removed
        //method getFaceValue() unused=>removed
        //method getSuite() unused=>removed
        //method setFace() unused=>removed
        //method setFace(int) unused=>removed
        //method setSuite() unused=>removed
        //method setSuite(int) unused=>removed
        //method setCard() unused=>removed
        //method setCard(int,int) unused=>removed
        public boolean sameCardAs(card c)//compares 2 cards and checks if they are the same card
        {//start lvl (3:2,1.8.1.1.1)
            if (this.mastervalue==c.mastervalue)
            {//start lvl (3:3,1.8.1.1.1)
                return true;  
            }//end lvl (3:3,1.8.1.1.1)
            else
            {//start lvl (3:3,1.8.2.1.1)
                return false;
            }//end lvl (3:3,1.8.2.1.1)
        }//end lvl (3:2,1.8.1.1.1)
        public int compareFace(card c)//compares two cards and checks wether one has a point/face value less than, greater than, or same as another card
        {//start lvl (3:2,1.9.1.1.1)
            if (this.vFace>c.vFace)
            {//start lvl (3:3,1.9.1.1.1)
                return 1; 
            }//end lvl (3:3,1.9.1.1.1)
            else if (this.vFace==c.vFace)
            {//start lvl (3:3,1.9.2.1.1)
                return 0; 
            }//end lvl (3:3,1.9.2.1.1)
            else
            {//start lvl (3:3,1.9.3.1.1)
                return -1;
            }//end lvl (3:3,1.9.3.1.1)
        }//end lvl (3:2,1.9.1.1.1)
        public String toString()//strings the card's name
        {//start lvl (3:2,1.10.1.1.1)
            return sFace+" of "+sSuite;
        }//end lvl (3:2,1.10.1.1.1)
        //method master_print() unused=>removed
        public int getmast()
        {//start lvl (3:2,1.11.1.1.1)
            return mastervalue;
        }//end lvl (3:2,1.11.1.1.1)
    }//end lvl (3:1,1.1.1.1.1)
}//end lvl (1:1,1.1.1.1.1)
