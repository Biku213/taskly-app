package com.example.taskly.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.taskly.MainActivity
import com.example.taskly.R
import com.example.taskly.databinding.FragmentEditNoteBinding
import com.example.taskly.models.Note
import com.example.taskly.viewmodel.NoteViewModel


class EditNoteFragment : Fragment(R.layout.fragment_edit_note), MenuProvider {
    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!

    private val noteViewModel: NoteViewModel by lazy { (activity as MainActivity).noteViewModel }
    private val args: EditNoteFragmentArgs by navArgs()
    private lateinit var currentNote: Note

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        setupCurrentNote()
        setupClickListeners()
    }

    private fun setupMenu() {
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupCurrentNote() {
        currentNote = args.note ?: return
        binding.apply {
            editNoteTitle.setText(currentNote.noteTitle)
            editNoteDesc.setText(currentNote.noteDesc)
        }
    }

    private fun setupClickListeners() {
        binding.editNoteFab.setOnClickListener { saveUpdatedNote() }
    }

    private fun saveUpdatedNote() {
        val title = binding.editNoteTitle.text.toString().trim()
        val desc = binding.editNoteDesc.text.toString().trim()

        if (title.isEmpty()) {
            showToast(getString(R.string.enter_note_title))
            return
        }

        val updatedNote = currentNote.copy(noteTitle = title, noteDesc = desc)
        noteViewModel.updateNote(updatedNote)
        navigateBack()
    }

    private fun showDeleteDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.delete_note))
            .setMessage(getString(R.string.delete_note_confirmation))
            .setPositiveButton(getString(R.string.delete)) { _, _ ->
                noteViewModel.deleteNote(currentNote)
                navigateBack()
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .create()
            .show()
    }

    private fun navigateBack() {
        view?.findNavController()?.popBackStack(R.id.homeFragment, false)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.deleteMenu -> {
                showDeleteDialog()
                true
            }
            else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}