package default_xyz.playground.calendarview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import default_xyz.playground.R;

public class CalendarActivity extends AppCompatActivity {

    private double lastX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MonthViewFragment())
                .commit();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                return true;
            case MotionEvent.ACTION_UP:
                double x = event.getX();
                if(x - lastX < 0) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new WeekViewFragment())
                            .commit();
                } else {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new MonthViewFragment())
                            .commit();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
