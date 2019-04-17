package ge.neso.info08.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ge.neso.info08.R;
import ge.neso.info08.models.TransportScheduleDetailsItem;
import ge.neso.info08.models.TransportScheduleItem;

public class TransportScheduleDetailsItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private List<TransportScheduleDetailsItem.Schedule> items;

    public TransportScheduleDetailsItemAdapter(Context context) {
        this.context = context;
    }

    public List<TransportScheduleDetailsItem.Schedule> getItems() {
        return items;
    }

    public void setItems(List<TransportScheduleDetailsItem.Schedule> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TransportScheduleDetailsItem.Schedule schItem = items.get(position);

        TextView transportScheduleDetails = holder.itemView.findViewById(R.id.transport_schedule_details);

        if (schItem != null) {
            String details = schItem.getName();
            transportScheduleDetails.setText(details);
        }


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.content_transportation_schedule_details_item, parent, false);

        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {
        };

        return viewHolder;

    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

}
