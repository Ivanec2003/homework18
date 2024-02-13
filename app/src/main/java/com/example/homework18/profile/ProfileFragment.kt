package com.example.homework18.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.homework18.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var isSaved = false

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){galleryUri ->
        binding.imageButtonPhotoProfile.setImageURI(galleryUri)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickPhotoProfile()
        clickButtonSaveOrChange()

    }
    private fun clickPhotoProfile(){
        binding.imageButtonPhotoProfile.setOnClickListener{
            galleryLauncher.launch("image/*")
        }
    }
    private fun clickButtonSaveOrChange(){
        binding.buttonSaveOrChange.setOnClickListener{
            if (!isSaved) {
                setStateSaved()
            }
            else{
                setStateUnSaved()
            }
        }

    }
    private fun setStateSaved(){
        val nameProfile = binding.textFieldEnterName.editText?.text.toString()
        val state = "Change"
        binding.textViewNameProfile.text = nameProfile

        binding.buttonSaveOrChange.text = state
        binding.imageButtonPhotoProfile.isClickable = false
        binding.textFieldEnterName.isVisible = false
        binding.textViewNameProfile.isVisible = true
        isSaved = true
    }
    private fun setStateUnSaved(){
        val state = "Save"
        binding.buttonSaveOrChange.text = state
        binding.imageButtonPhotoProfile.isClickable = true
        binding.textFieldEnterName.isVisible = true
        binding.textViewNameProfile.isVisible = false
        isSaved = false
    }
}