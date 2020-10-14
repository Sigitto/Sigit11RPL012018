package com.example.sigit11rpl012018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText user, password;
    Button btnlogin;
    TextView link_regist;
//    private static String URL_LOGIN = "http://192.168.100.9/android_register_login/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);
        link_regist = findViewById(R.id.tvregist);
        link_regist.setPaintFlags(link_regist.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUser = user.getText().toString();
                String mPassword = password.getText().toString();
//                String mUser = email.getText().toString().trim();
//                String mPass = password.getText().toString().trim();
//
//                if (!mUser.isEmpty() || mPass.isEmpty()) {
//                    Login(mUser, mPass);
//                } else {
//                    email.setError("Please insert email");
//                    password.setError("Please insert password");
//                }
                if (mUser.equalsIgnoreCase("salah") && mPassword.equalsIgnoreCase("salah")){
                    Toast.makeText(Login.this,"Anda salah", Toast.LENGTH_LONG).show();
                }else {
                    editor = pref.edit();
                    editor.putString("username", mUser);
                    editor.putString("status", "login");
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }

            }
        });



        link_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });


    }

//    private void Login(final String email, final String password) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            String success = jsonObject.getString("success");
//                            JSONArray jsonArray = jsonObject.getJSONArray("login");
//
//                            if (success.equals("1")) {
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    JSONObject object = jsonArray.getJSONObject(i);
//
//                                    String name = object.getString("name").trim();
//                                    String email = object.getString("email").trim();
//
//                                    editor = pref.edit();
//                                    editor.putString("email", email);
//                                    editor.putString("status", "login");
//                                    editor.apply();
//
//                                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
//                                    finish();
//                                }
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(Login.this, "Error " +e.toString(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Login.this, "Error " +error.toString(), Toast.LENGTH_LONG).show();
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//
//    }
}