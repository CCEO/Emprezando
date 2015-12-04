package mx.com.cceo.emprezando.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Adapter.ProgramAdapter;
import mx.com.cceo.emprezando.DescriptionActivity;
import mx.com.cceo.emprezando.Linker.ProgramClickListener;
import mx.com.cceo.emprezando.MainActivity;
import mx.com.cceo.emprezando.Model.ConferenceItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ProgramFragment extends Fragment implements ProgramClickListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RelativeLayout fragmentBody;
    private CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_program, container, false);

        fragmentBody = (RelativeLayout) rootView.findViewById(R.id.fragment_program_body);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_program_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        ArrayList<ConferenceItem> dataSet = new ArrayList<>();

        ConferenceItem saul = new ConferenceItem("Saúl Haro Vazquez","Macrolynk", "10:00 - 10:20", R.drawable.saulh);
        ConferenceItem jorge = new ConferenceItem("Jorge García","Outcom", "10:20 - 10:50", R.drawable.jorge);
        ConferenceItem juan = new ConferenceItem("Juan José Díaz","Eudoxa", "10:50 - 11:20", R.drawable.juan);
        ConferenceItem francisco = new ConferenceItem("Francisco García","Pacomer y Coachildren", "11:20 - 11:50", R.drawable.francisco);
        ConferenceItem sergio = new ConferenceItem("Sergio Ramírez Zúñiga","Academia de Baloncesto", "12:20 - 12:40", R.drawable.sergio);
        ConferenceItem guadalupe = new ConferenceItem("Guadalupe Gómez","Remedios Mágicos", "12:40 - 13:10", R.drawable.guadalupe);
        ConferenceItem arturo = new ConferenceItem("Arturo Gilio Hamdan","Palacio de Centenario", "13:10 - 13:30", R.drawable.arturo);
        ConferenceItem vidal = new ConferenceItem("Vidal Cantú","Kenio Films y Veramiko", "13:30 - 14:10", R.drawable.vidal);
        ConferenceItem norma = new ConferenceItem("Norma Romero","Las Patronas", "16:40 - 17:10", R.drawable.norma);
        ConferenceItem jose = new ConferenceItem("José Luis Garza", "Interjet", "00:00 - 00:00", R.drawable.big_jose);
        ConferenceItem armando = new ConferenceItem("Armando Guadiana", "Minera Coapas","", R.drawable.armando);
        ConferenceItem angel  = new ConferenceItem("José Gonzáles Serna", "Textiles Universales","",R.drawable.angel);

        dataSet.add(saul);
        dataSet.add(jorge);
        dataSet.add(juan);
        dataSet.add(francisco);
        dataSet.add(guadalupe);
        dataSet.add(arturo);
        dataSet.add(vidal);
        dataSet.add(norma);
        dataSet.add(jose);
        dataSet.add(armando);
        dataSet.add(angel);

        mAdapter = new ProgramAdapter(dataSet, this,getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onCardClick(View v, int position) {

        Intent mainIntent = new Intent(ProgramFragment.this.getActivity(), DescriptionActivity.class);
        mainIntent.putExtra("position", position);
        startActivity(mainIntent);
        getActivity().overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

    }
}
