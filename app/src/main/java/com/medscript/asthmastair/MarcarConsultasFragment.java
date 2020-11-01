package com.medscript.asthmastair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MarcarConsultasFragment extends Fragment {
    Button marcar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_marcar_consultas, container, false);
        // Inflate the layout for this fragment
        getActivity().setTitle("Marcar consulta");

        marcar = rootView.findViewById(R.id.marcar_consulta_calen);
        marcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "A sua consulta foi agendada", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}