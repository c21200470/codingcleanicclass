package a21200470.mycodingcleanic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import a21200470.mycodingcleanic.controller.MainActivity;

public class DisplayMessageActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(new FoodInfo(R.drawable.strawberry, "5,000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.bread, "4,600원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.noodle, "4,000원"));

        MyAdapter myAdapter = new MyAdapter(foodInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.ResultTextView);
        textView.setText(message);

    }
}
