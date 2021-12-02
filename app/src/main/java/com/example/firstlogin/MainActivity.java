package com.example.firstlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;

import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WebView mycontext = (WebView) findViewById(R.id.textTap);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //La vista dentro es un webview con permiso para zoom
        miVisorWeb = (WebView) findViewById(R.id.vista);

        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thiscatdoesnotexist.com/");


    }

    public void showAlertDialogButtonClicked(MainActivity activity_main) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.candado);
        builder.setCancelable(false);


//        // un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {


            Toast toast0 = Toast.makeText(MainActivity.this, "Imagen actualizada", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };


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
        int id = item.getItemId();
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