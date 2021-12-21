package com.company.howareyouapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context){

        //Initalize shared preferences
        sharedPreferences = context.getSharedPreferences("Appkey", 0);
        //Initialize editor
        editor = sharedPreferences.edit();
        //Apply editor
        editor.apply();
    }

    public void  setFlag(Boolean flag) {

        //Put boolean value
        editor.putBoolean("KEY_FLAG", flag);
        //Commit editor
        editor.commit();
    }

    public boolean getFlag(){

        //Return boolean value
        return sharedPreferences.getBoolean("KEY_FLAG", false);
    }

    public void setCurrentTime (String currentTime){

        //Put string value
        editor.putString("KEY_TIME", currentTime);
        //Comit editor
        editor.commit();
    }

    public String getCurrentTime(){
        //Return string value
        return sharedPreferences.getString("KEY_TIME", "");
    }

}
