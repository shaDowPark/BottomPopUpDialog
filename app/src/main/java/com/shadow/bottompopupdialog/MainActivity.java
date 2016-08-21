package com.shadow.bottompopupdialog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                     BottomPopUpDialog dialog = new BottomPopUpDialog()
                            .setDialogData(getResources().getStringArray(R.array.popup_array))
                            .setItemTextColor(2, R.color.colorAccent)
                            .setItemTextColor(4, R.color.colorAccent)
                            .setCallBackDismiss(true)
                            .setItemOnListener(new BottomPopUpDialog.BottomPopDialogOnClickListener() {
                                @Override
                                public void onDialogClick(String tag) {
                                    Snackbar.make(view, tag, Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            });
                    dialog.show(getSupportFragmentManager(), "tag");

                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
