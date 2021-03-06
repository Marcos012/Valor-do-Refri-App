package br.org.fundatec.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class DetailActivity extends AppCompatActivity {

    private EditText mValor;
    private EditText mQuantidade;
    private TextView mValorLitro;
    private Button mBtnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mValor = (EditText) findViewById(R.id.valor);
        mQuantidade = (EditText) findViewById(R.id.quantidade);
        mValorLitro = (TextView) findViewById(R.id.valorLitro);
        mBtnCalcular = (Button) findViewById(R.id.btnCalcular);

        mBtnCalcular.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(mValor.getText().toString().isEmpty()) {
                     YoYo.with(Techniques.Shake).playOn(mValor);
                 } else if(mQuantidade.getText().toString().isEmpty()){
                     YoYo.with(Techniques.Shake).playOn(mQuantidade);
                 } else{
                     Float valor = Float.valueOf(mValor.getText().toString());
                     Float quantidade = Float.valueOf(mQuantidade.getText().toString());
                     Float vlPorLitro = (valor * 1000) / quantidade;
                     mValorLitro.setText("O valor por litro é R$ " + String.format("%.2f", vlPorLitro));
                     Log.e("fundatec", "Clicou no botao calcular");
                 }
                 }
            });
    }
}
