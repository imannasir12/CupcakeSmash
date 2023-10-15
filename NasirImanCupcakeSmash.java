//Name: Iman Nasir
//Date: November 19th, 2021
//Purpose: Grid Game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.text.*;
import java.applet.*;

public class NasirImanCupcakeSmash extends Applet implements ActionListener
{
    //sound
    AudioClip soundFile;

    //holds all screens
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7, card8;
    CardLayout cdLayout = new CardLayout ();

    //timer variables are set up
    Date now, end;
    int sec1 = 0;
    int min1 = 0;
    int elapsed_sec = 0;
    int sec2 = 0;
    int min2 = 0;

    //tracks level the user is playing
    int level = 0;

    //grid rows and columns are set up
    int row = 9;
    int col = 9;
    int row1 = 7;
    int col1 = 7;

    //tracks number of clicks
    int last = -1;

    //tracks number of moves player has made
    JLabel moves;
    JLabel moves1;
    JLabel moves2;
    JLabel moves3;

    //tracks number of points player has made on all levels
    JLabel points;
    JLabel points1;
    JLabel points2;
    JLabel points3;

    //traks number of moves player has made
    int move = 0;

    //tracks the number of points player has
    int score = 0;

    //variable to check if board is okay for user to play
    int check = 0;

    //variable for user to decide how many points they need to win
    int winPoints = 0;

    //variable for user to decide how much time they need to win
    int time = 0;

    //grid arrays for levels 1-4
    JButton a[] = new JButton [row * col];
    JButton b[] = new JButton [row * col];
    JButton c[] = new JButton [row * col];
    JButton d[] = new JButton [row1 * col1];

    //colour, type, and piece arrays are declared for 9 by 9 grid
    char colour[] [] = {{'o', 'o', 'p', 'o', 'v', 'o', 'y', 'c', 'v'},
	    {'c', 'y', 'c', 'y', 'y', 'p', 'v', 'p', 'v'},
	    {'v', 'v', 'p', 'v', 'v', 'c', 'o', 'g', 'o'},
	    {'v', 'o', 'y', 'c', 'o', 'o', 'v', 'g', 'v'},
	    {'g', 'v', 'y', 'o', 'v', 'p', 'g', 'c', 'g'},
	    {'y', 'c', 'g', 'y', 'c', 'g', 'o', 'y', 'y'},
	    {'p', 'o', 'v', 'p', 'v', 'o', 'v', 'g', 'p'},
	    {'o', 'g', 'o', 'g', 'p', 'y', 'c', 'p', 'c'},
	    {'v', 'o', 'v', 'c', 'g', 'g', 'o', 'p', 'v'}};
    char type[] [] = {{'p', 'h', 'p', 'c', 'p', 'p', 'h', 'c', 'p'},
	    {'p', 'p', 'p', 'p', 'h', 'h', 'p', 'p', 'h'},
	    {'c', 'p', 'h', 'h', 'h', 'p', 'p', 'h', 'h'},
	    {'p', 'h', 'p', 'h', 'c', 'h', 'h', 'c', 'p'},
	    {'h', 'h', 'c', 'h', 'h', 'h', 'h', 'h', 'p'},
	    {'p', 'h', 'h', 'p', 'c', 'h', 'c', 'p', 'p'},
	    {'c', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'c'},
	    {'h', 'c', 'c', 'c', 'c', 'p', 'h', 'h', 'h'},
	    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'}};
    char piece[] [] = {{'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'}};

    //identical arrays to reset board for 9 by 9 grid
    char colour1[] [] = {{'o', 'o', 'p', 'o', 'v', 'o', 'y', 'c', 'v'},
	    {'c', 'y', 'c', 'y', 'y', 'p', 'v', 'p', 'v'},
	    {'v', 'v', 'p', 'v', 'v', 'c', 'o', 'g', 'o'},
	    {'v', 'o', 'y', 'c', 'o', 'o', 'v', 'g', 'v'},
	    {'g', 'v', 'y', 'o', 'v', 'p', 'g', 'c', 'g'},
	    {'y', 'c', 'g', 'y', 'c', 'g', 'o', 'y', 'y'},
	    {'p', 'o', 'v', 'p', 'v', 'o', 'v', 'g', 'p'},
	    {'o', 'g', 'o', 'g', 'p', 'y', 'c', 'p', 'c'},
	    {'v', 'o', 'v', 'c', 'g', 'g', 'o', 'p', 'v'}};
    char type1[] [] = {{'p', 'h', 'p', 'c', 'p', 'p', 'h', 'c', 'p'},
	    {'p', 'p', 'p', 'p', 'h', 'h', 'p', 'p', 'h'},
	    {'c', 'p', 'h', 'h', 'h', 'p', 'p', 'h', 'h'},
	    {'p', 'h', 'p', 'h', 'c', 'h', 'h', 'c', 'p'},
	    {'h', 'h', 'c', 'h', 'h', 'h', 'h', 'h', 'p'},
	    {'p', 'h', 'h', 'p', 'c', 'h', 'c', 'p', 'p'},
	    {'c', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'c'},
	    {'h', 'c', 'c', 'c', 'c', 'p', 'h', 'h', 'h'},
	    {'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h'}};
    char piece1[] [] = {{'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},
	    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'}};

    //colour, and type arrays are declared for 7 by 7 grid
    char colourD[] [] = {{'v', 'o', 'y', 'o', 'p', 'p', 'c'},
	    {'g', 'c', 'p', 'p', 'c', 'o', 'p'},
	    {'o', 'g', 'c', 'g', 'v', 'o', 'o'},
	    {'o', 'v', 'c', 'o', 'p', 'g', 'y'},
	    {'c', 'c', 'v', 'p', 'o', 'p', 'v'},
	    {'v', 'y', 'y', 'g', 'g', 'p', 'v'},
	    {'v', 'g', 'c', 'c', 'p', 'o', 'o'}};
    char typeD[] [] = {{'c', 'c', 'p', 'h', 'c', 'p', 'p'},
	    {'p', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'h', 'c', 'c', 'p', 'h', 'p', 'h'},
	    {'c', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'h', 'h', 'h', 'c', 'p', 'p', 'h'},
	    {'c', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'c', 'c', 'h', 'h', 'h', 'h', 'h'}};

    //identical arrays for 7 by 7 grid
    char colourD1[] [] = {{'v', 'o', 'y', 'o', 'p', 'p', 'c'},
	    {'g', 'c', 'p', 'p', 'c', 'o', 'p'},
	    {'o', 'g', 'c', 'g', 'v', 'o', 'o'},
	    {'o', 'v', 'c', 'o', 'p', 'g', 'y'},
	    {'c', 'c', 'v', 'p', 'o', 'p', 'v'},
	    {'v', 'y', 'y', 'g', 'g', 'p', 'v'},
	    {'v', 'g', 'c', 'c', 'p', 'o', 'o'}};
    char typeD1[] [] = {{'c', 'c', 'p', 'h', 'c', 'p', 'p'},
	    {'p', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'h', 'c', 'c', 'p', 'h', 'p', 'h'},
	    {'c', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'h', 'h', 'h', 'c', 'p', 'p', 'h'},
	    {'c', 'h', 'p', 'c', 'c', 'p', 'c'},
	    {'c', 'c', 'h', 'h', 'h', 'h', 'h'}};

    //holds all screens
    public void init ()
    {
	//plays sound file on loop
	soundFile = getAudioClip (getDocumentBase (),
		"cupcake.snd");
	soundFile.loop ();
	//resize screen to 760,700
	resize (760, 700);
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//all screens are added
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	screen6 ();
	screen7 ();
	screen8 ();
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    //opening screen
    public void screen1 ()
    {
	card1 = new Panel ();
	//opening screen picture is added
	JButton next = new JButton (createImageIcon ("opening.png"));
	next.setBorderPainted (false);
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (next);
	p_card.add ("1", card1);
    }


    //instructions screen 1
    public void screen2 ()
    {
	card2 = new Panel ();
	//instructions screen picture is added
	JButton next = new JButton (createImageIcon ("instruct.png"));
	next.setBorderPainted (false);
	next.setActionCommand ("s7");
	next.addActionListener (this);
	card2.add (next);
	p_card.add ("2", card2);
    }


    //level 1-point smash screen is set up
    public void screen3 ()
    {
	card3 = new Panel ();
	card3.setBackground (new Color (252, 220, 237));
	Panel p = new Panel ();
	moves = new JLabel ("Moves: 0   ");
	moves.setFont (new Font ("Ink Free", Font.BOLD, 18));
	moves.setForeground (new Color (255, 255, 255));
	p.add (moves);
	JLabel title = new JLabel ("     Point Smash    ");
	title.setFont (new Font ("Ink Free", Font.BOLD, 37));
	title.setForeground (new Color (255, 255, 255));
	p.add (title);
	points = new JLabel ("Score: 0     ");
	points.setFont (new Font ("Ink Free", Font.BOLD, 18));
	points.setForeground (new Color (255, 255, 255));
	p.add (points);
	//panel for buttons is added
	Panel g = new Panel (new GridLayout (1, 4));
	JButton reset = new JButton ("Reset");
	reset.setBackground (new Color (245, 153, 202));
	reset.setForeground (new Color (255, 255, 255));
	reset.setFont (new Font ("Ink Free", Font.BOLD, 15));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	g.add (reset);
	JButton instructions = new JButton ("Instructions");
	instructions.setBackground (new Color (245, 153, 202));
	instructions.setForeground (new Color (255, 255, 255));
	instructions.setFont (new Font ("Ink Free", Font.BOLD, 15));
	instructions.setActionCommand ("instructions");
	instructions.addActionListener (this);
	g.add (instructions);
	JButton hint = new JButton ("Hint");
	hint.setBackground (new Color (245, 153, 202));
	hint.setForeground (new Color (255, 255, 255));
	hint.setFont (new Font ("Ink Free", Font.BOLD, 15));
	hint.setActionCommand ("hint1");
	hint.addActionListener (this);
	g.add (hint);
	JButton quit = new JButton ("Quit");
	quit.setBackground (new Color (245, 153, 202));
	quit.setForeground (new Color (255, 255, 255));
	quit.setFont (new Font ("Ink Free", Font.BOLD, 15));
	quit.setActionCommand ("quit");
	quit.addActionListener (this);
	g.add (quit);
	//Grid board is set up
	Panel grid = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move] = new JButton (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		a [move].setPreferredSize (new Dimension (65, 65));
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		grid.add (a [move]);
		move++;
	    }
	}
	card3.add (p);
	card3.add (grid);
	card3.add (g);
	p_card.add ("3", card3);
    }


    //level 2- time smash screen is set up
    public void screen4 ()
    {
	card4 = new Panel ();
	card4.setBackground (new Color (252, 220, 237));
	Panel p = new Panel ();
	moves1 = new JLabel ("Moves: 0   ");
	moves1.setFont (new Font ("Ink Free", Font.BOLD, 18));
	moves1.setForeground (new Color (255, 255, 255));
	p.add (moves1);
	JLabel title = new JLabel ("     Time Smash    ");
	title.setFont (new Font ("Ink Free", Font.BOLD, 37));
	title.setForeground (new Color (255, 255, 255));
	p.add (title);
	points1 = new JLabel ("Score: 0     ");
	points1.setFont (new Font ("Ink Free", Font.BOLD, 18));
	points1.setForeground (new Color (255, 255, 255));
	p.add (points1);
	//panel to hold buttons
	Panel g = new Panel (new GridLayout (1, 4));
	JButton reset = new JButton ("Reset");
	reset.setBackground (new Color (245, 153, 202));
	reset.setForeground (new Color (255, 255, 255));
	reset.setFont (new Font ("Ink Free", Font.BOLD, 15));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	g.add (reset);
	JButton instructions = new JButton ("Instructions");
	instructions.setBackground (new Color (245, 153, 202));
	instructions.setForeground (new Color (255, 255, 255));
	instructions.setFont (new Font ("Ink Free", Font.BOLD, 15));
	instructions.setActionCommand ("instructions");
	instructions.addActionListener (this);
	g.add (instructions);
	JButton hint = new JButton ("Hint");
	hint.setBackground (new Color (245, 153, 202));
	hint.setForeground (new Color (255, 255, 255));
	hint.setFont (new Font ("Ink Free", Font.BOLD, 15));
	hint.setActionCommand ("hint2");
	hint.addActionListener (this);
	g.add (hint);
	JButton quit = new JButton ("Quit");
	quit.setBackground (new Color (245, 153, 202));
	quit.setForeground (new Color (255, 255, 255));
	quit.setFont (new Font ("Ink Free", Font.BOLD, 15));
	quit.setActionCommand ("quit");
	quit.addActionListener (this);
	g.add (quit);
	//Grid board is set up
	Panel grid = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		b [move] = new JButton (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		b [move].setPreferredSize (new Dimension (65, 65));
		b [move].addActionListener (this);
		b [move].setActionCommand ("" + move);
		grid.add (b [move]);
		move++;
	    }
	}
	card4.add (p);
	card4.add (grid);
	card4.add (g);
	p_card.add ("4", card4);
    }


    //level 3-burn smash screen is set up
    public void screen5 ()
    {
	card5 = new Panel ();
	card5.setBackground (new Color (252, 220, 237));
	Panel p = new Panel ();
	moves2 = new JLabel ("Moves: 0   ");
	moves2.setFont (new Font ("Ink Free", Font.BOLD, 18));
	moves2.setForeground (new Color (255, 255, 255));
	p.add (moves2);
	JLabel title = new JLabel ("     Burn Smash    ");
	title.setFont (new Font ("Ink Free", Font.BOLD, 37));
	title.setForeground (new Color (255, 255, 255));
	p.add (title);
	points2 = new JLabel ("Score: 0     ");
	points2.setFont (new Font ("Ink Free", Font.BOLD, 18));
	points2.setForeground (new Color (255, 255, 255));
	p.add (points2);
	//panel to hold all buttons
	Panel g = new Panel (new GridLayout (1, 4));
	JButton reset = new JButton ("Reset");
	reset.setBackground (new Color (245, 153, 202));
	reset.setForeground (new Color (255, 255, 255));
	reset.setFont (new Font ("Ink Free", Font.BOLD, 15));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	g.add (reset);
	JButton instructions = new JButton ("Instructions");
	instructions.setBackground (new Color (245, 153, 202));
	instructions.setForeground (new Color (255, 255, 255));
	instructions.setFont (new Font ("Ink Free", Font.BOLD, 15));
	instructions.setActionCommand ("instructions");
	instructions.addActionListener (this);
	g.add (instructions);
	JButton hint = new JButton ("Hint");
	hint.setBackground (new Color (245, 153, 202));
	hint.setForeground (new Color (255, 255, 255));
	hint.setFont (new Font ("Ink Free", Font.BOLD, 15));
	hint.setActionCommand ("hint3");
	hint.addActionListener (this);
	g.add (hint);
	JButton quit = new JButton ("Quit");
	quit.setBackground (new Color (245, 153, 202));
	quit.setForeground (new Color (255, 255, 255));
	quit.setFont (new Font ("Ink Free", Font.BOLD, 15));
	quit.setActionCommand ("quit");
	quit.addActionListener (this);
	g.add (quit);
	//Grid board is set up
	Panel grid = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		c [move] = new JButton (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		c [move].setPreferredSize (new Dimension (65, 65));
		c [move].addActionListener (this);
		c [move].setActionCommand ("" + move);
		grid.add (c [move]);
		move++;
	    }
	}
	card5.add (p);
	card5.add (grid);
	card5.add (g);
	p_card.add ("5", card5);
    }


