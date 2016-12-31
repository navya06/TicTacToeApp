package com.example.navyakaree.tictactoeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.navyakaree.tictactoeapp.R.color.winnerColor;

public class MainActivity extends AppCompatActivity {
    Button[][] button =new Button[3][3];
    ComputerActivity computerActivity =new ComputerActivity();
    TextView whoseTurn, winner;
    Button replayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        button[0][0]=(Button)findViewById(R.id.cell_00);
        button[0][1]=(Button)findViewById(R.id.cell_01);
        button[0][2]=(Button)findViewById(R.id.cell_02);

        button[1][0]=(Button)findViewById(R.id.cell_10);
        button[1][1]=(Button)findViewById(R.id.cell_11);
        button[1][2]=(Button)findViewById(R.id.cell_12);


        button[2][0]=(Button)findViewById(R.id.cell_20);
        button[2][1]=(Button)findViewById(R.id.cell_21);
        button[2][2]=(Button)findViewById(R.id.cell_22);
        whoseTurn =(TextView)findViewById(R.id.whoseTurnTextView);
        winner =(TextView)findViewById(R.id.winnerResultTextView);
        replayButton =(Button)findViewById(R.id.replayButton);
        boolean type=getIntent().getBooleanExtra("TYP",true);
        if(type)
        {

            ComputerActivity.cha_inf='O';
            updatedGrid();
            whoseTurn.setText("Me First");

        }else
        {
            ComputerActivity.cha_inf='X';
            computerActivity.play(0,0,ComputerActivity.cha_inf);
            updatedGrid();

            whoseTurn.setText("Computer First");
        }


        button[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(0,0,ComputerActivity.cha_inf);
                updatedGrid();


            }
        });
        button[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(0,1,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });
        button[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(0,2,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });




        button[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(1,0,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });
        button[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(1,1,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });
        button[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(1,2,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });





        button[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(2,0,ComputerActivity.cha_inf);
                updatedGrid();
            }
        });
        button[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(2,1,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });
        button[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity.play(2,2,ComputerActivity.cha_inf);
                updatedGrid();

            }
        });

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computerActivity =new ComputerActivity();
                winner.setText("The winner is");
                boolean type=getIntent().getBooleanExtra("TYP",true);
                if(type)
                {

                    ComputerActivity.cha_inf='O';
                    updatedGrid();
                    whoseTurn.setText("Me First");

                }else
                {
                    ComputerActivity.cha_inf='X';
                    computerActivity.play(0,0,ComputerActivity.cha_inf);
                    updatedGrid();

                    whoseTurn.setText("Computer First");
                }

            }
        });

    }

    private void updatedGrid()
    {
        char[][] squreinfo= computerActivity.Original();
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                if(squreinfo[i][j]!='.') {
                    button[i][j].setText(squreinfo[i][j]+"");
                    button[i][j].setEnabled(false);
                }else
                {
                    button[i][j].setText("");
                    button[i][j].setEnabled(true);
                }
        }
        if(computerActivity.gameOver()&& computerActivity.score()==0) {
            winner.setTextColor(getResources().getColor(winnerColor));
            winner.setText("Nobody wins!");
        }
        else if(computerActivity.gameOver()) {
            if (computerActivity.score() == 1) {
                winner.setTextColor(getResources().getColor(winnerColor));
                winner.setText("Computer wins");
            } else {
                winner.setTextColor(getResources().getColor(winnerColor));
                winner.setText("You wins");
            }
        }
    }
}
