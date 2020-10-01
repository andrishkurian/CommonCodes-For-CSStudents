import  java.awt.event.*;
import  java.awt.*;
public class Sanan extends Frame implements ActionListener   // change class name
{    
    TextField phrase= new TextField(100);// alternate according to requirement, currently set to 100 characters, accepts the sentence and stores short form
    TextField shortF = new TextField (50);

    Label word= new Label("Enter the word:");               // labels to be displayed
    Label shortForm= new Label("The Abbrevation is:");

    Button clear=new Button("Clear");                       // buttons created
    Button FA=new Button("Find Abbrevation!");
    
    Sanan()                                         // create a constructor, initialize buttons and add necessary listeners
    {
        setLayout(new FlowLayout());                        
        addWindowListener(new MyWindowAdapter(this));
        
        add(word);
        add(phrase);
        add(shortForm);
        add(shortF);

        clear.addActionListener(this);
        FA.addActionListener(this);
        add(clear);
        add(FA);
    }
    public String shortHands(String inp)                // function to shorten words
    {   
        String s1=inp.strip();
        String s2=""+s1.charAt(0);              // first character is automatically added
        int length=s1.length();
        char ch,ch1;
        for(int i=1;i<length-1;i++)           //starts from the second letter
        {
            ch=s1.charAt(i);                   
            if(ch==' ')                     
            {
                ch1=s1.charAt(i+1);
                if(ch1!=' ')                //adds the next character after a space ' ', continuous spaces are ignored
                {
                    s2+=ch1;
                }
            }
        }
        s2=s2.toUpperCase();
        return s2;
    }
    public void actionPerformed(ActionEvent AE) {

        String buttonPressed = AE.getActionCommand();
        if  (buttonPressed == "Clear") 
        {
            phrase.setText("");
            shortF.setText("");
        } 
        else if ( buttonPressed == "Find Abbrevation!") 
        {
            String shortHand= shortHands(phrase.getText());
            shortF.setText(shortHand);
        }
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString("Please enter the text in the area given below:",250,60);
        
        word.setBounds(100, 150, 100, 50);      //sets the word and its labels
        phrase.setBounds(220, 150, 400, 35);

        shortForm.setBounds(100, 200, 100, 50); //sets short form and label
        shortF.setBounds(220, 200, 400, 35);

        clear.setBounds(200, 270, 70, 40);      // sets buttons
        FA.setBounds(400, 270, 150, 40);
       
        
    }
    public static void main(String args[])
    {
        Sanan cs=new Sanan();                   // create a window object, set size, name it and toggle the visibility
        cs.setSize(700,400);  
        cs.setTitle("Sanan");
        cs.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter  // handles window closing, when close button is clicked
{
    Sanan cs;
    public MyWindowAdapter(Sanan cs)
    {
        this.cs= cs;
    }
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}