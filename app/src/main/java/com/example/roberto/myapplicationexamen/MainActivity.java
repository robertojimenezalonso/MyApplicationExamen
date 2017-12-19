package com.example.roberto.myapplicationexamen;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button  BotonEntrar, BotonEmpezar;
    EditText EditoEmail, EditoPsw;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotonEntrar = (Button) findViewById(R.id.botonLoging);
        BotonEmpezar = (Button) findViewById(R.id.botonRegistro);
        EditoEmail = (EditText) findViewById(R.id.editEmail);
        EditoPsw = (EditText) findViewById(R.id.editContrasena);

        BotonEntrar.setOnClickListener(this);
        BotonEmpezar.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user =firebaseAuth.getCurrentUser();
                if (user != null){

                    Log.i("SESION", "sesion iniciada con email: "+ user.getEmail());

                }else{

                    Log.i("SESION","sesion cerrada");
                }
            }
        };

    }

    private void registrar(String email, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESION", "usuario creado correctamente");
                }else{
                    Log.e("SESION", task.getException().getMessage()+"");
                }

            }
        });
    }
    private void iniciarSesion(String email, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESION", "sesion iniciada correctamente");
                }else{
                    Log.e("SESION", task.getException().getMessage()+"");
                }

            }
        });;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonLoging:
                String emailInicio = EditoEmail.getText().toString();
                String passInicio = EditoPsw.getText().toString();
                iniciarSesion(emailInicio, passInicio);
                break;
            case R.id.botonRegistro:
                String emailReg = EditoEmail.getText().toString();
                String passReg = EditoPsw.getText().toString();
                registrar(emailReg, passReg);
        }
    }

    //metodos onStart-onStop

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
