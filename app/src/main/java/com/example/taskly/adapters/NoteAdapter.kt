package com.example.taskly.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskly.databinding.NoteItemsBinding
import com.example.taskly.models.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteTitle == newItem.noteTitle &&
                    oldItem.noteDesc == newItem.noteDesc
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this@NoteAdapter, differCallBack)

    private var onItemClickListener: ((Note) -> Unit)? = null

    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }

    inner class NoteViewHolder(val itemsBinding: NoteItemsBinding) :
        RecyclerView.ViewHolder(itemsBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        return NoteViewHolder(
            NoteItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemsBinding.apply {
            noteTitle.text = currentNote.noteTitle
            noteDesc.text = currentNote.noteDesc
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(currentNote)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}