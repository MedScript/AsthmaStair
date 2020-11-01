package com.medscript.asthmastair;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ConsultasFragment extends Fragment {
    private TextView marcarConsultas;

    public ConsultasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_consultas,
                container, false);
        getActivity().setTitle("Consultas marcadas");
        marcarConsultas = rootView.findViewById(R.id.marcar_consulta);
        marcarConsultas.setOnClickListener(v -> updateDetail());
        return rootView;
    }

    public void updateDetail() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container,
                new MarcarConsultasFragment()).commit();
    }

}
