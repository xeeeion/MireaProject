package com.mirea.denisignatenko.mireaproject.ui.settings_profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.mirea.denisignatenko.mireaproject.R;

import static com.mirea.denisignatenko.mireaproject.MainActivity.SAVED_THEME;
import static com.mirea.denisignatenko.mireaproject.MainActivity.preferences_theme;

public class Profile extends Fragment {


    private EditText editNewNote;
    private SharedPreferences preferences_notes;
    private final String SAVED_NOTE = "saved_note";
    private String color;
    private int colorCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings_profile, container, false);

        RadioButton radioButtonDark = root.findViewById(R.id.button_alt_theme);
        RadioButton radioButtonLight = root.findViewById(R.id.button_light_theme);
        editNewNote = root.findViewById(R.id.edit_new_note);
        Button buttonChange = root.findViewById(R.id.button_change_note);
        preferences_notes = getActivity().getPreferences(Context.MODE_PRIVATE);

        radioButtonDark.setOnClickListener(radioButtonListener);
        radioButtonLight.setOnClickListener(radioButtonListener);
        buttonChange.setOnClickListener(changeClickListener);

        if (!preferences_notes.getString(SAVED_NOTE, "Empty").equals("Empty"))
            editNewNote.setText(preferences_notes.getString(SAVED_NOTE, "Empty"));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(preferences_theme.getInt(SAVED_THEME, getResources().
                getColor(R.color.design_default_color_background)));
    }

    View.OnClickListener radioButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton clickedButton = (RadioButton) v;
            switch (clickedButton.getId()) {
                case R.id.button_alt_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.alt));
                    color = "alt";
                    colorCode = ContextCompat.getColor(getContext(), R.color.alt);
                    break;
                case R.id.button_light_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.design_default_color_background));
                    color = "light";
                    colorCode = ContextCompat.getColor(getContext(), R.color.design_default_color_background);
                    break;
            }
            SharedPreferences.Editor editor = preferences_theme.edit();
            editor.putInt(SAVED_THEME, colorCode);
            editor.apply();
        }
    };

    View.OnClickListener changeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!editNewNote.getText().toString().equals("")) {
                String note = editNewNote.getText().toString();
                SharedPreferences.Editor editor = preferences_notes.edit();
                editor.putString(SAVED_NOTE, note);
                editor.apply();
            }
        }
    };
}