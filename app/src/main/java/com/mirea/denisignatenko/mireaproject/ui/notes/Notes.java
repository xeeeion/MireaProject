package com.mirea.denisignatenko.mireaproject.ui.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.denisignatenko.mireaproject.R;

import java.util.List;

import static com.mirea.denisignatenko.mireaproject.MainActivity.SAVED_THEME;
import static com.mirea.denisignatenko.mireaproject.MainActivity.preferences_theme;

public class Notes extends Fragment {
    private RecyclerView notes;
    private AdapterCell adapterCell;
    List<com.mirea.denisignatenko.mireaproject.ui.notes.Cell> listStories;

    public Notes() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        AppData db = App.getInstance().getDatabase();
        NoteDAO noteDAO = db.storyDao();
        notes = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        notes.setLayoutManager(layoutManager);
        notes.setHasFixedSize(true);
        listStories = noteDAO.getAll();
        adapterCell = new AdapterCell(listStories);
        notes.setAdapter(adapterCell);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(preferences_theme.getInt(SAVED_THEME, getResources().getColor(R.color.alt)));
    }
}