package mx.com.cceo.emprezando.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Adapter.ProgramAdapter;
import mx.com.cceo.emprezando.Adapter.ScheduleAdapter;
import mx.com.cceo.emprezando.DescriptionActivity;
import mx.com.cceo.emprezando.Linker.ProgramClickListener;
import mx.com.cceo.emprezando.Model.ActivityItem;
import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ScheduleFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RelativeLayout fragmentBody;
    private CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_schedule, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_schedule_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        ArrayList<ActivityItem> dataSet = new ArrayList<>();

        dataSet.add(new ActivityItem("8:00  Registro y Bienvenida"));
        dataSet.add(new ActivityItem("8:30  Networking"));
        dataSet.add(new ActivityItem("9:30  Inaguración"));
        dataSet.add(new ActivityItem("10:00 1er Bloque de Conferencias"));
        dataSet.add(new ActivityItem("12:00 Coffee Break"));
        dataSet.add(new ActivityItem("12:30 2do Bloque de Conferencias"));
        dataSet.add(new ActivityItem("3:00  Fotografia"));
        dataSet.add(new ActivityItem("3:10  Comida en Palacio de Gobierno"));
        dataSet.add(new ActivityItem("4:40  3er Bloque de Conferencias"));
        dataSet.add(new ActivityItem("8:00  Cierre del Evento"));


        mAdapter = new ScheduleAdapter(dataSet, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
