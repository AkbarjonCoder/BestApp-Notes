package com.example.bestappnotes.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bestappnotes.R
import com.example.bestappnotes.ViewModel.NotesViewModel
import com.example.bestappnotes.databinding.FragmentHomeBinding
import com.example.bestappnotes.ui.Adapter.NotesAdapter

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner) { noteList ->

            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), noteList)

        }

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root


    }

}