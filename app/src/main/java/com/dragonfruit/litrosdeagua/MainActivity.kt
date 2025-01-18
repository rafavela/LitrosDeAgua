package com.dragonfruit.litrosdeagua

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dragonfruit.litrosdeagua.data.BehaviourList
import com.dragonfruit.litrosdeagua.ui.BehaviourComponent
import com.dragonfruit.litrosdeagua.ui.BehaviourLayout
import com.dragonfruit.litrosdeagua.ui.theme.LitrosDeAguaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LitrosDeAguaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BehaviourLayout(BehaviourList.behaviours)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LitrosDeAguaTheme {
        BehaviourLayout(BehaviourList.behaviours)
    }
}