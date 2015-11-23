package com.sb.saladbar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SaladBuilderActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbed_ingredients);
        findViewById(R.id.salad).setOnDragListener(new MyDragListener());
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec("Bases").setIndicator("Bases", null),
                BaseFragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Ingredients").setIndicator("Ingredients", null),
                ToppingFragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Premiums").setIndicator("Premiums", null),
                PremiumFragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("Dressings").setIndicator("Dressings", null),
                PremiumFragmentTab.class, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    // TODO - Update View:v to incorporate the new ingredient
                    // that was dragged into v.
                    // Data from the new dragged ingredient can be
                    // accessed from the DragEvent: event.
                    // -- still need to figure exactly how to do this.
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }
}
