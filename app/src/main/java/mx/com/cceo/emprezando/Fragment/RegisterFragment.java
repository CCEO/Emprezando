package mx.com.cceo.emprezando.Fragment;

import android.content.Intent;
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
    private EditText textEditName;
    private EditText textEditLastName;
    private EditText textEditInstitution;
    private EditText textEditSpecialty;
    private EditText textEditAge;
    private EditText textEditAddress;
    private EditText textEditPrivatePhone;
    private EditText textEditMobilPhone;
    private EditText textEditCompanyName;
    private EditText textEditPosition;
    private EditText textEditEMail;
    private EditText textEditLink;
    private EditText textEditReasons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_register, container, false);

        buttonAccept = (Button) rootView.findViewById(R.id.register_accept);
        textEditName = (EditText) rootView.findViewById(R.id.register_editText_name);
        textEditLastName = (EditText) rootView.findViewById(R.id.register_editText_lastname);
        textEditInstitution = (EditText) rootView.findViewById(R.id.register_editText_institution);
        textEditSpecialty = (EditText) rootView.findViewById(R.id.register_editText_specialty);
        textEditAge = (EditText) rootView.findViewById(R.id.register_editText_age);
        textEditAddress = (EditText) rootView.findViewById(R.id.register_editText_address);
        textEditPrivatePhone = (EditText) rootView.findViewById(R.id.register_editText_privateTelephone);
        textEditMobilPhone = (EditText) rootView.findViewById(R.id.register_editText_mobil);
        textEditCompanyName = (EditText) rootView.findViewById(R.id.register_editText_companyName);
        textEditPosition = (EditText) rootView.findViewById(R.id.register_editText_position);
        textEditEMail = (EditText) rootView.findViewById(R.id.register_editText_email);
        textEditLink = (EditText) rootView.findViewById(R.id.register_editText_link);
        textEditReasons = (EditText) rootView.findViewById(R.id.register_editText_reasons);

        //Toast.makeText(RegisterFragment.this.getActivity(),String.valueOf(textEditName.getText().length()),Toast.LENGTH_SHORT).show();

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textEditName.getText().toString().equals("") || textEditLastName.getText().toString().equals("") || textEditInstitution.getText().toString().equals("") ||
                        textEditSpecialty.getText().toString().equals("") || textEditAge.getText().toString().equals("") || textEditAddress.getText().toString().equals("") ||
                        textEditPrivatePhone.getText().toString().equals("") || textEditMobilPhone.getText().toString().equals("") || textEditCompanyName.getText().toString().equals("") ||
                        textEditPosition.getText().toString().equals("") || textEditEMail.getText().toString().equals("") || textEditLink.getText().toString().equals("") ||
                        textEditReasons.getText().equals("")) {
                    Toast.makeText(RegisterFragment.this.getActivity(), "Faltan campos por llenar", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"rhadammanthis@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "My Awesome MAil");
                    i.putExtra(Intent.EXTRA_TEXT, "A thousnad words");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                      //  Toast.makeText(RegisterFragment.this.getActivity(), "OK!", Toast.LENGTH_SHORT).show();
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(RegisterFragment.this.getActivity(), "No hay clientes de correo instalados", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return rootView;
    }
}
