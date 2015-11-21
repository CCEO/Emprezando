package mx.com.cceo.emprezando.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/5/2015.
 */
public class VenueFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();

        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_venue, container, false);

        CardView crad = (CardView) rootView.findViewById(R.id.item_venue_card);

        crad.getLayoutParams().height = (int) (dpHeight * 1);

        RelativeLayout buutonMaps = (RelativeLayout) rootView.findViewById(R.id.buttonVenue);
        buutonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 21.880361;
                double longitude = -102.297051;
                String label = "Teatro Morelos";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
