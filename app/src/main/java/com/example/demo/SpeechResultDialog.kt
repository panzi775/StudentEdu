package com.example.demo

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SpeechResultDialog(
    text: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("语音识别结果") },
        text = { Text(text) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
} 