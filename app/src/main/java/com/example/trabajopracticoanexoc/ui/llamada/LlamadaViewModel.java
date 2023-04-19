package com.example.trabajopracticoanexoc.ui.llamada;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamadaViewModel extends ViewModel {

    private MutableLiveData<String> error;
    private MutableLiveData<Boolean> llamar;

    public LiveData<String> getError() {
        if(error == null) {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<Boolean> getLlamar() {
        if(llamar == null) {
            llamar = new MutableLiveData<>();
        }
        return llamar;
    }

    public void llamar(String numero){
        if(numero.isEmpty() || numero.equals(" ")){
            error.setValue("El numero no puede estar vacio");
        }else{
            llamar.setValue(true);
        }
    }
}