package com.example.hesap_makinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.hesapEkrani);
        editText.setShowSoftInputOnFocus(false);
    }


    public void Yazdir(View view){

        switch (view.getId()){


            case R.id.sifirla:editText.setText("");break;
            case R.id.sil:Sil();break;
            case R.id.bol:EkraniGuncelle("/");break;
            case R.id.carp:EkraniGuncelle("*");break;
            case R.id.cikar:EkraniGuncelle("-");break;
            case R.id.topla:EkraniGuncelle("+");break;
            case R.id.numara0:EkraniGuncelle("0");break;
            case R.id.numara1:EkraniGuncelle("1");break;
            case R.id.numara2:EkraniGuncelle("2");break;
            case R.id.numara3:EkraniGuncelle("3");break;
            case R.id.numara4:EkraniGuncelle("4");break;
            case R.id.numara5:EkraniGuncelle("5");break;
            case R.id.numara6:EkraniGuncelle("6");break;
            case R.id.numara7:EkraniGuncelle("7");break;
            case R.id.numara8:EkraniGuncelle("8");break;
            case R.id.numara9:EkraniGuncelle("9");break;
            case R.id.nokta:EkraniGuncelle(".");break;
            case R.id.esittir:IslemYap();break;



//              21+3*9


        }



    }

    public void Sil(){

        int imlecPos=editText.getSelectionStart();
        if(imlecPos>0){
            String eskiDeger=editText.getText().toString();
            String sagTaraf=eskiDeger.substring(0,imlecPos-1);
            String solTaraf=eskiDeger.substring(imlecPos);
            String yeniDeger=sagTaraf+solTaraf;
            editText.setText(yeniDeger);

        }

    }
    public void EkraniGuncelle(String deger){

        int imlecPos=editText.getSelectionStart();
        String eskiDeger=editText.getText().toString();
        String sagTaraf=eskiDeger.substring(0,imlecPos);
        String solTaraf=eskiDeger.substring(imlecPos);
        String yeniDeger=sagTaraf+deger+solTaraf;
        editText.setText(yeniDeger);
        editText.setSelection(imlecPos+1);

    }
    public void IslemYap(){

        String deger=editText.getText().toString();
        Expression ifade=new Expression(deger);
        String result =String.valueOf(ifade.calculate()).toString();
        editText.setText(result);
        editText.setSelection(result.length());
    }


}