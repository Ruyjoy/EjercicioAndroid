package com.joseluis.ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker editFecha;
    Button buttonNext;
    AppCompatEditText editName, editNum, editMail, editDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName  = findViewById(R.id.editName);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        editFecha = (DatePicker) findViewById(R.id.datePicker1);
        editNum  = findViewById(R.id.editNum);
        editMail  = findViewById(R.id.editMail);
        editDes  = findViewById(R.id.editDes);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                intent.putExtra("Nombre", editName.getText().toString());
                intent.putExtra("FechaNacimiento", getDateFromDatePicker(editFecha));
                intent.putExtra("Telefono", editNum.getText().toString());
                intent.putExtra("Mail", editMail.getText().toString());
                intent.putExtra("Descripcion", editDes.getText().toString());
                startActivity(intent);
            }
        });

    }
    public static String getDateFromDatePicker(DatePicker datePicker){
        Integer day = datePicker.getDayOfMonth();
        Integer month = datePicker.getMonth();
        Integer year =  datePicker.getYear();

        String fecha = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);

        return fecha;
    }
}