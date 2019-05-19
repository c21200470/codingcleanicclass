package a21200470.mycodingcleanic.Instagram.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import a21200470.mycodingcleanic.R;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();
    protected Context context;
    private Toolbar toolbar;

    public Toolbar getToolbar() {
        return toolbar;
    }

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        context = this;
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) initializeToolbar(toolbar);
    }

    protected void initializeToolbar(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}