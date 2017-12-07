package br.gov.to.sefaz.apps.esportscalendar;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaTimes extends AppCompatActivity {

    Button botao = null;
    ListView listView = null;
    ArrayList<Time> times;
    ArrayList<String> consulta;
    AdaptadorTime adaptador;
    SwipeRefreshLayout mSwipeRefreshLayout;
    TimeDAO banco = new TimeDAO(this, "bancoESports", 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_times);

        botao = (Button)findViewById(R.id.button6);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swiperefresh);

        buscaTimes();

        adaptador = new AdaptadorTime(times, this);

        listView = (ListView) findViewById(R.id.lista_times);
        listView.setAdapter(adaptador);
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        buscaTimes();
                        adaptador = new AdaptadorTime(times, getBaseContext());
                        listView.setAdapter(adaptador);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
        );
    }

    public void buscaTimes(){
        consulta = banco.listaTimes();
        times = new ArrayList<>();

        for (String item : consulta) {
            String[] itens = item.split(" ");
            Time time = new Time();
            time.setNome(itens[0]);
            time.setCdgTime(itens[1]);
            times.add(time);
        }
    }

    public void novoTime(View v){
        Intent intent = new Intent(this, TelaNovoTime.class);
        startActivity(intent);
    }

}
