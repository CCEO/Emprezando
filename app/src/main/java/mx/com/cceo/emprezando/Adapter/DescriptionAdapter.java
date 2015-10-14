package mx.com.cceo.emprezando.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Linker.ProgramClickListener;
import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.Model.DescriptionItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class DescriptionAdapter extends  RecyclerView.Adapter<DescriptionAdapter.ViewHolderDescription>{

    public ArrayList<DescriptionItem> dataSet;

    public DescriptionAdapter(ArrayList<DescriptionItem> dataSet)
    {
        this.dataSet = dataSet;

    }

    @Override
    public ViewHolderDescription onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_description, parent, false);
        ViewHolderDescription vH = new ViewHolderDescription(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolderDescription holder, final int position) {

        holder.textTitle.setText(dataSet.get(position).getTitle());
        holder.textSpeaker.setText(dataSet.get(position).getSpeaker());
        holder.textAbout.setText(dataSet.get(position).getAbout());


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public static class ViewHolderDescription extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textTitle;
        public TextView textSpeaker;
        public TextView textAbout;

        public ViewHolderDescription(View v) {
            super(v);
            textTitle = (TextView) v.findViewById(R.id.description_name);
            textSpeaker = (TextView) v.findViewById(R.id.description_speaker);
            textAbout = (TextView) v.findViewById(R.id.description_about);
        }
    }
}
