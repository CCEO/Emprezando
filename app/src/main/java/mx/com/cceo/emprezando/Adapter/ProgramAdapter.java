package mx.com.cceo.emprezando.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import mx.com.cceo.emprezando.Linker.ProgramClickListener;
import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ProgramAdapter extends  RecyclerView.Adapter<ProgramAdapter.ViewHolderProgram>{

    public ArrayList<ConferenceItem> dataSet;
    private ProgramClickListener clickListener;
    private Context context;

    public ProgramAdapter(ArrayList<ConferenceItem> dataSet, ProgramClickListener clickListener, Context context)
    {
        this.dataSet = dataSet;
        this.clickListener = clickListener;
        this.context = context;
    }

    @Override
    public ViewHolderProgram onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_program, parent, false);
        ViewHolderProgram vH = new ViewHolderProgram(view, context);

        return vH;
    }

    @Override
    public void onBindViewHolder(final ViewHolderProgram holder, final int position) {

        holder.textTitle.setText(dataSet.get(position).getTitle());
        holder.textSpeaker.setText(dataSet.get(position).getSpeaker());
        holder.textTime.setText(dataSet.get(position).getTime());
        holder.ivProfile.setImageResource(dataSet.get(position).getPic());


        holder.cardBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCardClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public static class ViewHolderProgram extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textTitle;
        public TextView textSpeaker;
        public TextView textTime;
        public ImageView ivProfile;
        public CardView cardBody;

        public ViewHolderProgram(View v, Context context) {
            super(v);
            ivProfile = (ImageView) v.findViewById(R.id.item_program_profile);
            textTitle = (TextView) v.findViewById(R.id.item_program_title);
            textSpeaker = (TextView) v.findViewById(R.id.item_program_speaker);
            textTime = (TextView) v.findViewById(R.id.item_program_time);
            cardBody = (CardView) v.findViewById(R.id.item_program_card);

           // textTitle.setTextSize(10 * context.getResources().getDisplayMetrics().density);
           // textSpeaker.setTextSize(8 * context.getResources().getDisplayMetrics().density);
        }
    }
}
