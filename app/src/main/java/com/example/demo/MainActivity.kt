package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    private lateinit var speechRecognizerManager: SpeechRecognizerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        speechRecognizerManager = SpeechRecognizerManager(this)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                var showDialog by remember { mutableStateOf(false) }
                var recognizedText by remember { mutableStateOf("") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Greeting(
                            name = "Android", modifier = Modifier
                                .padding(innerPadding)
                                .clickable {
                                    speechRecognizerManager.startSpeechRecognition { text ->
                                        Log.i("pangao", "onCreate:123456 ")
                                        recognizedText = text
                                        showDialog = true
                                    }
                                })

                        Button(onClick = {
                            //启动SecondActivity
                            val intent = Intent(this@MainActivity, SecondActivity::class.java)
                            startActivity(intent)
                        }) {
                            Text("按钮")
                        }

                        if (showDialog) {
                            SpeechResultDialog(
                                text = recognizedText, onDismiss = { showDialog = false })
                        }
                    }

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizerManager.destroy()
    }


    override fun onResume() {
        super.onResume()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "点击识别", modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoTheme {
        Greeting("Android")
    }
}