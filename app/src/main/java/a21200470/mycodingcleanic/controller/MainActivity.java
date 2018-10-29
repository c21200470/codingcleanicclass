package a21200470.mycodingcleanic.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import a21200470.mycodingcleanic.DisplayMessageActivity;
import a21200470.mycodingcleanic.ItemAdapter;
import a21200470.mycodingcleanic.R;
import a21200470.mycodingcleanic.api.Client;
import a21200470.mycodingcleanic.api.Service;
import a21200470.mycodingcleanic.model.Item;
import a21200470.mycodingcleanic.model.ItemResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button bt;
    public static final String EXTRA_MESSAGE = "This is it.";
    Button SecondAvtiviyButton;
    Toolbar toolbar;

    TextView Disconnected;
    ProgressDialog pd;
    private RecyclerView recyclerView;
    private Item item;
    private SwipeRefreshLayout swipeContainer;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {

            tv.setText("Bye World!");
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        swipeContainer = findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
                Toast.makeText(MainActivity.this, "Github Users Refreshed", Toast.LENGTH_SHORT).show();
            }
        });
        tv = findViewById(R.id.txt);
        bt = findViewById(R.id.button);
        SecondAvtiviyButton = findViewById(R.id.secondactivitybutton);
        bt.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }
    //List<ContributorModel> result = call.execute().body();

    private void initViews() {
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching GIthub users");
        pd.setCancelable(false);
        pd.show();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON() {
        Disconnected = findViewById(R.id.disconnetced);
        try {
            Client Client = new Client();
            Service apiService =
                    a21200470.mycodingcleanic.api.Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    swipeContainer.setRefreshing(false);
                    pd.hide();
                }


                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, " Error Fetching Data", Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}


