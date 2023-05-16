package br.com.pdm.unemat.homematch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    public static final String MYPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button registerButton = findViewById(R.id.registerButton);
        Button loginButton = findViewById(R.id.loginButton);

        EditText email = findViewById(R.id.emailEditText);
        EditText senha = findViewById(R.id.senhaEditText);

        SharedPreferences sharedPreferences = getSharedPreferences(MYPREFERENCES, 0);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, ?> values = sharedPreferences.getAll();

                String nomeLocal = values.get("nome").toString();
                String emailLocal = values.get("email").toString();
                String senhaLocal = values.get("senha").toString();

                if ((email.getText().toString().equals(emailLocal)) && (senha.getText().toString().equals(senhaLocal))) {
                    Toast.makeText(LoginActivity.this, "Logado com sucesso!!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Usuário ou senha incorreto!!!" + ((emailLocal)), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}