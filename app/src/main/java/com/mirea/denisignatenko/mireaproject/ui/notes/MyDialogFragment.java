package com.mirea.denisignatenko.mireaproject.ui.notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.mirea.denisignatenko.mireaproject.R;

import java.util.List;

public class MyDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        EditText valueKey = view.findViewById(R.id.edit_text_dialog);

        builder.setTitle("Добавить заметку в истории?")
                .setView(view)
                .setMessage("Введите заметку")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Сохранить", (dialog, id) -> {
                    Toast.makeText(getContext(), "История сохранена",
                            Toast.LENGTH_SHORT).show();
                    AppData db = App.getInstance().getDatabase();
                    NoteDAO noteDAO = db.storyDao();
                    com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell = new com.mirea.denisignatenko.mireaproject.ui.notes.Cell();
                    cell.text = String.valueOf(valueKey.getText());
                    noteDAO.insert(cell);
                    dialog.cancel();
                })
                .setNegativeButton("Отмена",
                        (dialog, id) -> {
                            dialog.cancel();
                        })
                .setNeutralButton("Очистить истории",
                        (dialog, id) -> {
                            Toast.makeText(getContext(), "Истории очищены",
                                    Toast.LENGTH_SHORT).show();
                            AppData db = App.getInstance().getDatabase();
                            NoteDAO noteDAO = db.storyDao();
                            List<com.mirea.denisignatenko.mireaproject.ui.notes.Cell> cells = noteDAO.getAll();
                            for (com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell : cells) {
                                noteDAO.delete(cell);
                            }
                            dialog.cancel();
                        });
        return builder.create();
    }
}
