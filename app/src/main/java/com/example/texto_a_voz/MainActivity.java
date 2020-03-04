package com.example.texto_a_voz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
       //variables para instanciar el boton
       private Button hablarAhoraBoton;
       private EditText editText;
       TTSManager ttsManager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttsManager=new TTSManager();
        ttsManager.init(this);

        editText = findViewById(R.id.input_text);
        hablarAhoraBoton = findViewById(R.id.speak_now);

        //aqui es donde mandaremos todas las palabras para que las valla traduciendo
        hablarAhoraBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();
                ttsManager.initQueue(text);
            }
        });
    }

    //el metodo onDestroy es para destruir la aplicacion y no siga consumiendo recurso
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
