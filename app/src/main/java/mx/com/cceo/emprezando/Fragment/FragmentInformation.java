package mx.com.cceo.emprezando.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/1/2015.
 */
public class FragmentInformation extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_infromation, container, false);

        return rootView;
    }
}
