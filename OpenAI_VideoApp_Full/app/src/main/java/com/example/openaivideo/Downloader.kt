package com.example.openaivideo

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

object Downloader {
    fun download(context:Context, url:String) {
        val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val req = DownloadManager.Request(Uri.parse(url))
            .setTitle("video.mp4")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"video.mp4")
        dm.enqueue(req)
    }
}
