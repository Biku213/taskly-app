package com.example.taskly.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.taskly.MainActivity
import com.example.taskly.R
import com.example.taskly.adapters.NoteAdapter
import com.example.taskly.databinding.FragmentHomeBinding
import com.example.taskly.models.Note
import com.example.taskly.viewmodel.NoteViewModel

class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val noteViewModel: NoteViewModel by lazy { (requireActivity() as MainActivity).noteViewModel }
    private val noteAdapter: NoteAdapter by lazy { NoteAdapter() }

    private val menuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            setupSearchMenu(menu, menuInflater)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeNotes()
    }

    private fun setupUI() {
        setupRecyclerView()
        setupMenuProvider()
        setupClickListeners()
    }

    private fun setupMenuProvider() {
        requireActivity().addMenuProvider(
            menuProvider,
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        )
    }

    private fun setupSearchMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.home_menu, menu)

        val searchItem = menu.findItem(R.id.searchMenu)
        val searchView = searchItem?.actionView as? SearchView ?: return

        searchView.apply {
            isSubmitButtonEnabled = false
            setOnQueryTextListener(this@HomeFragment)

            setOnCloseListener {
                clearFocus()
                true
            }
        }
    }


    private fun setupRecyclerView() {
        binding.homeRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                GRID_SPAN_COUNT,
                StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter.apply {
                setOnItemClickListener { note ->
                    val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
                    findNavController().navigate(direction)
                }
            }
        }
    }

    private fun setupClickListeners() {
        binding.addNoteFab.setOnClickListener {
            navigateToAddNote()
        }
    }

    private fun observeNotes() {
        noteViewModel.getAllNote().observe(viewLifecycleOwner) { notes ->
            updateNotesList(notes)
            updateUIVisibility(notes)
        }
    }

    private fun updateNotesList(notes: List<Note>) {
        noteAdapter.differ.submitList(notes)
    }

    private fun updateUIVisibility(notes: List<Note>) {
        binding.apply {
            homeRecyclerView.isVisible = notes.isNotEmpty()
            emptyNotesImage.isVisible = notes.isEmpty()
        }
    }

    private fun navigateToAddNote() {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
        )
    }

    private fun navigateToEditNote(note: Note) {
        val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
        findNavController().navigate(action)
    }

    private fun searchNotes(query: String?) {
        val searchQuery = "%${query?.trim() ?: ""}%"

        noteViewModel.searchNote(searchQuery).observe(viewLifecycleOwner) { notes ->
            updateNotesList(notes)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean {
        searchNotes(newText)
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val GRID_SPAN_COUNT = 2
    }
}