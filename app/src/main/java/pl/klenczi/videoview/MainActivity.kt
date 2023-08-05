package pl.klenczi.videoview

import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.widget.MediaController
import android.widget.VideoView
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vV = findViewById<VideoView>(R.id.videoView)
        val mC = MediaController(this)
        mC.setAnchorView(vV)

        val uri: Uri? = parse("android.resource://"+packageName+"/"+R.raw.smietnik)
        vV.setMediaController(mC)
        vV.setVideoURI(uri)
        vV.requestFocus()
        vV.start()
    }
}