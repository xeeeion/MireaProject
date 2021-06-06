package com.mirea.denisignatenko.mireaproject.ui.audio_player;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.mirea.denisignatenko.mireaproject.R;

import static com.mirea.denisignatenko.mireaproject.MainActivity.SAVED_THEME;
import static com.mirea.denisignatenko.mireaproject.MainActivity.preferences_theme;

public class AudioFragment extends Fragment {
    Button buttonPlay;
    Button buttonStop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_audio_player, container, false);
        buttonPlay = root.findViewById(R.id.button_play);
        buttonStop = root.findViewById(R.id.button_stop);
        View.OnClickListener playClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getContext(), AudioService.class));
            }
        };

        buttonPlay.setOnClickListener(playClickListener);


        View.OnClickListener stopClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getContext(), AudioService.class));
            }
        };

        buttonStop.setOnClickListener(stopClickListener);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(preferences_theme.getInt(SAVED_THEME, getResources().getColor(R.color.alt)));
    }
}