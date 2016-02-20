package org.robovikings.scoutingapp2607;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Scout extends AppCompatActivity {


    public void Bluedefense1(View view){

        Data.defenses[0]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Blue Defense 1 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[0]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Blue Defense 1 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Bluedefense2(View view){

        Data.defenses[1]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Blue Defense 2 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[1]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Blue Defense 2 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }
    public void Bluedefense3(View view){

        Data.defenses[2]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Blue Defense 3 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[2]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Blue Defense 3 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }
    public void Bluedefense4(View view){

        Data.defenses[3]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Blue Defense 4 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[3]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Blue Defense 4 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Bluedefense5(View view){

        Data.defenses[4]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Blue Defense 5 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[4]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Blue Defense 5 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Reddefense1(View view){

        Data.defenses[5]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Red Defense 1 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[5]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Red Defense 1 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Reddefense2(View view){

        Data.defenses[6]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Red Defense 2 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[6]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Red Defense 2 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Reddefense3(View view){

        Data.defenses[7]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Red Defense 3 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[7]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Red Defense 3 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Reddefense4(View view){

        Data.defenses[8]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Red Defense 4 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[8]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Red Defense 4 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void Reddefense5(View view){

        Data.defenses[9]++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Red Defense 5 by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[9]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Red Defense 5 by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void blueTower(View view){
        AlertDialog.Builder adBuilder = new AlertDialog.Builder(
                view.getContext());
        adBuilder
                .setTitle("Shot on Blue Tower")
                .setCancelable(false)
                .setMessage("Where did it go?")
                .setPositiveButton("High Goal",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dlg, int blhGoal){
                        Data.blhGoal++;
                        dlg.cancel();
                    }

                })

                .setNegativeButton("Low Goal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int blLGoal) {
                        Data.blLGoal++;
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Miss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int blMiss) {
                        Data.blMiss++;
                        dialog.cancel();
                    }
                })
        ;
        AlertDialog alertDialog = adBuilder.create();
        alertDialog.show();
    }

    public void redTower(View view){
        AlertDialog.Builder adBuilder = new AlertDialog.Builder(
                view.getContext());
        adBuilder
                .setTitle("Shot on Red Tower")
                .setCancelable(false)
                .setMessage("Where did it go?")
                .setPositiveButton("High Goal",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dlg, int rdhGoal){
                        Data.rdhGoal++;
                        dlg.cancel();
                    }

                })

                .setNegativeButton("Low Goal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int blLGoal) {
                        Data.rdlGoal++;
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Miss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int blMiss) {
                        Data.rdMiss++;
                        dialog.cancel();
                    }
                })
        ;
        AlertDialog alertDialog = adBuilder.create();
        alertDialog.show();
    }

    public void fouls(View view){
        Data.fouls++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Fouls by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.fouls--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Fouls by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void techFouls(View view){
            Data.techFouls++;
        Snackbar snackbar = Snackbar
                .make(view, "Increased Tech Fouls by 1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data.defenses[1]--;
                        Snackbar unsnackbar = Snackbar.make(v, "Decreased Tech Fouls by 1", Snackbar.LENGTH_SHORT);
                        unsnackbar.show();
                    }
                });
        snackbar.show();
    }

    public void challenge(View view){
        Data.challenge = !Data.challenge;
    }

    public void reach(View view){
        Data.reach = !Data.reach;
    }

    public void absent(View view){
        Data.absent = ! Data.absent;
    }

    public void spy(View view){
        Data.spy = !Data.spy;
    }

    public void scale(View view){
        Data.scale = !Data.scale;
    }

    public void broken(View view){
        Data.broken = !Data.broken;
    }



    //Spinner teams = (Spinner) findViewById(R.id.Spinner);
    String[] T = new String[]{"Red 1", "Red 2", "Red 3", "Blue 1", "Blue 2", "Blue 3"};




    public void theBurki() {
 ViewPager viewpager = new ViewPager(this);
     //   setContentView(viewpager);
        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
//        System.out.println(spinner.toString());
  //      System.out.println(adapter.toString());
        Log.i("maybe","" + R.array.spinner);
       Log.i("maynot",""+ android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        /*
        List<String> sA =  new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, sA);

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.Spinner);
        //sItems.setAdapter(adapter);

        for(int mWillsIsCool = 0 ; mWillsIsCool < T.length ; mWillsIsCool++) {
            sA.add(T[mWillsIsCool]);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems.setAdapter(adapter);
        */
    }



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);

        if(findViewById(R.id.Fredment) != null){

            if(savedInstanceState != null){
                return;

            }

            Auton auton = new Auton();

          auton.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.Fredment, auton).commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText teamNumber = (EditText) findViewById(R.id.teamNumbers);

                Data.teamNumber = teamNumber.getText().toString();

                StringBuilder s = new StringBuilder();
                for (int count = 0; count < Data.defenses.length; count++) {
                    s.append(Data.defenses[count]).append(" ");
                }

                Snackbar.make(view, s, Snackbar.LENGTH_INDEFINITE)
                        .setAction("Towers?", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                EditText comments = (EditText) findViewById(R.id.comments);
                                //Data.Comments = comments.getText().toString();
                                Snackbar towers = Snackbar.make(v, Data.rdMiss + " " + Data.rdlGoal + " " + Data.rdhGoal + " " + Data.blMiss + " " + Data.blLGoal + " " + Data.blhGoal + " " + Data.challenge + " " + Data.teamNumber, Snackbar.LENGTH_INDEFINITE);
                                towers.show();
                            }
                        }).show();
            }
        });

        theBurki();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        int position;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

     @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

             View rootView = inflater.inflate(R.layout.auton, container, false);
             TextView textView = (TextView) rootView.findViewById(R.id.section_label);
             //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
             return rootView;
         }


        }


    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position == 0) {
                return Auton.newInstance(0);
            }

            if(position == 1){
                return Teleop.newInstance(1);
            }
            if(position == 2){
                return endGame.newInstance(2);
            }
                    return Teleop.newInstance(1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Auton";
                case 1:
                    return "Teleop";
                case 2:
                    return "EndGame";
            }
            return null;
        }
    }

