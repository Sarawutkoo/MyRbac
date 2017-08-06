package com.koo.sarawut.myrbac.frigment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.koo.sarawut.myrbac.R;
import com.koo.sarawut.myrbac.manager.MyAlert;
import com.koo.sarawut.myrbac.manager.PostUserToServer;

/**
 * Created by numnim on 8/6/2017.
 */

public class SignUpFragment extends Fragment {

    private String nameString,userString,passwordString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;


    } //onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Contriller
        backButton();

        //Save Controller
        saveController();
    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Value From EditText
                EditText nameEditText= getView().findViewById(R.id.edtName);
                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                MyAlert  myAlert = new MyAlert(getActivity());

                //check Space
                if (nameString.equals("")||userString.equals("")||passwordString.equals("")) {
                    // Have Space
                    Log.d("6AugV1", "Have Space");
                    myAlert.myDialog("Have Space","Please Fill All Every Blank");
                } else {
                //NO space


                    Log.d("6AugV1", "NO Space");
                    uploadValue();

                }





            }
        });
    }

    private void uploadValue() {

        try {
            PostUserToServer postUserToServer = new PostUserToServer(getActivity());
            postUserToServer.execute(nameString,
                    userString,
                    passwordString,
                    "http://androidthai.in.th/rbac/addDataMaster123.php");
String strResult = postUserToServer.get();
            Log.d("6Augv1","Result ==> "+strResult);
            if (Boolean.parseBoolean(strResult)) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainContrainer, new MainFragment())
                        .commit();

            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void backButton() {
        ImageView imageView = getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }




}   //main Class
