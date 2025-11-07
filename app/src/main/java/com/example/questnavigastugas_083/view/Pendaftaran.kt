package com.example.questnavigastugas_083.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Mendefinisikan warna
val OrangeHeader = Color(0xFFFE9900)
val PurpleSubmit = Color(0xFF673AB7)

@OptIn(ExperimentalMaterial3Api::class) // Anotasi
@Composable
fun FormIsian(
    onSubmitBtnClick: () -> Unit,
    modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var selectedJK by remember { mutableStateOf("") }
    var selectedStatusKawin by remember { mutableStateOf("") }

    var resultNama by remember { mutableStateOf("") }
    var resultJK by remember { mutableStateOf("") }
    var resultStatusKawin by remember { mutableStateOf("") }
    var resultAlamat by remember { mutableStateOf("") }

    val genderOptions = listOf("Laki-laki", "Perempuan")
    val statusKawinOptions = listOf("Janda", "Lajang", "Duda")

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 50.dp),
                title = {
                    Text(
                        text = "Formulir Pendaftaran",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeHeader
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->


        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp) // Padding tambahan untuk Card
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp) // Padding di dalam Card
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {

                // --- NAMA LENGKAP ---
                Text(
                    text = "NAMA LENGKAP",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Isian nama lengkap") },
                    onValueChange = { textNama = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                // --- JENIS KELAMIN ---
                Text(text = "JENIS KELAMIN", fontWeight = FontWeight.SemiBold)
                Column(modifier = Modifier.fillMaxWidth()) {
                    genderOptions.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = selectedJK == item,
                                    onClick = { selectedJK = item })
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedJK == item,
                                onClick = { selectedJK = item })
                            Text(item, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))



            }
        }
    }
}