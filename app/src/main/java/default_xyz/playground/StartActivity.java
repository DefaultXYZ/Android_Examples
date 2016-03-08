package default_xyz.playground;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import default_xyz.playground.calendarview.CalendarActivity;
import default_xyz.playground.listview.ListViewActivity;
import default_xyz.playground.rest.RestActivity;
import default_xyz.playground.weekview.WeekViewActivity;

public class StartActivity extends AppCompatActivity {
    private String[] list;
    private DrawerLayout drawerLayout;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        list = getResources().getStringArray(R.array.menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list, list));
        listView.setOnItemClickListener(new DrawerItemClickListener());
    }

    class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    startActivityByClass(CalendarActivity.class);
                    break;
                case 1:
                    startActivityByClass(WeekViewActivity.class);
                    break;
                case 2:
                    startActivityByClass(RestActivity.class);
                    break;
                case 3:
                    startActivityByClass(ListViewActivity.class);
                    break;
            }
            listView.clearChoices();
        }

        private void startActivityByClass(Class<? extends AppCompatActivity> activityClass) {
            Intent intent = new Intent(getApplicationContext(), activityClass);
            startActivity(intent);
        }
    }
}
