package com.mirea.denisignatenko.mireaproject.ui.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.denisignatenko.mireaproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterCell extends RecyclerView.Adapter<com.mirea.denisignatenko.mireaproject.ui.notes.AdapterCell.StoryHolder> {
    List<com.mirea.denisignatenko.mireaproject.ui.notes.Cell> notes;

    public AdapterCell(List<com.mirea.denisignatenko.mireaproject.ui.notes.Cell> notes) {
        this.notes = notes;
    }

    @Override
    public StoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.cell_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);
        StoryHolder noteHolder = new StoryHolder(view);
        return noteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoryHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder {
        TextView noteId;
        TextView noteText;

        public StoryHolder(View itemView) {
            super(itemView);

            noteId = itemView.findViewById(R.id.tv_id);
            noteText = itemView.findViewById(R.id.tv_text);
        }

        void bind(int listIndex) {
            com.mirea.denisignatenko.mireaproject.ui.notes.Cell cell = notes.get(listIndex);
            noteId.setText(String.valueOf(cell.id));
            noteText.setText(cell.text);
        }
    }
}
