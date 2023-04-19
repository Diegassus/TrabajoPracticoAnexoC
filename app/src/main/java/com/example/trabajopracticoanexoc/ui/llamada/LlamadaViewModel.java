package com.example.trabajopracticoanexoc.ui.llamada;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamadaViewModel extends AndroidViewModel {

    private MutableLiveData<String> error;
    private Context context;

    public LlamadaViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if(error == null) {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void llamar(String numero){
        if(numero.isEmpty() || numero.equals(" ")){
            error.setValue("El numero no puede estar vacio");
        }else{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + numero));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity)context, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            context.startActivity(intent);
        }
    }
}