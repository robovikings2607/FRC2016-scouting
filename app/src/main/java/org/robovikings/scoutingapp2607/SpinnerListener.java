package org.robovikings.scoutingapp2607;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Tom on 2/27/2016.
 */
public class SpinnerListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Data.position = parent.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Data.position = "Blue 1";
    }
}
