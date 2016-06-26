package default_xyz.playground.drag_and_drop;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import default_xyz.playground.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private List<String> items;

    public RecyclerAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
        holder.cardView.setTag("Item " + position);
        holder.cardView.setOnTouchListener(new DragStartListener());
        holder.cardView.setOnDragListener(new ButtonDragListener(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class ButtonDragListener implements View.OnDragListener {
        int position;

        public ButtonDragListener(int position) {
            this.position = position;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    View view = (View) event.getLocalState();
                    CardView dropTarget = (CardView) v;
                    TextView dropTargetText = (TextView) dropTarget.findViewById(R.id.item_text);
                    String targetText = dropTargetText.getText().toString();
                    int targetPos = getTextPos(targetText);

                    CardView dropped = (CardView) view;
                    TextView droppedTextView = (TextView) dropped.findViewById(R.id.item_text);
                    String droppedText = droppedTextView.getText().toString();
                    int droppedPos = getTextPos(droppedText);

                    items.remove(targetPos);
                    items.add(targetPos, droppedText);

                    items.remove(droppedPos);
                    items.add(droppedPos, targetText);

                    notifyDataSetChanged();
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    break;

                default:
                    break;
            }
            return true;
        }
    }

    private int getTextPos(String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            textView = (TextView) cardView.findViewById(R.id.item_text);
        }
    }
}
