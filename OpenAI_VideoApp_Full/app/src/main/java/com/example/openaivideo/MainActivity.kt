package com.example.openaivideo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiKey = loadApiKey()

        setContent {
            var prompt by remember { mutableStateOf("") }
            var url by remember { mutableStateOf("") }

            Column(Modifier.padding(20.dp)) {
                OutlinedTextField(value=prompt,onValueChange={prompt=it},label={Text("프롬프트")})
                Spacer(Modifier.height(10.dp))
                Button(onClick={
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val service = RetrofitClient.create(apiKey)
                            val resp = service.generate(VideoRequest(prompt=prompt))
                            url = resp.video_url
                        } catch(e:Exception){}
                    }
                }){ Text("생성") }

                if(url.isNotEmpty()){
                    Spacer(Modifier.height(20.dp))
                    Button(onClick={ Downloader.download(this@MainActivity,url) }) {
                        Text("다운로드")
                    }
                }
            }
        }
    }

    fun loadApiKey():String {
        val props = Properties()
        val file = java.io.File("/mnt/data/android_project_full_v2/local.properties")
        if(file.exists()) props.load(file.inputStream())
        return props.getProperty("OPENAI_API_KEY","YOUR_KEY")
    }
}
