package br.gov.to.sefaz.apps.esportscalendar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Arthur on 19/10/2017.
 */
public class AdaptadorTime extends ArrayAdapter<Time> {
    ArrayList<Time> lista = new ArrayList<>();
    TimeDAO banco = new TimeDAO(getContext(), "bancoESports", 1);
    ImageButton editBtn, deleteBtn = null;

    Context contexto;

    AdaptadorTime(ArrayList<Time> lista, Context contexto){
        super(contexto, 0, lista);
        this.lista = lista;
        this.contexto = contexto;
    }

    @Nullable
    @Override
    public Time getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(final int posicao, View reciclado, ViewGroup pai) {
        if (reciclado == null){
            //Situação em que não há células disponíveis
            reciclado = LayoutInflater.from(contexto).inflate(R.layout.celula_time, pai, false);
        }
        final Time copia = getItem(posicao);

        TextView nome = (TextView) reciclado.findViewById(R.id.textView7);
        nome.setText(copia.getNome());

        editBtn = (ImageButton)reciclado.findViewById(R.id.imageButton);
        deleteBtn = (ImageButton)reciclado.findViewById(R.id.imageButton2);

        editBtn.setImageResource(R.mipmap.edit);
        deleteBtn.setImageResource(R.mipmap.delete);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                banco.removeTime(copia.getCdgTime());
                lista.remove(posicao); //or some other task
                notifyDataSetChanged();
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                Bundle bundle = new Bundle();
                bundle.putString("nome", lista.get(posicao).getNome());
                bundle.putString("cdgTime", lista.get(posicao).getCdgTime());
                Intent intent = new Intent(getContext(), TelaEditaTime.class);
                intent.putExtras(bundle);
                getContext().startActivity(intent);
            }
        });


        return reciclado;
    }
}
