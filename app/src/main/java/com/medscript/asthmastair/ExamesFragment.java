package com.medscript.asthmastair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ExamesFragment extends Fragment {
    private Button guardar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Os meus exanes");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_exames, container, false);

        guardar = v.findViewById(R.id.guarda_exames);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Exames guardados com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}