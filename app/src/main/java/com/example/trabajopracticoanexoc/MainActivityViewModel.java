package com.example.trabajopracticoanexoc;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private Map<String,String> users = new HashMap<>();
    private MutableLiveData<String> error;
    private MutableLiveData<Boolean> access;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        users.put("admin","admin");
    }

    public LiveData<String> getError() {
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<Boolean> getAccess() {
        if(access == null){
            access = new MutableLiveData<>();
        }
        return access;
    }

    public void login(String username, String password){
        if(!users.containsKey(username)){
            error.setValue("El usuario no existe");
        }else if(!users.get(username).equals(password)){
            error.setValue("Contraseña incorrecta");
        }else{
            error.setValue(" ");
            access.setValue(true);
        }
    }

}