    //level 4-diagonal smash is set up
    public void screen6 ()
    {
	card6 = new Panel ();
	card6.setBackground (new Color (252, 220, 237));
	Panel p = new Panel ();
	moves3 = new JLabel ("Moves: 0   ");
	moves3.setFont (new Font ("Ink Free", Font.BOLD, 18));
	moves3.setForeground (new Color (255, 255, 255));
	p.add (moves3);
	JLabel title = new JLabel ("     Diagonal Smash    ");
	title.setFont (new Font ("Ink Free", Font.BOLD, 37));
	title.setForeground (new Color (255, 255, 255));
	p.add (title);
	points3 = new JLabel ("Score: 0     ");
	points3.setFont (new Font ("Ink Free", Font.BOLD, 18));
	points3.setForeground (new Color (255, 255, 255));
	p.add (points3);
	//panel to hold buttons
	Panel g = new Panel (new GridLayout (1, 4));
	JButton reset = new JButton ("Reset");
	reset.setBackground (new Color (245, 153, 202));
	reset.setForeground (new Color (255, 255, 255));
	reset.setFont (new Font ("Ink Free", Font.BOLD, 15));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	g.add (reset);
	JButton random = new JButton ("Randomize");
	random.setBackground (new Color (245, 153, 202));
	random.setForeground (new Color (255, 255, 255));
	random.setFont (new Font ("Ink Free", Font.BOLD, 15));
	random.setActionCommand ("random");
	random.addActionListener (this);
	g.add (random);
	JButton instructions = new JButton ("Instructions");
	instructions.setBackground (new Color (245, 153, 202));
	instructions.setForeground (new Color (255, 255, 255));
	instructions.setFont (new Font ("Ink Free", Font.BOLD, 15));
	instructions.setActionCommand ("instructions");
	instructions.addActionListener (this);
	g.add (instructions);
	JButton hint = new JButton ("Hint");
	hint.setBackground (new Color (245, 153, 202));
	hint.setForeground (new Color (255, 255, 255));
	hint.setFont (new Font ("Ink Free", Font.BOLD, 15));
	hint.setActionCommand ("hint4");
	hint.addActionListener (this);
	g.add (hint);
	//Grid board is set up
	Panel grid = new Panel (new GridLayout (row1, col1));
	int move = 0;
	for (int i = 0 ; i < row1 ; i++)
	{
	    for (int j = 0 ; j < col1 ; j++)
	    {
		d [move] = new JButton (createImageIcon (colourD [i] [j] + "" + typeD [i] [j] + "r.png"));
		d [move].setPreferredSize (new Dimension (70, 70));
		d [move].addActionListener (this);
		d [move].setActionCommand ("" + move);
		grid.add (d [move]);
		move++;
	    }
	}
	card6.add (p);
	card6.add (grid);
	card6.add (g);
	p_card.add ("6", card6);
    }


