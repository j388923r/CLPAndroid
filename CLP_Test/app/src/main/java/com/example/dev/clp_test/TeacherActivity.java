package com.example.dev.clp_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.dev.clp_test.R;
import com.example.dev.clp_test.views.PreviewView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;


public class TeacherActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        ListView previewList=(ListView)findViewById(R.id.previewList);

        ArrayList<PreviewView> previews = new ArrayList<PreviewView>();

        previews.add((PreviewView)findViewById(R.id.previewview));
        previews.add((PreviewView)findViewById(R.id.previewview));
        previews.add((PreviewView)findViewById(R.id.previewview));
        previews.add((PreviewView)findViewById(R.id.previewview));
        previews.add((PreviewView)findViewById(R.id.previewview));

        ArrayAdapter<PreviewView> adapter = new ArrayAdapter<PreviewView>(this, com.example.dev.clp_test.R.layout.preview_list, com.example.dev.clp_test.R.id.placeholder, previews);
        previewList.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher, menu);
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
