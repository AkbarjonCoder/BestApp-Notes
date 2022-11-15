package com.example.bestappnotes.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bestappnotes.Model.Notes
import com.example.bestappnotes.R
import com.example.bestappnotes.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context, val noteList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    class NotesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = noteList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text = data.subTitle
        holder.binding.notesNotes.text = data.notes
        holder.binding.notesData.text = data.date

        when (data.priority) {
            "1" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3" -> {
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }

//        holder.binding.root.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment
//        }

    }

    override fun getItemCount()=noteList.size

}