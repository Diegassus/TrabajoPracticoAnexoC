package com.example.trabajopracticoanexoc.ui.mercados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajopracticoanexoc.R;
import com.example.trabajopracticoanexoc.databinding.FragmentMercadosBinding;
import com.google.android.gms.maps.SupportMapFragment;

public class MercadosFragment extends Fragment {

    private FragmentMercadosBinding binding;
    private MercadosViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(MercadosViewModel.class);

        binding = FragmentMercadosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getMapa().observe(getViewLifecycleOwner(), new Observer<MapaActual>() {
            @Override
            public void onChanged(MapaActual mapaActual) {
                if(mapaActual != null){
                    SupportMapFragment smf = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
                    smf.getMapAsync(mapaActual);
                }
            }
        });

        vm.marcar();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}