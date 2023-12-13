package com.example.chatapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.chatapplication.model.User
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.name
import com.example.chatapplication.ui.login.LoginFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val client = ChatClient.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.navHostFragment)

        if (navController.currentDestination?.label.toString().contains("login"))   {
            val currentUser = client.getCurrentUser()

            // don't show Login fragment when user is logged in
            if (currentUser != null)    {
                val user = User(currentUser.name, currentUser.id)
                val action = LoginFragmentDirections.actionLoginFragmentToChannelFragment(user)
                navController.navigate(action)
            }
        }
    }
}