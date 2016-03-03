package org.robovikings.scoutingapp2607;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Submit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView CSV = (TextView) findViewById(R.id.submit);
        CSV.setText(Data.CSV);
    }

    public void sendData(View view){
        PrintWriter writer=null;

        try {
            FileOutputStream os = openFileOutput("Data.csv", Context.MODE_PRIVATE);
            writer=new PrintWriter(os);
        } catch (Exception e) {
            // log exception
        }
        writer.print(Data.CSV);


        writer.flush();
        writer.close();
//String home = Submit.this.getFilesDir().getAbsolutePath();
   //     Snackbar.make(view , home , Snackbar.LENGTH_INDEFINITE).show();

Data.aHighMiss = 0;
        Data.aHigh = 0;
        Data.matchOver1 = false;
        Data.aLowMiss = 0;
        Data.aLow = 0;
        for(int x = 0; x<= Data.teleopdefenses.length - 1; x++){
            Data.teleopdefenses[x] = 0;}
        Data.absent = false;
        Data.broken = false;
        Data.challenge = false;
        Data.crossingComments = "";
        Data.CSV = "";
        Data.defenseComments = "";
        Data.fouls = 0;
        Data.teamNumber = "";
        Data.techFouls = 0;
        Data.High = 0;
        Data.Low = 0;
        Data.spy = false;
        Data.highMiss= 0;
        Data.lowMiss = 0;
        Data.skillComments = "";
        Data.matchOver3 = false;

        Intent main = new Intent(this, Scout.class);
        startActivity(main);


        this.finish();
    }


       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
    //        @Override
  //          public void onClick(View view) {
          //      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .setAction("Action", null).show();
//            }
       // });
  //  }

}
