package com.company.howareyouapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class FragmentMoods extends Fragment {

    ImageView verygood, soandso, sad, angry;
    public TextView vgclicks, sasclicks, sadclicks, angryclicks;
    public static int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0;
    public static int counter5 = counter1 + counter2 + counter3 + counter4;
    SharedPreferences sp1, sp11, sp2, sp3, sp4;
    String klikovi1, klikovi2, klikovi3, klikovi4;
    public int CurrentProgress = 0;
    public ProgressBar progressBar, progressBar2, progressBar3, progressBar4;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moods, container, false);

        verygood = view.findViewById(R.id.very_good); //imageview iz moods fragmenta.
        soandso = view.findViewById(R.id.so_and_so);  //imageview iz moods fragmenta.
        sad = view.findViewById(R.id.sad_sad);        //imageview iz moods fragmenta.
        angry = view.findViewById(R.id.angry_angry);  //imageview iz moods fragmenta.

        //CLICKCOUNTER
        //PROGRESSBARS
        vgclicks = view.findViewById(R.id.verigudbrojklikova);  //textview iz moods fragmenta
        sp1 = getActivity().getSharedPreferences("VGclick", Context.MODE_PRIVATE);
        sp11 = getActivity().getSharedPreferences("progressbar1", Context.MODE_PRIVATE);

        progressBar = view.findViewById(R.id.progressBar); //progressbar iz statistics fragmenta

        verygood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter1 = counter1 + 1;
                vgclicks.setText("" + counter1);
                klikovi1 = vgclicks.getText().toString();

                SharedPreferences.Editor editor = sp1.edit();
                editor.putString("VGclicks", String.valueOf(klikovi1));
                editor.commit();

//                CurrentProgress = CurrentProgress + counter1/counter5*100;
//                progressBar.setProgress(CurrentProgress);
//                progressBar.setMax(100);
//
//                SharedPreferences.Editor editor1 = sp11.edit();
//                editor1.putInt("currentprogress11", CurrentProgress);
//                editor1.apply();

            }
        });

        sp2 = getActivity().getSharedPreferences("SASclick", Context.MODE_PRIVATE);
        sasclicks = view.findViewById(R.id.sasbrojklikova);  //textview iz moods fragmenta

        soandso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter2 = counter2 + 1;
                sasclicks.setText("" + counter2);
                klikovi2 = sasclicks.getText().toString();

                SharedPreferences.Editor editor = sp2.edit();
                editor.putString("SASclicks", String.valueOf(klikovi2));
                editor.commit();

            }
        });

        sp3 = getActivity().getSharedPreferences("Sadclick", Context.MODE_PRIVATE);
        sadclicks = view.findViewById(R.id.saddbrojklikova);  //textview iz moods fragmenta

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter3 = counter3 + 1;
                sadclicks.setText("" + counter3);
                klikovi3 = sadclicks.getText().toString();

                SharedPreferences.Editor editor = sp3.edit();
                editor.putString("SADclicks", String.valueOf(klikovi3));
                editor.commit();

            }
        });

        sp4 = getActivity().getSharedPreferences("Angryclick", Context.MODE_PRIVATE);
        angryclicks = view.findViewById(R.id.angribrojklikova);  //textview iz moods fragmenta

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter4 = counter4 + 1;
                angryclicks.setText("" + counter4);
                klikovi4 = angryclicks.getText().toString();

                SharedPreferences.Editor editor = sp4.edit();
                editor.putString("Angryclicks", String.valueOf(klikovi4));
                editor.commit();

            }
        });
        //CLICKCOUNTER

        return view;
    }
}