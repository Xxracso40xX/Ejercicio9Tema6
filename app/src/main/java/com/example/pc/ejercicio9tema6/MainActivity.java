package com.example.pc.ejercicio9tema6;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final int GIRO_IZQ = 2;
    static final int GIRO_DER = 1;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imageView);
        registerForContextMenu(imagen);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }
    private void rotarImagen(View view, int rotacion) {
        RotateAnimation animation = null;
        int inicio=0;
        int fin=0;
        if(rotacion==GIRO_DER){inicio=0;fin=360;}
        else{ inicio=360;fin=0;}
        animation = new RotateAnimation(inicio, fin,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(animation);
    }
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CtxOpc1:
                rotarImagen(imagen, GIRO_IZQ);
                break;
            case R.id.CtxOpc2:
                rotarImagen(imagen, GIRO_DER);
                break;
        }
        return true;
    }
}
