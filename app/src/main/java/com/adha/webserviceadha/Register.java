package com.adha.webserviceadha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    Button btnRegister;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //panggil id
        btnRegister = findViewById(R.id.btn_register);
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);

        //tombol klik Login
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    private void Register() {
        String url = "https://adha-belajar.000webhostapp.com/webservice/register.php"; //alamat web server
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Toast.makeText(getApplicationContext(), "Register Sukses, silahkan Login.!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Username dan password tidak boleh kosong.!", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", edtUsername.getText().toString().trim());
                params.put("password", edtPassword.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void masukLogin(View view) {
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
