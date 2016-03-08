package default_xyz.playground.weekview;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.telerik.widget.calendar.CalendarCell;
import com.telerik.widget.calendar.CalendarDisplayMode;
import com.telerik.widget.calendar.CalendarSelectionMode;
import com.telerik.widget.calendar.EventsManager;
import com.telerik.widget.calendar.RadCalendarView;
import com.telerik.widget.calendar.events.Event;
import com.telerik.widget.calendar.events.EventsDisplayMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import default_xyz.playground.R;
import default_xyz.playground.weekview.view.Base;

public class WeekViewActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        linearLayout = (LinearLayout) findViewById(R.id.week_view);
        //Base base = new Base(getApplicationContext(), linearLayout);
        setRadCalendar();
    }

    private void setRadCalendar() {
        final RadCalendarView radCalendarView = (RadCalendarView) findViewById(R.id.radCalendar);
        radCalendarView.setDisplayMode(CalendarDisplayMode.Week);
        radCalendarView.setSelectionMode(CalendarSelectionMode.Single);
        radCalendarView.getEventAdapter().setEvents(getEvents());

        radCalendarView.setOnCellClickListener(new RadCalendarView.OnCellClickListener() {
            @Override
            public void onCellClick(CalendarCell calendarCell) {

            }
        });
    }

    private List<Event> getEvents() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        long startEvent = calendar.getTimeInMillis();
        calendar.add(Calendar.HOUR, 5);
        long endEvent = calendar.getTimeInMillis();
        Event event = new Event("Task 1", startEvent, endEvent);
        List<Event> events = new ArrayList<>();
        events.add(event);
        return events;
    }
}
