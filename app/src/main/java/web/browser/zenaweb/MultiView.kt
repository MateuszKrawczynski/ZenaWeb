package web.browser.zenaweb

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import web.browser.zenaweb.databinding.ActivityMultiViewBinding

class MultiView : AppCompatActivity() {
    lateinit var binding: ActivityMultiViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
            fun SetWebViewHeights(){
                val __one_third_match_parent__ = (binding.root.height.toInt())/2.5
                binding.web1.layoutParams.height = __one_third_match_parent__.toInt()
                binding.web2.layoutParams.height = __one_third_match_parent__.toInt()
            }

        binding.root.post(){SetWebViewHeights()}
        val myWebView1: WebView = binding.web1
        myWebView1.settings.javaScriptEnabled = true
        myWebView1.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        val myWebView2: WebView = binding.web2
        myWebView2.settings.javaScriptEnabled = true
        myWebView2.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        }
        myWebView1.loadUrl("https://www.google.com/")
        myWebView2.loadUrl("https://www.google.com/")
        //
        binding.search1.setOnClickListener() { myWebView1.loadUrl(binding.urlbar.text.toString())}
        binding.search2.setOnClickListener() { myWebView2.loadUrl(binding.urlbar.text.toString())}



    }
}