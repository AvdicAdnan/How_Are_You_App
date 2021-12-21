package com.company.howareyouapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.SystemClock;
import android.se.omapi.Session;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentStatistics extends Fragment {

    TextView vgcnt, sascnt, sadcnt, angrycnt;
    Chronometer chronometer;
    SessionManager sessionManager;
    SimpleDateFormat format;
    String currentTime;
    int savedProgressBar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_statistics, container, false);

        vgcnt = view.findViewById(R.id.vgused);
        sascnt = view.findViewById(R.id.sasused);
        sadcnt = view.findViewById(R.id.sadused);
        angrycnt = view.findViewById(R.id.angryused);
        chronometer = view.findViewById(R.id.chronometer);

        //PROGRESSBARS

        SharedPreferences sp11 = getActivity().getApplicationContext()
                .getSharedPreferences("progressbar1", Context.MODE_PRIVATE);
        savedProgressBar = sp11.getInt("currentprogress", Context.MODE_PRIVATE);

        //PROGRESSBARS

        //CHRONOMETER
        sessionManager = new SessionManager(getContext());
        format = new SimpleDateFormat("hh:mm:ss aa");
        currentTime = format.format(new Date());

        boolean flag = sessionManager.getFlag();

        if (!flag) {
            sessionManager.setCurrentTime(currentTime);
            sessionManager.setFlag(true);
            chronometer.start();
        } else {
            String sessionManagerCurrentTime = sessionManager.getCurrentTime();
            try {
                Date date1 = format.parse(sessionManagerCurrentTime);
                Date date2 = format.parse(currentTime);
                long mils = date2.getTime() - date1.getTime();
                chronometer.setBase(SystemClock.elapsedRealtime() - mils );
                chronometer.start();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //CHRONOMETER

        //CLICKCOUNTER
        SharedPreferences sp1 = getActivity().getApplicationContext()
                .getSharedPreferences("VGclick", Context.MODE_PRIVATE);
        String brojklikova11 = sp1.getString("VGclicks", "");
        vgcnt.setText(brojklikova11);

        SharedPreferences sp2 = getActivity().getApplicationContext()
                .getSharedPreferences("SASclick", Context.MODE_PRIVATE);
        String brojklikova22 = sp2.getString("SASclicks", "");
        sascnt.setText(brojklikova22);

        SharedPreferences sp3 = getActivity().getApplicationContext()
                .getSharedPreferences("Sadclick", Context.MODE_PRIVATE);
        String brojklikova33 = sp3.getString("SADclicks", "");
        sadcnt.setText(brojklikova33);

        SharedPreferences sp4 = getActivity().getApplicationContext()
                .getSharedPreferences("Angryclick", Context.MODE_PRIVATE);
        String brojklikova44 = sp4.getString("Angryclicks", "");
        angrycnt.setText(brojklikova44);
        //CLICKCOUNTER

        return view;
    }
}
