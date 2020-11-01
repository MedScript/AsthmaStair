package com.medscript.asthmastair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SintomasFragment extends Fragment {
    private Button btn_submeter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sintomas, container, false);
        // Inflate the layout for this fragment
        getActivity().setTitle("O meu diário de sintomas");

        btn_submeter = rootView.findViewById(R.id.btn_submeter);
        btn_submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Dados enviados com sucesso !", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}