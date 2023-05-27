package com.ugb.urban_shop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroData extends AppCompatActivity {
    String Title="Registro de Usuarios";
    EditText Reusuario, Repassw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_data);
        this.setTitle(Title);
        Reusuario = (EditText) findViewById(R.id.Rusuario);
        Repassw = (EditText) findViewById(R.id.Rpassw);
    }
    public void registrarUser(View view){
        DBUSER admin = new DBUSER(this, "Ropas", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String Username = Reusuario.getText().toString();
        String Passuser = Repassw.getText().toString();
        ContentValues values = new ContentValues();
        values.put("username",Username);
        values.put("clave_user",Passuser);
        db.insert("userstable",null, values);
        db.close();
        Toast ToastMens=Toast.makeText(this, "Usuario registrado",Toast.LENGTH_SHORT);
        ToastMens.show();
        Intent intent=new Intent(this, login2.class);
        startActivity(intent);

    }

}