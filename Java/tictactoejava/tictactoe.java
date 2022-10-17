import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class tictactoe implements ActionListener {
   Random random = new Random();
   JFrame frame = new JFrame();
   JPanel title = new JPanel();
   JPanel button = new JPanel();
   JLabel text = new JLabel();
   JButton [] buttons = new JButton[9];
   boolean playerturn;

  tictactoe()
  {
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(800,800);
     frame.getContentPane().setBackground(Color.BLACK);
     frame.setLayout(new BorderLayout());
     frame.setVisible(true);

     text.setBackground(Color.CYAN);
     text.setForeground(Color.BLACK);
     text.setFont(new Font("Ink Free",Font.BOLD,75));
     text.setHorizontalAlignment(JLabel.CENTER);
     text.setText("tic tac toe");
     text.setOpaque(true);

     button.setLayout(new GridLayout(3,3));
     button.setBackground(Color.GRAY);
      for (int i = 0; i < 9; i++) {
          buttons[i] = new JButton();
          button.add(buttons[i]);
          buttons[i].setFont(new Font("Mv Boli",Font.BOLD,120));
          buttons[i].setFocusable(false);
          buttons[i].addActionListener(this);

      }


     title.setLayout(new BorderLayout());
     title.setBounds(0,0,600,100);
     title.add(text);
     frame.add(title,BorderLayout.NORTH);
     frame.add(button);

     firstturn();

  }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++)
        {
            if(e.getSource()==buttons[i]) {
                if (playerturn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.CYAN);
                        buttons[i].setText("X");
                        playerturn=false;
                        text.setText("O turn");
                        checkwin();
                    }
                }
                else{
                    buttons[i].setForeground(Color.RED);
                    buttons[i].setText("O");
                    playerturn=true;
                    text.setText("X turn");
                    checkwin();
                }
            }


        }
    }

    public void firstturn()
    {
        if(random.nextInt(2)==0)
        {
            playerturn=true;
            text.setText("O turn");
        }
        else
        {
            playerturn=false;
            text.setText("X turn");
        }
    }
    public void checkwin()
    {
        if
           (    (buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
        )
        {
            xwins(0,1,2);
        }
        if
        (    (buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
        )
        {
            xwins(3,4,5);
        }
        if
        (       (buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")
        )
        {
            xwins(6,7,8);
        }if
    (    (buttons[1].getText()=="X")&&
                    (buttons[4].getText()=="X")&&
                    (buttons[7].getText()=="X")
    )
    {
        xwins(1,4,7);
    }
        if
        (    (buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")
        )
        {
            xwins(2,5,8);
        }
        if
        (    (buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")
        )
        {
            xwins(0,3,6);
        }
        if
        (    (buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")
        )
        {
            xwins(0,4,8);
        }
        if
        (    (buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")
        )
        {
            xwins(2,4,6);
        }

        if
        (    (buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")
        )
        {
            owins(0,1,2);
        }
        if
        (    (buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")
        )
        {
            owins(3,4,5);
        }
        if
        (       (buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")
        )
        {
            owins(6,7,8);
        }if
    (    (buttons[1].getText()=="O")&&
                    (buttons[4].getText()=="O")&&
                    (buttons[7].getText()=="O")
    )
    {
        owins(1,4,7);
    }
        if
        (    (buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")
        )
        {
            owins(2,5,8);
        }
        if
        (    (buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")
        )
        {
            owins(0,3,6);
        }
        if
        (    (buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")
        )
        {
            owins(0,4,8);
        }
        if
        (    (buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")
        )
        {
            owins(2  ,4,6);
        }

    }
    public void xwins(int a,int b,int c)
    {
         buttons[a].setBackground(Color.RED);
         buttons[b].setBackground(Color.RED);
         buttons[c].setBackground(Color.RED);
         for(int i=0 ;i < 9 ; i++)
        {
               buttons[i].setEnabled(false);
        }
         text.setText("X WINS");
    }
    public void owins(int a,int b,int c)
    {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        for(int i=0 ;i < 9 ; i++)
        {
            buttons[i].setEnabled(false);
        }
        text.setText("O WINS");
    }

}