package mx.com.cceo.emprezando.Fragment;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mx.com.cceo.emprezando.Model.DescriptionItem;
import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 10/9/2015.
 */
public class DescriptionFragment extends Fragment {

    private DescriptionItem descriptionItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //container.removeAllViews();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_description, container, false);

        //load data to fragment's views only if data available
        if(descriptionItem != null)
        {
            TextView tvName = (TextView) rootView.findViewById(R.id.description_name);
            TextView tvCompany = (TextView) rootView.findViewById(R.id.description_company);
            TextView tvAbout = (TextView) rootView.findViewById(R.id.description_bio);
            ImageView ivProfile = (ImageView) rootView.findViewById(R.id.description_profile_image);

            tvName.setText(descriptionItem.getTitle());
            tvCompany.setText(descriptionItem.getSpeaker());
            tvAbout.setText(descriptionItem.getAbout());
            ivProfile.setImageResource(descriptionItem.getPic());
        }

        //Initiates the e-mail client to send questions to speaker
//        Button button = (Button) rootView.findViewById(R.id.description_send);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_SEND);
//                i.setType("message/rfc822");
//                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"contacto@coparmex.com"});
//                i.putExtra(Intent.EXTRA_SUBJECT, "Duda de conferencia \"" + descriptionItem.getTitle() +"\"");
//                i.putExtra(Intent.EXTRA_TEXT, "A thousnad words");
//                try {
//                    startActivity(Intent.createChooser(i, "Send mail..."));
//                    //  Toast.makeText(RegisterFragment.this.getActivity(), "OK!", Toast.LENGTH_SHORT).show();
//                } catch (android.content.ActivityNotFoundException ex) {
//                    Toast.makeText(DescriptionFragment.this.getActivity(), "No hay clientes de correo instalados", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return rootView;
    }

    public void setDescriptionItem(DescriptionItem item)
    {
        this.descriptionItem = item;
    }

}