    //instructions screen 2
    public void screen7 ()
    {
	card7 = new Panel ();
	//second instructions picture is added
	JButton next = new JButton (createImageIcon ("instruct1.png"));
	next.setBorderPainted (false);
	next.setActionCommand ("s8");
	next.addActionListener (this);
	card7.add (next);
	p_card.add ("7", card7);
    }


    //instructions screen 3
    public void screen8 ()
    {
	card8 = new Panel ();
	//third instructions picture is added
	JButton next = new JButton (createImageIcon ("instruct2.png"));
	next.setBorderPainted (false);
	next.setActionCommand ("chooseLevel");
	next.addActionListener (this);
	card8.add (next);
	p_card.add ("8", card8);
    }


    //makes images on screen
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = NasirImanCupcakeSmash.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    //Timer is started
    public void startTime ()
    {
	now = new Date ();
	sec1 = now.getSeconds ();
	min1 = now.getMinutes ();
    }


    //Timer is reset
    public void resetTime ()
    {
	startTime ();
	showStatus ("Seconds left: " + time);
    }


    //checks if time is up for time smash
    public boolean time (int min1, int sec1)
    {
	//timer ends
	end = new Date ();
	sec2 = end.getSeconds ();
	min2 = end.getMinutes ();
	//time elapsed
	elapsed_sec = (min2 * 60 + sec2) - (min1 * 60 + sec1);
	showStatus ("Seconds left: " + (time - elapsed_sec));
	//if more than chosen time has passed
	if (elapsed_sec > time)
	    return true;
	//if less than chosen time has passed
	else
	    return false;
    }


    //check if time is up for diagonal smash
    public boolean time1 (int min1, int sec1)
    {
	//timer ends
	end = new Date ();
	sec2 = end.getSeconds ();
	min2 = end.getMinutes ();
	//time elapsed
	elapsed_sec = (min2 * 60 + sec2) - (min1 * 60 + sec1);
	showStatus ("Seconds left: " + (60 - elapsed_sec));
	//if more than 60 seconds have passed
	if (elapsed_sec > 60)
	    return true;
	//if less than a minute has passed
	else
	    return false;
    }


    //if user clicks on a grid button on all four game screens
    public void gridClick (int pos)
    {
	switch (level)
	{
	    case 1:
		level1 (pos);
		break;
	    case 2:
		level2 (pos);
		break;
	    case 3:
		level3 (pos);
		break;
	    case 4:
		level4 (pos);
		break;
	}
    }


    //check if there is a line of 3 formed after swap has occured. If there has, those pieces are also randomized.
    public int checkBoard ()
    {
	check = 0;
	for (int i = 0 ; i < 9 ; i++)
	{
	    for (int j = 0 ; j <= 6 ; j++)
	    {
		//checks for horizontal line
		if (colour [i] [j] == colour [i] [j + 1] && colour [i] [j] == colour [i] [j + 2])
		{
		    check = 1;
		    colour [i] [j] = randomizeColour ();
		    colour [i] [j + 1] = randomizeColour ();
		    colour [i] [j + 2] = randomizeColour ();
		    type [i] [j] = randomizeType ();
		    type [i] [j + 1] = randomizeType ();
		    type [i] [j + 2] = randomizeType ();
		}
	    }
	}
	for (int k = 0 ; k <= 6 ; k++)
	{
	    for (int l = 0 ; l < 9 ; l++)
	    {
		//checks for vertical line
		if (colour [k] [l] == colour [k + 1] [l] && colour [k] [l] == colour [k + 2] [l])
		{
		    check = 1;
		    colour [k] [l] = randomizeColour ();
		    colour [k + 1] [l] = randomizeColour ();
		    colour [k + 2] [l] = randomizeColour ();
		    type [k] [l] = randomizeType ();
		    type [k + 1] [l] = randomizeType ();
		    type [k + 2] [l] = randomizeType ();
		}
	    }
	}
	//if any lines have been formed, returns a 1
	return check;
    }


    //Redraw for all different levels
    public void redraw ()
    {
	//while there is still a horizontal or vertical line on the board, calls the checkboard method.
	while (checkBoard () == 1)
	    checkBoard ();
	if (level == 1)
	    redraw1 ();
	else if (level == 2)
	    redraw2 ();
	else if (level == 3)
	    redraw3 ();
	else if (level == 4)
	    redraw4 ();
    }


