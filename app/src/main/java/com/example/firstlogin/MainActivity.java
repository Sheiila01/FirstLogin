package com.example.firstlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mycontext = (TextView) findViewById(R.id.textTop);
        registerForContextMenu(mycontext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);

    }


    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        switch (item.getItemId()) {

            case R.id.item1:
                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

                Snackbar snackbar = Snackbar
                        .make(mLayout, "fancy a Snack while you refresh", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
                return true;
            case R.id.item2:
                final ConstraintLayout mLayout1 = findViewById(R.id.myMainConstraint);
                Snackbar snackbar2 = Snackbar
                        .make(mLayout1, "Downloading item...", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar3 = Snackbar.make(mLayout1, "Action is restored! ", Snackbar.LENGTH_SHORT);
                                snackbar3.show();
                            }
                        });
                snackbar2.show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id == R.id.item3) {
            Toast toast = Toast.makeText(this, "going APPBAR SETTINGS", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item4) {
            Toast toast = Toast.makeText(this, "going APPBAR FACE", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item5) {
            Toast toast = Toast.makeText(this, "About us ", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.item6) {
            Toast toast = Toast.makeText(this, "Sign out ", Toast.LENGTH_LONG);
            toast.show();
        }

            return super.onOptionsItemSelected(item);
        }


}