package default_xyz.playground.drag_and_drop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import default_xyz.playground.R;

public class DragAndDropActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<String> items = getSampleList(20);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerView, items);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<String> getSampleList(int count) {
        String sampleText = "Item ";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String itemText = sampleText + i;
            list.add(itemText);
        }
        return list;
    }
}
