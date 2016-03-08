package default_xyz.playground.weekview.view;

import android.content.Context;
import android.widget.LinearLayout;

import default_xyz.playground.R;


/**
 * Base of week view
 * Created by yevhenii_ishchenko on 19/02/16.
 */
public class Base {

    private Context context;
    private LinearLayout parent;

    public Base(Context context, LinearLayout parent) {
        this.context = context;
        this.parent = parent;
        drawComponents();
    }

    public void drawComponents() {
        String[] weekdays = context.getResources().getStringArray(R.array.weekdays);
        for (String weekday : weekdays) {
            Day day = new Day(context, weekday, parent);
            day.drawDay();
        }
    }
}
