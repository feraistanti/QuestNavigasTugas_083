package com.example.questnavigastugas_083

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas_083.view.FormIsian
import com.example.questnavigastugas_083.view.Home
import com.example.questnavigastugas_083.view.TampilData

enum class Navigasi {
    Home,
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                FormIsian (
                    //pilihanJK = JenisK.map { id -> konteks.resources.getString}
                    onSubmitBtnClick ={
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData(
                    onBackClick = {
                        // Kembali ke Formulirku (Logika ini sudah benar)
                        cancelAndBackToFormulirku(navController)
                    },
                    onBackHomeClick = {
                        // PERUBAHAN DISINI: Menggunakan navigate dengan popUpTo dan inclusive=true
                        navController.navigate(Navigasi.Home.name) {
                            // Menghapus semua destination yang ada di atas Home
                            popUpTo(Navigasi.Home.name) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(route = Navigasi.Home.name){
                Home (
                    onNavigateToPendaftaran = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }

        }
    }
}


private fun cancelAndBackToFormulirku(
    navController:NavHostController
){
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}