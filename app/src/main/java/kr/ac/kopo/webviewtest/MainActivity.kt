package kr.ac.kopo.webviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editUrl: EditText
    lateinit var btnGo: Button
    lateinit var btnPrev: Button
    lateinit var webV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUrl = findViewById<EditText>(R.id.editUrl)
        btnGo = findViewById<Button>(R.id.btnGo)
        btnPrev = findViewById<Button>(R.id.btnPrev)
        webV = findViewById<WebView>(R.id.webV)

        webV.webViewClient = PolyWebViewClient()

        var webSet = webV.settings
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener {
            webV.loadUrl(editUrl.text.toString())
        }

        btnPrev.setOnClickListener {
            webV.goBack()
        }
    }

    class PolyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}