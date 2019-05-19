package a21200470.mycodingcleanic.Instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a21200470.mycodingcleanic.R;
import a21200470.mycodingcleanic.Instagram.base.BaseActivity;

public class Instagram_Splash extends AppCompatActivity {

    private Button btnSplash;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_instagram__splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram__splash);
        findView();
        setButton();
    }


    private void findView() {
        btnSplash = findViewById(R.id.btn_splash);
    }

    private void setButton() {
        btnSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Instagram_main.class)
                        .putExtra(Instagram_main.NAME_KEY, "Coding Cleanic");
                startActivity(intent);
                finish();
            }
        });
    }

}
