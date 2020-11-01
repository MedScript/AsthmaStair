package com.medscript.asthmastair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class TerapeuticaFragment extends Fragment {
    private Button guardar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("A minha terapêutica");
        View v = inflater.inflate(R.layout.fragment_terapeutica, container, false);

        guardar = v.findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Fármacos atualizados com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}