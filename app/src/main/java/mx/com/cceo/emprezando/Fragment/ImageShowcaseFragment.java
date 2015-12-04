package mx.com.cceo.emprezando.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import mx.com.cceo.emprezando.R;

/**
 * Created by Hugo on 11/22/2015.
 */
public class ImageShowcaseFragment  extends Fragment {

    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //container.removeAllViews();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_image_showcase, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.item_image_showcase_image);
        image.setImageResource(id);


        return rootView;

    }

    public void setImageId(int id)
    {
        this.id = id;
    }
}
