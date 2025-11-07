package com.example.questnavigastugas_083.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_083.R // Pastikan ini sesuai dengan package dan lokasi file R Anda


@Composable
fun Home(onNavigateToPendaftaran: () -> Unit) {
    // Scaffold memberikan struktur dasar untuk layar, termasuk slot untuk TopBar, BottomBar, dll.
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFE0F7FA)
    ) { paddingValues ->
        // Column untuk menyusun elemen secara vertikal di tengah
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Pusatkan konten secara vertikal
        ) {
            // Teks "Selamat Datang"
            Text(
                text = "Selamat Datang",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // Placeholder untuk Logo (Gantilah 'ic_launcher_foreground' dengan ID resource drawable logo Anda)
            // Asumsi: Logo 'CARD-LST' ada di drawable
            Image(
                painter = painterResource(id = R.drawable.poto), // Ganti dengan ID drawable logo Anda
                contentDescription = "Logo Aplikasi",
                modifier = Modifier
                    .size(260.dp)
                    .padding(bottom = 24.dp)
            )

            // Teks Nama
            Text(
                text = "Fera Istanti",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Teks NIM
            Text(
                text = "20230140083",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 48.dp)
            )

            // Tombol "Submit"
            Button(
                onClick = onNavigateToPendaftaran, // Panggil fungsi navigasi saat tombol diklik
                modifier = Modifier
                    .fillMaxWidth(0.6f) // Lebar 60% dari parent
                    .height(50.dp)
            ) {
                Text("Submit", fontSize = 18.sp)
            }
        }
    }
}

// Fungsi preview untuk melihat tampilan di Android Studio
@Preview(showBackground = true)
@Composable
fun HomePreview() {
    // Gunakan tema aplikasi Anda di sini
    MaterialTheme {
        Home(onNavigateToPendaftaran = {})
    }
}