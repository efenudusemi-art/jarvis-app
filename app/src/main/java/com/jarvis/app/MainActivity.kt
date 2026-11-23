package com.jarvis.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JarvisApp()
        }
    }
}

@Composable
fun JarvisApp() {
    var input by remember { mutableStateOf("") }
    var reply by remember { mutableStateOf("Hello Sir, I am JARVIS. How can I help you?") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text(text = "J.A.R.V.I.S", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = reply)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Talk to JARVIS") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            reply = getJarvisReply(input)
            input = ""
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Ask JARVIS")
        }
    }
}

fun getJarvisReply(input: String): String {
    val text = input.lowercase()
    return when {
        "hello" in text || "hi" in text -> "Hello Sir, good to see you. What should I do for you?"
        "your name" in text -> "I am JARVIS, your personal AI assistant."
        "how are you" in text -> "I am running perfectly, Sir. All systems online."
        "time" in text -> "Let me check the time for you, Sir."
        "thank" in text -> "Always at your service, Sir."
        "bye" in text -> "Goodbye Sir, I will be here when you need me."
        else -> "Understood Sir. I will work on that: $input"
    }
}
