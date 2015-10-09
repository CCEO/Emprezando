package mx.com.cceo.emprezando.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/9/2015.
 */
public class DescriptionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //container.removeAllViews();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_description, container, false);

        Button button = (Button) rootView.findViewById(R.id.description_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return rootView;
    }

}
