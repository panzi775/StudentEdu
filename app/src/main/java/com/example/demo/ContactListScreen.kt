package com.example.demo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// 数据模型
data class Contact(val name: String, val phone: String)

// 假数据
val sampleContacts = listOf(
    Contact("Alice", "123-456-7890"),
    Contact("Bob", "234-567-89132434325245201"),
    Contact("Charlie", "345-678-9012"),
    Contact("Diana", "456-789-0123")
)

// 单个联系人卡片
@Composable
fun ContactCard(contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = contact.name, style = MaterialTheme.typography.titleMedium)
            Text(text = contact.phone, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// 联系人列表
@Composable
fun ContactList(contacts: List<Contact>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(contacts) { contact ->
            ContactCard(contact)
        }
    }
}

// 预览
@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    MaterialTheme {
        ContactList(sampleContacts)
    }
}
