package mx.com.cceo.emprezando.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

        ConferenceItem temp = new ConferenceItem("21","OCT","Nymphetamine","Cradle of Filth", "10:15 - 11:30");
        ConferenceItem temp1 = new ConferenceItem("12","DIC","Blood and Thunder","Mastodon", "10:15 - 11:30");
        dataSet.add(temp);
        dataSet.add(temp1);

        mAdapter = new ProgramAdapter(dataSet, this);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onCardClick(View v, int position) {
        Toast.makeText(ProgramFragment.this.getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();

        Intent mainIntent = new Intent(ProgramFragment.this.getActivity(), DescriptionActivity.class);
        mainIntent.putExtra("position", position);
        startActivity(mainIntent);
//        getFragmentManager().beginTransaction()
//                .replace(fragmentBody.getId(), new DescriptionFragment())
//                .addToBackStack(null)
//                .commit();
    }
}
