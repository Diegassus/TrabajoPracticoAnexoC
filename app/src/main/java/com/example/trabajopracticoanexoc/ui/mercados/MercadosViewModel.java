package com.example.trabajopracticoanexoc.ui.mercados;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MercadosViewModel extends ViewModel {

    public static final LatLng MERCADO_1 = new LatLng(-32.35634867744977, -64.99709456473751);
    public static final LatLng MERCADO_2 = new LatLng(-32.35917139196684, -64.99481633712175);
    private MutableLiveData<MapaActual> mapa;

    public MercadosViewModel() {
    }

    public LiveData<MapaActual> getMapa(){
        if(mapa == null){
            mapa = new MutableLiveData<>();
        }
        return mapa;
    }

    public void marcar(){
        this.mapa.setValue(new MapaActual());
    }
}

class MapaActual implements OnMapReadyCallback {
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.addMarker(new MarkerOptions().position(MercadosViewModel.MERCADO_1).title("Merlo Mayorista"));
        googleMap.addMarker(new MarkerOptions().position(MercadosViewModel.MERCADO_2).title("Despensa El Tala"));
        CameraPosition camPos = new CameraPosition.Builder()
                .target(MercadosViewModel.MERCADO_1)
                .zoom(19)
                .bearing(45)
                .tilt(70)
                .build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(camPos);
        googleMap.animateCamera(update);
    }
}