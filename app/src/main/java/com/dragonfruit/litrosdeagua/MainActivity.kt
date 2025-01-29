package com.dragonfruit.litrosdeagua

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.ui.AppLayout
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LitrosDeAguaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ){
                    AppLayout()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppLayoutPreview() {
    LitrosDeAguaTheme {
        AppLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun AppLayoutDarkThemePreview() {
    LitrosDeAguaTheme(darkTheme = true) {
        AppLayout()
    }
}