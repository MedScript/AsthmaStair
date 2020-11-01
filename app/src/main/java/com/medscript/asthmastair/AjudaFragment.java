package com.medscript.asthmastair;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AjudaFragment extends Fragment {
    private Button btn_enviar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Pedir ajuda");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ajuda, container, false);

        btn_enviar = v.findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Pedido enviado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}