package mx.com.cceo.emprezando.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/5/2015.
 */
public class RegisterFragment extends Fragment {

    private Button buttonAccept;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_register, container, false);

        buttonAccept = (Button) rootView.findViewById(R.id.register_accept);


        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://emprezando.com/2015/registrarme/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return rootView;
    }
}
