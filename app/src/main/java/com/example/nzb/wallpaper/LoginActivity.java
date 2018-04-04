package com.example.nzb.wallpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nzb.wallpaper.bmob.User;
import com.example.nzb.wallpaper.user.LoginView;
import com.example.nzb.wallpaper.user.UserPresenter;
import com.example.nzb.wallpaper.user.UserPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView{

    EditText usernameEt,passwordEt;
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        presenter = new UserPresenterImpl(this);
    }

    private void initViews() {
        usernameEt =(EditText) findViewById(R.id.username);
        passwordEt = (EditText)findViewById(R.id.password);
    }

    public void login(View view){
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();

        presenter.login(username,password);
    }

    @Override
    public void setUsernameError() {
        usernameEt.setError("username error");
    }

    @Override
    public void setPasswordError() {
        passwordEt.setError("password error");
    }

    @Override
    public void fail() {
        Toast.makeText(LoginActivity.this,"fails",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(User user) {
        Toast.makeText(LoginActivity.this, "user name"+user.getName(), Toast.LENGTH_SHORT).show();
    }
}
