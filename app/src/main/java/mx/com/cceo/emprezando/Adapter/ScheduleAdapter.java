package mx.com.cceo.emprezando.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Linker.ProgramClickListener;
import mx.com.cceo.emprezando.Model.ActivityItem;
import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ScheduleAdapter extends  RecyclerView.Adapter<ScheduleAdapter.ViewHolderProgram>{

    public ArrayList<ActivityItem> dataSet;
    private Context context;

    public ScheduleAdapter(ArrayList<ActivityItem> dataSet, Context context)
    {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public ViewHolderProgram onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_schedule, parent, false);
        ViewHolderProgram vH = new ViewHolderProgram(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(final ViewHolderProgram holder, final int position) {

        holder.textActivity.setText(dataSet.get(position).getActivity());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public static class ViewHolderProgram extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textActivity;


        public ViewHolderProgram(View v) {
            super(v);
            textActivity = (TextView) v.findViewById(R.id.item_schedule_thing);

        }
    }
}
