package web.browser.zenaweb

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import web.browser.zenaweb.databinding.ActivityBrowseInitBinding

class BrowseInit : AppCompatActivity() {
    lateinit var binding: ActivityBrowseInitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowseInitBinding.inflate(layoutInflater)
        val intentval = intent.getStringExtra("QUERY")
        val intenturl = "https://www.google.com/search?q=$intentval"
        setContentView(binding.root)

        val myWebView: WebView = binding.web
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        if (intent.hasExtra("URL")) {myWebView.loadUrl(intent.getStringExtra("URL").toString())}
        else {myWebView.loadUrl(intenturl)}
    }
}