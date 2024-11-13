package com.example.pttbac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edita,editb,editc,editketqua;
    Button btntieptuc,btngia,btnthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edita=findViewById(R.id.editTextText);
        editb=findViewById(R.id.editTextText2);
        editc=findViewById(R.id.editTextText3);
        editketqua=findViewById(R.id.editTextText4);
        btntieptuc=findViewById(R.id.btntieptuc);
        btngia=findViewById(R.id.btnGiai);
        btnthoat=findViewById(R.id.btnCacel);


        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder Dialog = new AlertDialog.Builder(MainActivity.this);
                Dialog.setTitle("Thông báo!");
                Dialog.setMessage("Bạn có muốn thoát chương trình không?");
                Dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        finish();
                    }
                });
                Dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bạn đã chọn No", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface DialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Bạn đã chọn Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                Dialog.create();
                Dialog.show();
            }
        });


        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editc.setText("");
                editb.setText("");
                editketqua.setText("");
                edita.requestFocus();
            }
        });

        btngia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(edita.getText() + "");
                double b = Double.parseDouble(editb.getText() + "");
                double c = Double.parseDouble(editc.getText() + "");

                double delta=b*b-4*a*c;
                 if(delta>0){
                     double x1=(-b+Math.sqrt(delta))/(2*a);
                     double x2=(-b-Math.sqrt(delta))/(2*a);
                     editketqua.setText("Phuong trinh co 2 nghiem phan biet:"+x1+"\nnnn"+x2);
                 } else if (delta==0) {
                     double x=-b/(2*a);
                     editketqua.setText("Phuong trinh co 1 nghiem kep"+x);
                 }else {
                     editketqua.setText("Phuong trinh vo nghiem ");
                 }
            }
        });


    }
}