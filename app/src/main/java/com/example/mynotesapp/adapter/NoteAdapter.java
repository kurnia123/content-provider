package com.example.mynotesapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapp.CustomOnItemClickListener;
import com.example.mynotesapp.NoteAddUpdateActivity;
import com.example.mynotesapp.R;
import com.example.mynotesapp.entity.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVIewHolder> {

    private ArrayList<Note> listNote = new ArrayList<>();
    private Activity activity;

    public NoteAdapter(Activity activity){
        this.activity = activity;
    }

    public ArrayList<Note> getLIstNotes(){
        return listNote;
    }

    public void setListNotes(ArrayList<Note> listNote){
        if (listNote.size() > 0){
            this.listNote.clear();
        }

        this.listNote.addAll(listNote);
        notifyDataSetChanged();
    }

    public void addItem(Note note){
        this.listNote.add(note);
        notifyItemInserted(listNote.size() - 1);
    }

    public void updateItem(int position, Note note){
        this.listNote.set(position, note);
        notifyItemChanged(position, note);
    }

    public void removeItem(int position){
        this.listNote.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listNote.size());
    }

    @NonNull
    @Override
    public NoteVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVIewHolder holder, int position) {
        holder.tvTitle.setText(listNote.get(position).getTitle());
        holder.tvDate.setText(listNote.get(position).getDate());
        holder.tvDescription.setText(listNote.get(position).getDescription());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
                intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position);
                intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, listNote.get(position));
                activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }

    class NoteVIewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle,tvDescription, tvDate;
        final CardView cvNote;

        NoteVIewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            cvNote = itemView.findViewById(R.id.cv_item_note);
        }
    }
}
