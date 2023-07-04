package com.example.theactual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        layout = findViewById(R.id.container);
        
        buildDialog();
        
        add.setOnClickListener(new View.OnClickListener() {
            //Esto es una clase anonima que pex jajajaja
            @Override
            public void onClick(View view) {
                dialog.show();
            }
            //Este llama la ventanita que tengo que dice enter name
        });
    }

    private void buildDialog() {
        //todavia no se que hace esto jajajaja
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        EditText name = view.findViewById(R.id.nameEdit);

        Builder.setView(view);
        Builder.setTitle("Enter Name prieto")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addCard(name.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        dialog = Builder.create();
    }

    private void addCard(String name) {
        //here it adds atributes
        View view = getLayoutInflater().inflate(R.layout.car, null);
        TextView nameView = view.findViewById(R.id.name);
        Button delete = view.findViewById(R.id.delete);


        nameView.setText(name);


        delete.setOnClickListener(v -> {

            ((Button)v).setText("CLICK");
            //funcionaba con 2 get parents XD  || this one calls upon the like
            //((ViewGroup) v.getParent().getParent().getParent().getParent()).removeView((ViewGroup) v.getParent().getParent().getParent());
            ((ViewGroup) v.getParent().getParent().getParent().getParent().getParent()).removeView((ViewGroup) v.getParent().getParent().getParent().getParent());
        });

        layout.addView(view);
    }
}