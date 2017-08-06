package com.koo.sarawut.myrbac.frigment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.koo.sarawut.myrbac.R;

/**
 * Created by numnim on 8/5/2017.
 */

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;

    } //onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Controller

        registerController();

    } //onActivityCreared

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUpFragment signUpFragment = new SignUpFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainContrainer, signUpFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });


    }


}  //Main Class
