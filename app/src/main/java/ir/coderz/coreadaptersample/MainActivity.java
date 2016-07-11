package ir.coderz.coreadaptersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import ir.coderz.coreadapter.CoreAdapter;
import ir.coderz.coreadaptersample.viewtypes.AnotherHolder;
import ir.coderz.coreadaptersample.viewtypes.AnotherItem;
import ir.coderz.coreadaptersample.viewtypes.TextHolder;
import ir.coderz.coreadaptersample.viewtypes.TextItem;

public class MainActivity extends AppCompatActivity implements AnotherItem.OnItemClickListener {

    RecyclerView recycler;
    CoreAdapter multiAdapter = new CoreAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        multiAdapter.putViewType(R.layout.text_item, TextHolder.class);
        multiAdapter.putViewType(R.layout.another_layout, AnotherHolder.class);

        recycler.setAdapter(multiAdapter);


        int x = 30;
        for (int i = 0; i < x; i++) {
            if (i % 3 == 0) {
                multiAdapter.addItem(i, new TextItem());
            } else {
                AnotherItem anotherItem = new AnotherItem(new AnotherModel(i + "", "item " + i));
                anotherItem.setOnItemClickListener(this);
                multiAdapter.addItem(i, anotherItem);

            }
        }
    }

    @Override
    public void itemClick(View v, AnotherModel data) {
        Toast.makeText(MainActivity.this, data.message, Toast.LENGTH_SHORT).show();
    }
}