    //redraws the board for level 1
    public void redraw1 ()
    {
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [m].setIcon (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		m++;
	    }
	}
	//updates moves and points
	moves.setText ("Moves: " + move);
	points.setText ("Score: " + score);
    }


    //redraws the board for level 2
    public void redraw2 ()
    {
	int n = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		b [n].setIcon (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		n++;
	    }
	}
	//updates moves and points
	moves1.setText ("Moves: " + move);
	points1.setText ("Score: " + score);
    }


    //redraws board fo level 3
    public void redraw3 ()
    {
	int l = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		c [l].setIcon (createImageIcon (colour [i] [j] + "" + type [i] [j] + "" + piece [i] [j] + ".png"));
		l++;
	    }
	}
	//updates moves and points
	moves2.setText ("Moves: " + move);
	points2.setText ("Score: " + score);
    }


    //redraws the board for level 1
    public void redraw4 ()
    {
	int o = 0;
	for (int i = 0 ; i < row1 ; i++)
	{
	    for (int j = 0 ; j < col1 ; j++)
	    {
		d [o].setIcon (createImageIcon (colourD [i] [j] + "" + typeD [i] [j] + "" + "r.png"));
		o++;
	    }
	}
	//updates moves and points
	moves3.setText ("Moves: " + move);
	points3.setText ("Score: " + score);
    }


    //when user is playing level 1-point smash
    public void level1 (int pos)
    {
	//if user has not won yet, keep playing
	if (!win ())
	{
	    if (last == -1)
		last = pos;
	    else
	    {
		//if the move is valid, swap the two pieces
		if (checkValidMove (pos, last))
		    redraw ();
		//if the move is not valid, ask the user to pick a different move
		else
		    invalid ();
		last = -1;
	    }
	}
	//if user has won level 1, they play again
	else
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("vcr.png"), "Winner! Play again now!", JOptionPane.INFORMATION_MESSAGE);
	    reset ();
	}
    }


    //when user is playing level 2-time smash
    public void level2 (int pos)
    {
	//if time is up and the user does not have 50 points they lose.
	if (time (min1, sec1) && score < 50)
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("ypr.png"), "Time is up! Play again now!", JOptionPane.INFORMATION_MESSAGE);
	    chooseTime ();
	    reset ();
	}
	//if user has not won yet and time is not up, they keep playing
	else if (!win () && !time (min1, sec1))
	{
	    if (last == -1)
		last = pos;
	    else
	    {
		//if the move is valid, swap the two pieces
		if (checkValidMove (pos, last))
		    redraw ();
		//if the move is not valid, ask the user to pick a different move
		else
		    invalid ();
		last = -1;
	    }
	}
	//if user has won level 2, they play again
	else if (win ())
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("phr.png"), "Winner! Play again now!", JOptionPane.INFORMATION_MESSAGE);
	    chooseTime ();
	    reset ();
	}
    }


    //if user is playing level 3-burn smash
    public void level3 (int pos)
    {
	//if there is a cupcake in the bottom row, the user has lost
	if (checkCupcake ())
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("--c.png"), "You lose! Play Again!", JOptionPane.INFORMATION_MESSAGE);
	    reset ();
	}
	//if user has not won yet and the burned cupake has not reached the last row yet
	else if (!win ())
	{
	    if (last == -1)
		last = pos;
	    else
	    {
		//if the move is valid, swap the pieces
		if (checkValidMove (pos, last))
		    redraw ();
		//if the move is not valid, asks the user to pick a different move
		else
		    invalid ();
		last = -1;
	    }
	}
	//if user has won level 3, they play again
	else if (win ())
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("extinguisher.png"), "Winner! You set the fire out! Play again!", JOptionPane.INFORMATION_MESSAGE);
	    reset ();
	}
    }


    //when user is playing level 4
    public void level4 (int pos)
    {
	//if time is up and the user does not have the points they selected, they lose
	if (time1 (min1, sec1) && score < winPoints)
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("ypr.png"), "Time is up! Play again now!", JOptionPane.INFORMATION_MESSAGE);
	    reset ();
	}
	//if user has not won yet and time is not up
	else if (!win () && !time1 (min1, sec1))
	{
	    if (last == -1)
		last = pos;
	    else
	    {
		//if the move is valid, swap the two pieces
		if (checkValidMoveDiagonal (pos, last))
		    redraw ();
		//if the move is not valid, ask the user to pick a different move
		else
		    invalid ();
		last = -1;
	    }
	}
	//if user has won level 4, they play again
	else if (win ())
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("phr.png"), "Winner! Play again now!", JOptionPane.INFORMATION_MESSAGE);
	    reset ();
	}
    }


    public boolean checkValidMove (int pos, int last)
    {
	//finds x and y value of current piece that has been clicked
	int cX = pos / col;
	int cY = pos % col;
	//finds x and y value of previous piece that was clicked
	int lX = last / col;
	int lY = last % col;
	//checks if a vertical line is formed
	if (piece [cX] [cY] == 'c' || piece [lX] [lY] == 'c')
	    return false;
	else if (cY == lY && (cX + 1 == lX || cX - 1 == lX) && (checkVerticalLine (cX, cY, lX, lY)))
	{
	    move++;
	    return true;
	}
	//checks if a vertical line is formed
	else if (cX == lX && (cY + 1 == lY || cY - 1 == lY) && (checkVerticalLine (cX, cY, lX, lY)))
	{
	    move++;
	    return true;
	}
	//checks if a horizontal line is formed
	else if (cY == lY && (cX + 1 == lX || cX - 1 == lX) && (checkHorizontalLine (cX, cY, lX, lY)))
	{
	    move++;
	    return true;
	}
	//checks if a horizonta line is formed
	else if (cX == lX && (cY + 1 == lY || cY - 1 == lY) && (checkHorizontalLine (cX, cY, lX, lY)))
	{
	    move++;
	    return true;
	}
	else
	    return false;
    }


    public boolean checkValidMoveDiagonal (int pos, int last)
    {
	//finds x and y value of current piece that has been clicked
	int cX = pos / col1;
	int cY = pos % col1;
	//finds x and y value of previous piece that was clicked
	int lX = last / col1;
	int lY = last % col1;
	//up and down swaps that form diagonal line
	if (cY == lY && (cX + 1 == lX || cX - 1 == lX) && (checkDiagonalLine (cX, cY, lX, lY)))
	{
	    swap (cX, cY, lX, lY, -1, -1);
	    move++;
	    return true;
	}
	//left and right swaps that form diagonal line
	else if (cX == lX && (cY + 1 == lY || cY - 1 == lY) && (checkDiagonalLine (cX, cY, lX, lY)))
	{
	    swap (cX, cY, lX, lY, -1, -1);
	    move++;
	    return true;
	}
	else
	    return false;
    }


    //checks if a diagonal line can be formed
    public boolean checkDiagonalLine (int cX, int cY, int lX, int lY)
    {
	char cXY = colourD [cX] [cY];
	char lXY = colourD [lX] [lY];
	//checks if a diagonal line can be formed from the top piece
	if (isValidTopDiagonal (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//checks if a diagonal line can be formed from the middle piece
	else if (isValidMiddleDiagonal (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//checks if a diagonal line can be formed from the bottom piece
	else if (isValidBottomDiagonal (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else
	    return false;
    }


    //diagonal line is formed at the top by swapping downward
    public boolean topDown (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY + 2 <= 6) && (cX + 3 <= 6) && cX < lX && (cXY == colourD [cX + 2] [cY + 1] && cXY == colourD [cX + 3] [cY + 2]))
	{
	    pointCalculator (cX, cY, cX + 2, cY + 1, cX + 3, cY + 2);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX + 3 <= 6) && lX < cX && (lXY == colourD [lX + 2] [lY + 1] && lXY == colourD [lX + 3] [lY + 2]))
	{
	    pointCalculator (lX, lY, lX + 2, lY + 1, lX + 3, lY + 2);
	    return true;
	}
	else if ((cY - 2 >= 0) && (cX + 3 <= 6) && cX < lX && (cXY == colourD [cX + 2] [cY - 1] && cXY == colourD [cX + 3] [cY - 2]))
	{
	    pointCalculator (cX, cY, cX + 2, cY - 1, cX + 3, cY - 2);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX + 3 <= 6) && lX < cX && (lXY == colourD [lX + 2] [lY - 1] && lXY == colourD [lX + 3] [lY - 2]))
	{
	    pointCalculator (lX, lY, lX + 2, lY - 1, lX + 3, lY - 2);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the top by swapping right
    public boolean topRight (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY + 3 <= 6) && (cX + 2 <= 6) && cY < lY && (cXY == colourD [cX + 1] [cY + 2] && cXY == colourD [cX + 2] [cY + 3]))
	{
	    pointCalculator (cX, cY, cX + 1, cY + 2, cX + 2, cY + 3);
	    return true;
	}
	else if ((lY + 3 <= 6) && (lX + 2 <= 6) && lY < cY && (lXY == colourD [lX + 1] [lY + 2] && lXY == colourD [lX + 2] [lY + 3]))
	{
	    pointCalculator (lX, lY, lX + 1, lY + 2, lX + 2, lY + 3);
	    return true;
	}
	else if ((cY - 1 >= 0) && (cX + 2 <= 6) && cY < lY && (cXY == colourD [cX + 1] [cY] && cXY == colourD [cX + 2] [cY - 1]))
	{
	    pointCalculator (cX, cY, cX + 1, cY, cX + 2, cY - 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lX + 2 <= 6) && lY < cY && (lXY == colourD [lX + 1] [lY] && lXY == colourD [lX + 2] [lY - 1]))
	{
	    pointCalculator (lX, lY, lX + 1, lY, lX + 2, lY - 1);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the top by swapping left
    public boolean topLeft (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY + 1 <= 6) && (cX + 2 <= 6) && cY > lY && (cXY == colourD [cX + 1] [cY] && cXY == colourD [cX + 2] [cY + 1]))
	{
	    pointCalculator (cX, cY, cX + 1, cY, cX + 2, cY + 1);
	    return true;
	}
	else if ((lY + 1 <= 6) && (lX + 2 <= 6) && lY > cY && (lXY == colourD [lX + 1] [lY] && lXY == colourD [lX + 2] [lY + 1]))
	{
	    pointCalculator (lX, lY, lX + 1, lY, lX + 2, lY + 1);
	    return true;
	}
	else if ((cY - 3 >= 0) && (cX + 2 <= 6) && cY > lY && (cXY == colourD [cX + 1] [cY - 2] && cXY == colourD [cX + 2] [cY - 3]))
	{
	    pointCalculator (cX, cY, cX + 1, cY - 2, cX + 2, cY - 3);
	    return true;
	}
	else if ((lY - 3 >= 0) && (lX + 2 <= 6) && lY > cY && (lXY == colourD [lX + 1] [lY - 2] && lXY == colourD [lX + 2] [lY - 3]))
	{
	    pointCalculator (lX, lY, lX + 1, lY - 2, lX + 2, lY - 3);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the top by swapping upward
    public boolean topUp (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY + 2 <= 6) && (cX + 1 <= 6) && cX > lX && (cXY == colourD [cX] [cY + 1] && cXY == colourD [cX + 1] [cY + 2]))
	{
	    pointCalculator (cX, cY, cX, cY + 1, cX + 1, cY + 2);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX + 1 <= 6) && lX > cX && (lXY == colourD [lX] [lY + 1] && lXY == colourD [lX + 1] [lY + 2]))
	{
	    pointCalculator (lX, lY, lX, lY + 1, lX + 1, lY + 2);
	    return true;
	}
	else if ((cY - 2 >= 0) && (cX + 1 <= 6) && cX > lX && (cXY == colourD [cX] [cY - 1] && cXY == colourD [cX + 1] [cY - 2]))
	{
	    pointCalculator (cX, cY, cX, cY - 1, cX + 1, cY - 2);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX + 1 <= 6) && lX > cX && (lXY == colourD [lX] [lY - 1] && lXY == colourD [lX + 1] [lY - 2]))
	{
	    pointCalculator (lX, lY, lX, lY - 1, lX + 1, lY - 2);
	    return true;
	}
	else
	    return false;
    }


    //holds all possibilities for how you can form a diagonal line using the top piece
    public boolean isValidTopDiagonal (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if (topUp (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (topDown (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (topRight (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (topLeft (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else
	    return false;
    }


    //diagonal line is formed at the middle by swapping upward
    public boolean middleUp (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 1 >= 0) && (cY + 1 <= 6) && (cX - 2 >= 0) && cX > lX && (cXY == colourD [cX] [cY + 1] && cXY == colourD [cX - 2] [cY - 1]))
	{
	    pointCalculator (cX, cY, cX, cY + 1, cX - 2, cY - 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lY + 1 <= 6) && (lX - 2 >= 0) && lX > cX && (lXY == colourD [lX] [lY + 1] && lXY == colourD [lX - 2] [lY - 1]))
	{
	    pointCalculator (lX, lY, lX, lY + 1, lX - 2, lY - 1);
	    return true;
	}
	else if ((cY - 1 >= 0) && (cY + 1 <= 6) && (cX - 2 >= 0) && cX > lX && (cXY == colourD [cX] [cY - 1] && cXY == colourD [cX - 2] [cY + 1]))
	{
	    pointCalculator (cX, cY, cX, cY - 1, cX - 2, cY + 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lY + 1 <= 6) && (lX - 2 >= 0) && lX > cX && (lXY == colourD [lX] [lY - 1] && lXY == colourD [lX - 2] [lY + 1]))
	{
	    pointCalculator (lX, lY, lX, lY - 1, lX - 2, lY + 1);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the middle by swapping right
    public boolean middleRight (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY + 2 <= 6) && (cX + 1 <= 6) && cY < lY && (cXY == colourD [cX - 1] [cY] && cXY == colourD [cX + 1] [cY + 2]))
	{
	    pointCalculator (cX, cY, cX - 1, cY, cX + 1, cY + 2);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX + 1 <= 6) && lY < cY && (lXY == colourD [lX - 1] [lY] && lXY == colourD [lX + 1] [lY + 2]))
	{
	    pointCalculator (lX, lY, lX - 1, lY, lX + 1, lY + 2);
	    return true;
	}
	else if ((cY + 2 <= 6) && (cX + 1 <= 6) && cY < lY && (cXY == colourD [cX - 1] [cY + 2] && cXY == colourD [cX + 1] [cY]))
	{
	    pointCalculator (cX, cY, cX - 1, cY + 2, cX + 1, cY);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX + 1 <= 6) && lY < cY && (lXY == colourD [lX - 1] [lY + 2] && lXY == colourD [lX + 1] [lY]))
	{
	    pointCalculator (lX, lY, lX - 1, lY + 2, lX + 1, lY);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the middle by swapping left
    public boolean middleLeft (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 2 >= 0) && (cX + 1 <= 6) && cY > lY && (cXY == colourD [cX - 1] [cY - 2] && cXY == colourD [cX + 1] [cY]))
	{
	    pointCalculator (cX, cY, cX - 1, cY - 2, cX + 1, cY);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX + 1 <= 6) && lY > cY && (lXY == colourD [lX - 1] [lY - 2] && lXY == colourD [lX + 1] [lY]))
	{
	    pointCalculator (lX, lY, lX - 1, lY - 2, lX + 1, lY);
	    return true;
	}
	else if ((cY - 2 >= 0) && (cX + 1 <= 6) && cY > lY && (cXY == colourD [cX - 1] [cY] && cXY == colourD [cX + 1] [cY - 2]))
	{
	    pointCalculator (cX, cY, cX - 1, cY, cX + 1, cY - 2);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX + 1 <= 6) && lY > cY && (lXY == colourD [lX - 1] [lY] && lXY == colourD [lX + 1] [lY - 2]))
	{
	    pointCalculator (lX, lY, lX - 1, lY, lX + 1, lY - 2);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the middle by swapping down
    public boolean middleDown (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 1 >= 0) && (cY + 1 <= 6) && (cX + 2 <= 6) && cX < lX && (cXY == colourD [cX] [cY - 1] && cXY == colourD [cX + 2] [cY + 1]))
	{
	    pointCalculator (cX, cY, cX, cY - 1, cX + 2, cY + 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lY + 1 <= 6) && (lX + 2 <= 6) && lX < cX && (lXY == colourD [lX] [lY - 1] && lXY == colourD [lX + 2] [lY + 1]))
	{
	    pointCalculator (lX, lY, lX, lY - 1, lX + 2, lY + 1);
	    return true;
	}
	else if ((cY - 1 >= 0) && (cY + 1 <= 6) && (cX + 2 <= 6) && cX < lX && (cXY == colourD [cX + 2] [cY - 1] && cXY == colourD [cX] [cY + 1]))
	{
	    pointCalculator (cX, cY, cX + 2, cY - 1, cX, cY + 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lY + 1 <= 6) && (lX + 2 <= 6) && lX < cX && (lXY == colourD [lX + 2] [lY - 1] && lXY == colourD [lX] [lY + 1]))
	{
	    pointCalculator (lX, lY, lX + 2, lY - 1, lX, lY + 1);
	    return true;
	}
	else
	    return false;
    }


    //holds all possibilities for how you can form a diagonal line using the middle piece
    public boolean isValidMiddleDiagonal (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if (middleUp (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (middleDown (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (middleRight (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (middleLeft (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else
	    return false;
    }


    //diagonal line is formed at the bottom by swapping up
    public boolean bottomUp (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 2 >= 0) && (cX - 3 >= 0) && cX > lX && (cXY == colourD [cX - 2] [cY - 1] && cXY == colourD [cX - 3] [cY - 2]))
	{
	    pointCalculator (cX, cY, cX - 2, cY - 1, cX - 3, cY - 2);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX - 3 >= 0) && lX > cX && (lXY == colourD [lX - 2] [lY - 1] && lXY == colourD [lX - 3] [lY - 2]))
	{
	    pointCalculator (lX, lY, lX - 2, lY - 1, lX - 3, lY - 2);
	    return true;
	}
	else if ((cY + 2 <= 6) && (cX - 3 >= 0) && cX > lX && (cXY == colourD [cX - 2] [cY + 1] && cXY == colourD [cX - 3] [cY + 2]))
	{
	    pointCalculator (cX, cY, cX - 2, cY + 1, cX - 3, cY + 2);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX - 3 >= 0) && lX > cX && (lXY == colourD [lX - 2] [lY + 1] && lXY == colourD [lX - 3] [lY + 2]))
	{
	    pointCalculator (lX, lY, lX - 2, lY + 1, lX - 3, lY + 2);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the bottom by swapping right
    public boolean bottomRight (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 1 >= 0) && (cX - 2 >= 0) && cY < lY && (cXY == colourD [cX - 1] [cY] && cXY == colourD [cX - 2] [cY - 1]))
	{
	    pointCalculator (cX, cY, cX - 1, cY, cX - 2, cY - 1);
	    return true;
	}
	else if ((lY - 1 >= 0) && (lX - 2 >= 0) && lY < cY && (lXY == colourD [lX - 1] [lY] && lXY == colourD [lX - 2] [lY - 1]))
	{
	    pointCalculator (lX, lY, lX - 1, lY, lX - 2, lY - 1);
	    return true;
	}
	else if ((cY + 3 <= 6) && (cX - 2 >= 0) && cY < lY && (cXY == colourD [cX - 1] [cY + 2] && cXY == colourD [cX - 2] [cY + 3]))
	{
	    pointCalculator (cX, cY, cX - 1, cY + 2, cX - 2, cY + 3);
	    return true;
	}
	else if ((lY + 3 <= 6) && (lX - 2 >= 0) && lY < cY && (lXY == colourD [lX - 1] [lY + 2] && lXY == colourD [lX - 2] [lY + 3]))
	{
	    pointCalculator (lX, lY, lX - 1, lY + 2, lX - 2, lY + 3);
	    return true;
	}
	else
	    return false;
    }


    //diagonal line is formed at the bottom by swapping left
    public boolean bottomLeft (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 3 >= 0) && (cX - 2 >= 0) && cY > lY && (cXY == colourD [cX - 1] [cY - 2] && cXY == colourD [cX - 2] [cY - 3]))
	{
	    pointCalculator (cX, cY, cX - 1, cY - 2, cX - 2, cY - 3);
	    return true;
	}
	else if ((lY - 3 >= 0) && (lX - 2 >= 0) && lY > cY && (lXY == colourD [lX - 1] [lY - 2] && lXY == colourD [lX - 2] [lY - 3]))
	{
	    pointCalculator (lX, lY, lX - 1, lY - 2, lX - 2, lY - 3);
	    return true;
	}
	else if ((cY + 1 <= 6) && (cX - 2 >= 0) && cY > lY && (cXY == colourD [cX - 1] [cY] && cXY == colourD [cX - 2] [cY + 1]))
	{
	    pointCalculator (cX, cY, cX - 1, cY, cX - 2, cY + 1);
	    return true;
	}
	else if ((lY + 1 <= 6) && (lX - 2 >= 0) && lY > cY && (lXY == colourD [lX - 1] [lY] && lXY == colourD [lX - 2] [lY + 1]))
	{
	    pointCalculator (lX, lY, lX - 1, lY, lX - 2, lY + 1);
	    return true;
	}
	else
	    return false;

    }


    //diagonal line is formed at the bottom by swapping down
    public boolean bottomDown (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if ((cY - 2 >= 0) && (cX + 1 <= 6) && cX < lX && (cXY == colourD [cX] [cY - 1] && cXY == colourD [cX - 1] [cY - 2]))
	{
	    pointCalculator (cX, cY, cX, cY - 1, cX - 1, cY - 2);
	    return true;
	}
	else if ((lY - 2 >= 0) && (lX + 1 <= 6) && lX < cX && (lXY == colourD [lX] [lY - 1] && lXY == colourD [lX - 1] [lY - 2]))
	{
	    pointCalculator (lX, lY, lX, lY - 1, lX - 1, lY - 2);
	    return true;
	}
	else if ((cY + 2 <= 6) && (cX + 1 <= 6) && cX < lX && (cXY == colourD [cX] [cY + 1] && cXY == colourD [cX - 1] [cY + 2]))
	{
	    pointCalculator (cX, cY, cX, cY + 1, cX - 1, cY + 2);
	    return true;
	}
	else if ((lY + 2 <= 6) && (lX + 1 <= 6) && lX < cX && (lXY == colourD [lX] [lY + 1] && lXY == colourD [lX - 1] [lY + 2]))
	{
	    pointCalculator (lX, lY, lX, lY + 1, lX - 1, lY + 2);
	    return true;
	}
	else
	    return false;
    }


    //holds all possibilities for how you can form a diagonal line using the bottom piece
    public boolean isValidBottomDiagonal (int cX, int cY, int lX, int lY, char cXY, char lXY)
    {
	if (bottomUp (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (bottomDown (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (bottomRight (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else if (bottomLeft (cX, cY, lX, lY, cXY, lXY))
	    return true;
	else
	    return false;
    }


    //swaps the two pieces user has chosen
    public void swap (int a, int b, int c, int d, int r, int cL)
    {
	if (level == 4)
	{
	    //swap using 7 by 7 arrays
	    char tempColour = colourD [a] [b];
	    char tempType = typeD [a] [b];
	    colourD [a] [b] = colourD [c] [d];
	    typeD [a] [b] = typeD [c] [d];
	    colourD [c] [d] = tempColour;
	    typeD [c] [d] = tempType;
	    //randomizes any pieces that formed a diagonal line
	    randomizeDiagonal ();

	}
	else
	{
	    //swaps using 9 by 9 arrays
	    char tempColour = colour [a] [b];
	    char tempType = type [a] [b];
	    colour [a] [b] = colour [c] [d];
	    type [a] [b] = type [c] [d];
	    colour [c] [d] = tempColour;
	    type [c] [d] = tempType;
	    //if a horizontal line has been formed, the row number is sent in
	    if (r != -1)
		updateHorizontal (r);
	    //if a vertical line has been formed, the column number is sent in
	    if (cL != -1)
		updateVertical (cL);
	}
    }


    //randomizes the type of piece
    public char randomizeType ()
    {
	int a = (int) (Math.random () * 3 + 1);
	if (a == 1)
	    return 'p';
	else if (a == 2)
	    return 'h';
	else
	    return 'c';
    }


    //randomizes the colour of the piece
    public char randomizeColour ()
    {
	int a = (int) (Math.random () * 6 + 1);
	if (a == 1)
	    return 'v';
	else if (a == 2)
	    return 'o';
	else if (a == 3)
	    return 'y';
	else if (a == 4)
	    return 'g';
	else if (a == 5)
	    return 'c';
	else
	    return 'p';
    }


    //after user has made a horiontal line, all the pieces above should fall down by 1
    public void updateHorizontal (int r)
    {
	int j = 0;
	int m = 0;
	//checks until column six for a horizontal line of three
	for (int i = 0 ; i <= 6 ; i++)
	{
	    //if there is a horizontal line of three formed, set the pieces to blank temorarily
	    if (colour [r] [i] == colour [r] [i + 1] && colour [r] [i] == colour [r] [i + 2])
	    {
		//calculates the points gained through the line
		pointCalculator (r, i, r, i + 1, r, i + 2);
		//pieces are temporarily set to blank
		colour [r] [i] = '-';
		colour [r] [i + 1] = '-';
		colour [r] [i + 2] = '-';
		type [r] [i] = '-';
		type [r] [i + 1] = '-';
		type [r] [i + 2] = '-';
		//start with column i, and one above row
		j = r - 1;
		m = i;
		//every piece above the horizontal line formed falls one down. this happens for all three columns
		for (int n = 0 ; n < 3 ; n++)
		{
		    while (j != -1)
		    {
			colour [j + 1] [m] = colour [j] [m];
			type [j + 1] [m] = type [j] [m];
			piece [j + 1] [m] = piece [j] [m];
			colour [j] [m] = '-';
			type [j] [m] = '-';
			piece [j] [m] = '-';
			j--;
		    }
		    j = r - 1;
		    m += 1;
		}
		//any position on the board that is blank is then randomized
		randomize ();
	    }
	}
    }


    //after user has made a vertical line, all the pieces above should fall down by 3
    public void updateVertical (int c)
    {
	int j = 0;
	//checks until row 6 for a vertical line formed
	for (int i = 0 ; i <= 6 ; i++)
	{
	    //if there is a vertical line of three formed, set the pieces to blank temorarily
	    if (colour [i] [c] == colour [i + 1] [c] && colour [i] [c] == colour [i + 2] [c])
	    {
		//calculates the points gained through the line
		pointCalculator (i, c, i + 1, c, i + 2, c);
		//pieces are temporarily set to blank
		colour [i] [c] = '-';
		colour [i + 1] [c] = '-';
		colour [i + 2] [c] = '-';
		type [i] [c] = '-';
		type [i + 1] [c] = '-';
		type [i + 2] [c] = '-';
		//start with the row above the top piece of the vertical line
		j = i - 1;
		//every piece above the vertical line formed falls down by 3.
		while (j != -1)
		{
		    colour [j + 3] [c] = colour [j] [c];
		    type [j + 3] [c] = type [j] [c];
		    piece [j + 3] [c] = piece [j] [c];
		    colour [j] [c] = '-';
		    type [j] [c] = '-';
		    piece [j] [c] = '-';
		    j--;
		}
		//any pieces that are still blank are randomized
		randomize ();
	    }
	}
    }


    //goes through the 9 by 9 board and checks for any blank pieces. assigns a random colour and type to them.
    public void randomize ()
    {
	for (int i = 0 ; i < 9 ; i++)
	{
	    for (int j = 0 ; j < 9 ; j++)
	    {
		if (colour [i] [j] == '-' && piece [i] [j] != 'c')
		{
		    colour [i] [j] = randomizeColour ();
		    type [i] [j] = randomizeType ();
		    piece [i] [j] = 'r';
		}
	    }
	}
    }


    //after user forms a diagonal line those pieces are randomized
    public void randomizeDiagonal ()
    {
	int d = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		//first way diagonal line can be formed
		if ((i + 2 <= 6) && (j + 2 <= 6) && colourD [i] [j] == colourD [i + 1] [j + 1] && colourD [i] [j] == colourD [i + 2] [j + 2])
		{
		    d = 1;
		    colourD [i] [j] = randomizeColour ();
		    colourD [i + 1] [j + 1] = randomizeColour ();
		    colourD [i + 2] [j + 2] = randomizeColour ();
		    typeD [i] [j] = randomizeType ();
		    typeD [i + 1] [j + 1] = randomizeType ();
		    typeD [i + 2] [j + 2] = randomizeType ();
		}
		//second way diagonal line can be formed
		else if ((i + 2 <= 6) && (j - 2 >= 0) && colourD [i] [j] == colourD [i + 1] [j - 1] && colourD [i] [j] == colourD [i + 2] [j - 2])
		{
		    d = 1;
		    colourD [i] [j] = randomizeColour ();
		    colourD [i + 1] [j - 1] = randomizeColour ();
		    colourD [i + 2] [j - 2] = randomizeColour ();
		    typeD [i] [j] = randomizeType ();
		    typeD [i + 1] [j - 1] = randomizeType ();
		    typeD [i + 2] [j - 2] = randomizeType ();
		}
	    }
	}
	//if a line has been formed, go through board again to check for any other lines.
	if (d == 1)
	    randomizeDiagonal ();
    }


    //checks if a horizontal line can be formed
    public boolean checkHorizontalLine (int cX, int cY, int lX, int lY)
    {
	char cXY = colour [cX] [cY];
	char lXY = colour [lX] [lY];
	//horizontal ine is formed on the right by swapping up or down
	if (checkHorizontalUpDownR (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//horiontal line is formed on the left by swapping up or down
	else if (checkHorizontalUpDownL (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//horizontal line is formed in the middle by swapping up or down
	else if (checkHorizontalUpDownM (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//horizontal line is formed on the right or left by swapping right or left
	else if (checkHorizontalRightLeftRL (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//return false
	else
	    return false;
    }


    //checks if a horizontal line can be formed on the right or left by swapping right or left
    public boolean checkHorizontalRightLeftRL (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cY + 3 <= 8) && cY < lY && (cXY == colour [cX] [cY + 2] && cXY == colour [cX] [cY + 3]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else if ((lY + 3 <= 8) && lY < cY && (lXY == colour [lX] [lY + 2] && lXY == colour [lX] [lY + 3]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((cY - 3 >= 0) && lY < cY && (cXY == colour [cX] [cY - 2] && cXY == colour [cX] [cY - 3]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else if ((lY - 3 >= 0) && cY < lY && (lXY == colour [lX] [lY - 2] && lXY == colour [lX] [lY - 3]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else
	    return false;
    }


    //checks if a horizontal line can be formed in the middle by swapping up or down
    public boolean checkHorizontalUpDownM (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cY + 1 <= 8) && (cY - 1 >= 0) && cX < lX && (cXY == colour [lX] [cY - 1] && cXY == colour [lX] [cY + 1]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((cY + 1 <= 8) && (cY - 1 >= 0) && cX > lX && (cXY == colour [lX] [cY - 1] && cXY == colour [lX] [cY + 1]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((lY + 1 <= 8) && (lY - 1 >= 0) && lX < cX && (lXY == colour [cX] [lY - 1] && lXY == colour [cX] [lY + 1]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else if ((lY + 1 <= 8) && (lY - 1 >= 0) && lX > cX && (lXY == colour [cX] [lY - 1] && lXY == colour [cX] [lY + 1]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else
	    return false;
    }


    //checks if a horizontal line can be formed on the right by swapping up or down
    public boolean checkHorizontalUpDownR (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cY + 2 <= 8) && cX < lX && (cXY == colour [lX] [cY + 1] && cXY == colour [lX] [cY + 2]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((cY + 2 <= 8) && lX < cX && (cXY == colour [lX] [cY + 1] && cXY == colour [lX] [cY + 2]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((lY + 2 <= 8) && lX < cX && (lXY == colour [cX] [lY + 1] && lXY == colour [cX] [lY + 2]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else if ((lY + 2 <= 8) && cX < lX && (lXY == colour [cX] [lY + 1] && lXY == colour [cX] [lY + 2]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else
	    return false;
    }


    //checks if a horizontal line can be formed on the left by swapping up or down
    public boolean checkHorizontalUpDownL (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cY - 2 >= 0) && cX < lX && (cXY == colour [lX] [cY - 1] && cXY == colour [lX] [cY - 2]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((cY - 2 >= 0) && lX < cX && (cXY == colour [lX] [cY - 1] && cXY == colour [lX] [cY - 2]))
	{
	    swap (cX, cY, lX, lY, lX, -1);
	    return true;
	}
	else if ((lY - 2 >= 0) && lX < cX && (lXY == colour [cX] [lY - 1] && lXY == colour [cX] [lY - 2]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else if ((lY - 2 >= 0) && cX < lX && (lXY == colour [cX] [lY - 1] && lXY == colour [cX] [lY - 2]))
	{
	    swap (cX, cY, lX, lY, cX, -1);
	    return true;
	}
	else
	    return false;
    }


    //checks if a vertical line can be formed
    public boolean checkVerticalLine (int cX, int cY, int lX, int lY)
    {
	char cXY = colour [cX] [cY];
	char lXY = colour [lX] [lY];
	//up and down swaps that make a vertical line
	if (checkVerticalLineUpDown (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//vertical line is made at the bottom by swapping left or right
	else if (checkVerticalLineRightLeftB (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//vertical line is made at the top by swapping left or right
	else if (checkVerticalLineRightLeftA (cX, cY, lX, lY, cXY, lXY))
	    return true;
	//vertical line is made by swapping right or left in the middle
	else if (checkVerticalLineRightLeftM (cX, cY, lX, lY, cXY, lXY))
	    return true;
	return false;
    }


    //a vertical line is formed by swapping up or down
    public boolean checkVerticalLineUpDown (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cX + 3 <= 8) && cX < lX && (cXY == colour [cX + 2] [cY] && cXY == colour [cX + 3] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else if ((lX + 3 <= 8) && lX < cX && (lXY == colour [lX + 2] [lY] && lXY == colour [lX + 3] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((lX - 3 >= 0) && cX < lX && lX < 9 && (lXY == colour [lX - 2] [lY] && lXY == colour [lX - 3] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((cX - 3 >= 0) && lX < cX && (cXY == colour [cX - 2] [cY] && cXY == colour [cX - 3] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else
	    return false;
    }


    //vertical line is made at the bottom by swapping left or right
    public boolean checkVerticalLineRightLeftB (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cX + 2 <= 8) && (cY + 1 <= 8) && cY < lY && (cXY == colour [cX + 1] [lY] && cXY == colour [cX + 2] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((cX + 2 <= 8) && (cY - 1 >= 0) && lY < cY && (cXY == colour [cX + 1] [lY] && cXY == colour [cX + 2] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((lX + 2 <= 8) && (lY + 1 <= 8) && lY < cY && (lXY == colour [lX + 1] [cY] && lXY == colour [lX + 2] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else if ((lX + 2 <= 8) && (lY - 1 >= 0) && cY < lY && (lXY == colour [lX + 1] [cY] && lXY == colour [lX + 2] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else
	    return false;
    }


    //vertical line is made at the top by swapping left or right
    public boolean checkVerticalLineRightLeftA (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cX - 2 >= 0) && (cY + 1 <= 8) && cY < lY && (cXY == colour [cX - 1] [lY] && cXY == colour [cX - 2] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((cX - 2 >= 0) && (cY - 1 >= 0) && lY < cY && (cXY == colour [cX - 1] [lY] && cXY == colour [cX - 2] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((lX - 2 >= 0) && (lY + 1 <= 8) && lY < cY && (lXY == colour [lX - 1] [cY] && lXY == colour [lX - 2] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else if ((lX - 2 >= 0) && (lY - 1 >= 0) && cY < lY && (lXY == colour [lX - 1] [cY] && lXY == colour [lX - 2] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else
	    return false;
    }


    //vertical line is made at the middle by swapping left or right
    public boolean checkVerticalLineRightLeftM (int cX, int cY, int lX, int lY, int cXY, int lXY)
    {
	if ((cX - 1 >= 0) && (cX + 1 <= 8) && cY < lY && (cXY == colour [cX - 1] [lY] && cXY == colour [cX + 1] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((lX - 1 >= 0) && (lX + 1 <= 8) && lY < cY && (lXY == colour [lX - 1] [cY] && lXY == colour [lX + 1] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	//vertical ine is made by swapping left in the middle
	else if ((cX - 1 >= 0) && (cX + 1 <= 8) && cY > lY && (cXY == colour [cX - 1] [lY] && cXY == colour [cX + 1] [lY]))
	{
	    swap (cX, cY, lX, lY, -1, lY);
	    return true;
	}
	else if ((lX - 1 >= 0) && (lX + 1 <= 8) && lY > cY && (lXY == colour [lX - 1] [cY] && lXY == colour [lX + 1] [cY]))
	{
	    swap (cX, cY, lX, lY, -1, cY);
	    return true;
	}
	else
	    return false;
    }


    //calculates points for level 4
    public void pointCalculator1 (int a, int b, int c, int d, int e, int f)
    {
	if (typeD [a] [b] == 'p')
	    score++;
	else if (typeD [a] [b] == 'h')
	    score += 2;
	else if (typeD [a] [b] == 'c')
	    score += 3;
	if (typeD [c] [d] == 'p')
	    score++;
	else if (typeD [c] [d] == 'h')
	    score += 2;
	else if (typeD [c] [d] == 'c')
	    score += 3;
	if (typeD [e] [f] == 'p')
	    score++;
	else if (typeD [e] [f] == 'h')
	    score += 2;
	else if (typeD [e] [f] == 'c')
	    score += 3;
    }


    //calculates points for levels 1-3
    public void pointCalculator2 (int a, int b, int c, int d, int e, int f)
    {
	if (type [a] [b] == 'p')
	    score++;
	else if (type [a] [b] == 'h')
	    score += 2;
	else if (type [a] [b] == 'c')
	    score += 3;
	if (type [c] [d] == 'p')
	    score++;
	else if (type [c] [d] == 'h')
	    score += 2;
	else if (type [c] [d] == 'c')
	    score += 3;
	if (type [e] [f] == 'p')
	    score++;
	else if (type [e] [f] == 'h')
	    score += 2;
	else if (type [e] [f] == 'c')
	    score += 3;
    }


    //calculates points for all levels
    public void pointCalculator (int a, int b, int c, int d, int e, int f)
    {
	if (level == 4)
	    pointCalculator1 (a, b, c, d, e, f);
	else
	    pointCalculator2 (a, b, c, d, e, f);
    }


    //rests the board
    public void reset ()
    {
	//9 by 9 board is reset
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		colour [i] [j] = colour1 [i] [j];
		type [i] [j] = type1 [i] [j];
		piece [i] [j] = piece1 [i] [j];
	    }
	}
	//7 by 7 board is reset
	for (int k = 0 ; k < row1 ; k++)
	{
	    for (int l = 0 ; l < col1 ; l++)
	    {
		colourD [k] [l] = colourD1 [k] [l];
		typeD [k] [l] = typeD1 [k] [l];
	    }
	}
	//global variables are reset
	move = 0;
	score = 0;
	last = -1;
	//individual levels are reset
	if (level == 1)
	    choosePoints ();
	if (level == 2)
	{
	    chooseTime ();
	    resetTime ();
	}
	if (level == 3)
	{
	    chooseCupcake ();
	}
	else if (level == 4)
	{
	    choosePoints ();
	    resetTime ();
	}
	//board(s) are redrawn
	redraw ();
    }


    //if the user goes back to the instructions screen and comes back, the board resets
    public void resetBoard ()
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		colour [i] [j] = colour1 [i] [j];
		type [i] [j] = type1 [i] [j];
		piece [i] [j] = piece1 [i] [j];
	    }
	}
	for (int k = 0 ; k < row1 ; k++)
	{
	    for (int l = 0 ; l < col1 ; l++)
	    {
		colourD [k] [l] = colourD1 [k] [l];
		typeD [k] [l] = typeD1 [k] [l];
	    }
	}
	move = 0;
	score = 0;
	last = -1;
	redraw ();
    }


    //checks if there is a burned cupcake in the bottom row
    public boolean checkCupcake ()
    {
	int cLine = 0;
	for (int i = 0 ; i < 9 ; i++)
	{
	    if (piece [8] [i] == 'c')
		cLine = 8;
	}
	if (cLine == 8)
	    return true;
	else
	    return false;
    }


    //randomizes the board
    public void randomBoard ()
    {
	for (int i = 0 ; i < row1 ; i++)
	{
	    for (int j = 0 ; j < col1 ; j++)
	    {
		colourD [i] [j] = randomizeColour ();
		typeD [i] [j] = randomizeType ();
	    }
	}
	randomizeDiagonal ();
	redraw ();
    }


    //checks if user has won for all levels
    public boolean win ()
    {
	if (level == 1 && score >= winPoints)
	    return true;
	else if (level == 2 && !time (min1, sec1) && score >= 50)
	    return true;
	else if (level == 3 && score >= 50)
	    return true;
	else if (level == 4 && !time1 (min1, sec1) && score >= winPoints)
	    return true;
	else
	    return false;
    }


    //if user move is invalid, show this message on the screen
    public void invalid ()
    {
	JOptionPane.showMessageDialog (null, "* * * I N V A L I D  M O V E * * * \n \n"
		+ "These two pieces can not be swapped. \n"
		+ "Please choose again. \n"
		+ "If you need help, click on the hint button or go back to the instructions screen. \n"
		+ "Happy playing!", "Invalid move", JOptionPane.INFORMATION_MESSAGE);
    }


    //hint for level 1
    public void hint1 ()
    {
	JOptionPane.showMessageDialog (null, "* * * H I N T * * * \n \n"
		+ "Looks like you need help! \n"
		+ "Remember, you can only swap neighboring pieces if a horizontal or vertical line can be formed. \n"
		+ "If you are playing the easy level, you need 30 points to win! \n"
		+ "If you are playing the medium level, you need 50 points to win! \n"
		+ "If you are playing the hard level, you need 100 points to win! \n"
		+ "Happy playing!", "Good luck!", JOptionPane.INFORMATION_MESSAGE);
    }


    //hint for level 2
    public void hint2 ()
    {
	JOptionPane.showMessageDialog (null, "* * * H I N T * * * \n \n"
		+ "Looks like you need help! \n"
		+ "Remember, you can only swap neighboring pieces if a horizontal or vertical line can be formed. \n"
		+ "If you are playing the easy level, you have 60 seconds to get 50 points! \n"
		+ "If you are playing the medium level, you have 40 seconds to get 50 points! \n"
		+ "If you are playing the hard level, you have 20 seconds to get 50 points! \n"
		+ "Happy playing!", "Good luck!", JOptionPane.INFORMATION_MESSAGE);
    }


    //hint for level 3
    public void hint3 ()
    {
	JOptionPane.showMessageDialog (null, "* * * H I N T * * * \n \n"
		+ "Looks like you need help! \n"
		+ "Remember, you can only swap neighboring pieces if a horizontal or vertical line can be formed. \n"
		+ "If you are playing the easy level, there is one burned cupcake. Get 50 points before it reaches the bottom! \n"
		+ "If you are playing the medium level, there are three burned cupcake. Get 50 points before one of them reaches the bottom! \n"
		+ "If you are playing the hard level, there are five burned cupcake. Get 50 points before one of them reaches the bottom! \n"
		+ "Happy playing!", "Good luck!", JOptionPane.INFORMATION_MESSAGE);
    }


    //hint for level 4
    public void hint4 ()
    {
	JOptionPane.showMessageDialog (null, "* * * H I N T * * * \n \n"
		+ "Looks like you need help! \n"
		+ "Remember, you can only swap neighboring pieces if a DIAGONAL line can be formed. \n"
		+ "If you are playing the easy level, you must get 30 points in under 60 seconds! \n"
		+ "If you are playing the medium level, you must get 50 points in under 60 seconds! \n"
		+ "If you are playing the hard level, you must get 100 points in under 60 seconds! \n"
		+ "Happy playing!", "Good luck!", JOptionPane.INFORMATION_MESSAGE);
    }


    //choose level for points smash and diagonal smash
    public void choosePoints ()
    {
	String[] possibleValues = {"Easy-30", "Medium-50", "Hard-100"};
	String selectedValue = (String) JOptionPane.showInputDialog (null,
		"Choose a level:", "Input", JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues [0]);
	if (selectedValue.equals ("Easy-30"))
	    winPoints = 30;
	else if (selectedValue.equals ("Medium-50"))
	    winPoints = 50;
	else
	    winPoints = 100;
    }


    //choose time for time smash
    public void chooseTime ()
    {
	String[] possibleValues = {"Easy-60 seconds", "Medium-40 seconds", "Hard-20 seconds"};
	String selectedValue = (String) JOptionPane.showInputDialog (null,
		"Choose a level", "Input", JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues [0]);
	if (selectedValue.equals ("Easy-60 seconds"))
	    time = 60;
	else if (selectedValue.equals ("Medium-40 seconds"))
	    time = 40;
	else
	    time = 20;
    }


    //choose number of cupcakes for burn smash
    public void chooseCupcake ()
    {
	String[] possibleValues = {"Easy-1 cupcake", "Medium-3 cupcakes", "Hard-5 cupcakes"};
	String selectedValue = (String) JOptionPane.showInputDialog (null,
		"Choose a level", "Input", JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues [0]);
	if (selectedValue.equals ("Easy-1 cupcake"))
	{
	    colour [0] [5] = '-';
	    type [0] [5] = '-';
	    piece [0] [5] = 'c';
	}
	else if (selectedValue.equals ("Medium-3 cupcakes"))
	{
	    for (int i = 0 ; i < 7 ; i += 3)
	    {
		colour [0] [i] = '-';
		type [0] [i] = '-';
		piece [0] [i] = 'c';
	    }
	}
	else
	{
	    for (int j = 0 ; j < 9 ; j += 2)
	    {
		colour [0] [j] = '-';
		type [0] [j] = '-';
		piece [0] [j] = 'c';
	    }
	}
    }


    //choose the game version user wants to play
    public void chooseLevel ()
    {
	String[] possibleValues = {"Level 1-Point Smash", "Level 2-Time Smash", "Level 3-Burn Smash", "Level4-Diagonal Smash"};
	String selectedValue = (String) JOptionPane.showInputDialog (null,
		"Choose a level", "Input", JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues [0]);
	if (selectedValue.equals ("Level 1-Point Smash"))
	{
	    level = 1;
	    cdLayout.show (p_card, "3");
	    choosePoints ();
	}
	else if (selectedValue.equals ("Level 2-Time Smash"))
	{
	    level = 2;
	    cdLayout.show (p_card, "4");
	    chooseTime ();
	    startTime ();
	}
	else if (selectedValue.equals ("Level 3-Burn Smash"))
	{
	    level = 3;
	    cdLayout.show (p_card, "5");
	    chooseCupcake ();
	    redraw ();
	}
	else
	{
	    level = 4;
	    cdLayout.show (p_card, "6");
	    choosePoints ();
	    startTime ();
	}

    }


    public void actionPerformed (ActionEvent e)
    { //instructions
	if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	//goes to instructions screen and resets the board
	else if (e.getActionCommand ().equals ("instructions"))
	{
	    cdLayout.show (p_card, "2");
	    resetBoard ();
	}
	//second instructions screen
	else if (e.getActionCommand ().equals ("s7"))
	    cdLayout.show (p_card, "7");
	//third instructions screen
	else if (e.getActionCommand ().equals ("s8"))
	    cdLayout.show (p_card, "8");
	//gives user options for level they want to play
	else if (e.getActionCommand ().equals ("chooseLevel"))
	    chooseLevel ();
	//if user quits game
	else if (e.getActionCommand ().equals ("quit"))
	    System.exit (0);
	//board is reset
	else if (e.getActionCommand ().equals ("reset"))
	    reset ();
	//board is randomized
	else if (e.getActionCommand ().equals ("random"))
	    randomBoard ();
	//hint for level 1
	else if (e.getActionCommand ().equals ("hint1"))
	    hint1 ();
	//hint for level 2
	else if (e.getActionCommand ().equals ("hint2"))
	    hint2 ();
	//hint for level 3
	else if (e.getActionCommand ().equals ("hint3"))
	    hint3 ();
	//hint for level 4
	else if (e.getActionCommand ().equals ("hint4"))
	    hint4 ();
	//user clicks any grid button
	else
	{
	    int n = Integer.parseInt (e.getActionCommand ());
	    gridClick (n);
	}
    }
}




