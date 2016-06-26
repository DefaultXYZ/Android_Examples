package default_xyz.playground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import default_xyz.playground.calendarview.CalendarActivity;
import default_xyz.playground.drag_and_drop.DragAndDropActivity;
import default_xyz.playground.listview.ListViewActivity;
import default_xyz.playground.rest.RestActivity;
import default_xyz.playground.weekview.WeekViewActivity;

public class StartActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        String[] list = getResources().getStringArray(R.array.menu);
        listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list, list));
        listView.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    openActivity(CalendarActivity.class);
                    break;
                case 1:
                    openActivity(WeekViewActivity.class);
                    break;
                case 2:
                    openActivity(RestActivity.class);
                    break;
                case 3:
                    openActivity(ListViewActivity.class);
                    break;
                case 4:
                    openActivity(DragAndDropActivity.class);
                    break;
            }
            listView.clearChoices();
        }

        private void openActivity(Class<? extends AppCompatActivity> activityClass) {
            Context applicationContext = getApplicationContext();
            Intent intent = new Intent(applicationContext, activityClass);
            startActivity(intent);
        }
    }
}
