package com.github.stephenvinouze.shapeviewsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.github.stephenvinouze.shapeviewsample.R;
import com.github.stephenvinouze.shapeviewsample.fragments.HalfCircleEdgeFragment;
import com.github.stephenvinouze.shapeviewsample.fragments.TicketFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayHalfCircleEdgeFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shape_half_circle_action:
                displayHalfCircleEdgeFragment();
                break;

            case R.id.shape_ticket_action:
                displayTicketFragment();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayHalfCircleEdgeFragment() {
        setTitle(getString(R.string.shape_half_circle));
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HalfCircleEdgeFragment()).commit();
    }

    private void displayTicketFragment() {
        setTitle(getString(R.string.shape_ticket));
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new TicketFragment()).commit();
    }

}
