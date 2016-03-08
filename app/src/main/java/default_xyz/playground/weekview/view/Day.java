package default_xyz.playground.weekview.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * One day in week view
 * Created by yevhenii_ishchenko on 19/02/16.
 */
public class Day {
    private Context context;
    private ViewGroup.LayoutParams layoutParams;
    private LinearLayout parent;
    private String text;

    public Day(Context context, String text, LinearLayout parent) {
        this.context = context;
        this.text = text;
        this.parent = parent;
        setupLayoutParams();
    }

    public void drawDay() {
        LinearLayout dayLayout = new LinearLayout(context);
        dayLayout.setLayoutParams(layoutParams);
        TextView dayText = new TextView(context);
        dayText.setText(text);
        dayLayout.addView(dayText);
        TextView taskText = new TextView(context);
        taskText.setText("Test Task");
        dayLayout.addView(taskText);
        parent.addView(dayLayout);
    }

    private void setupLayoutParams() {
        layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
