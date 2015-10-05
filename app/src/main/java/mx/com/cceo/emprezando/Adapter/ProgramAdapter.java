package mx.com.cceo.emprezando.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ProgramAdapter extends  RecyclerView.Adapter<ProgramAdapter.ViewHolderProgram> {

    public ArrayList<ConferenceItem> dataSet;

    public ProgramAdapter(ArrayList<ConferenceItem> dataSet)
    {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolderProgram onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_program, parent, false);
        ViewHolderProgram vH = new ViewHolderProgram(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolderProgram holder, int position) {

        holder.textDay.setText(dataSet.get(position).getDay());
        holder.textMonth.setText(dataSet.get(position).getMonth());
        holder.textTitle.setText(dataSet.get(position).getTitle());
        holder.textSpeaker.setText(dataSet.get(position).getSpeaker());
        holder.textTime.setText(dataSet.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolderProgram extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textDay;
        public TextView textMonth;
        public TextView textTitle;
        public TextView textSpeaker;
        public TextView textTime;


        public ViewHolderProgram(View v) {
            super(v);
            textDay = (TextView) v.findViewById(R.id.item_program_day);
            textMonth = (TextView) v.findViewById(R.id.item_program_month);
            textTitle = (TextView) v.findViewById(R.id.item_program_title);
            textSpeaker = (TextView) v.findViewById(R.id.item_program_speaker);
            textTime = (TextView) v.findViewById(R.id.item_program_time);
        }
    }
}