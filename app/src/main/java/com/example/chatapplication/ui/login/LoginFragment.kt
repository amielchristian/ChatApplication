package com.example.chatapplication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapplication.databinding.FragmentLoginBinding
import com.example.chatapplication.model.User
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            authenticateUser()
        }

        return binding.root
    }

    private fun authenticateUser()  {
        val firstName = binding.etFirstName.text.toString()
        val username = binding.etUsername.text.toString()
        if (validateInput(firstName, binding.tlFirstName) && validateInput(username, binding.tlUsername))   {
            val chatUser = User(firstName, username)
            val action = LoginFragmentDirections.actionLoginFragmentToChannelFragment(chatUser)
            findNavController().navigate(action)
        }
    }

    private fun validateInput(inputText: String, textInputLayout: TextInputLayout): Boolean {
        return if (inputText.length <= 3)  {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "Minimum of 4 characters."
            false
        } else    {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = null
            true
        }
    }

}