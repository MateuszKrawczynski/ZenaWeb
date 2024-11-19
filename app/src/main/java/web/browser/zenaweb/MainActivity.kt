 package web.browser.zenaweb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import web.browser.zenaweb.databinding.ActivityMainBinding
import android.content.pm.PackageManager
import android.net.Uri
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

 class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun readFromFile(context: Context, fileName: String): String {
            return context.openFileInput(fileName).bufferedReader().use { input ->
                input.readText()
            }
        }
        fun writeToFile(context: Context, fileName: String, content: String) {
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                output.write(content.toByteArray())
            }}
        fun ButtonActions(){
            binding.search.setOnClickListener() {
                val intent = Intent(applicationContext, BrowseInit::class.java)
                intent.putExtra("QUERY", binding.urlbar.text.toString())
                startActivity(intent)
            }
            binding.multi.setOnClickListener(){startActivity(Intent(applicationContext,MultiView::class.java)) }
            binding.settings.setOnClickListener(){ startActivity(Intent(applicationContext,Settings::class.java))}
            binding.short1.setOnClickListener(){
                val url = (readFromFile(applicationContext,"web1.txt").split("{;?;}"))[1]
                val intent = Intent(applicationContext,BrowseInit::class.java)
                intent.putExtra("URL",url)
                startActivity(intent)
            }
            binding.short2.setOnClickListener(){
                val url = (readFromFile(applicationContext,"web2.txt").split("{;?;}"))[1]
                val intent = Intent(applicationContext,BrowseInit::class.java)
                intent.putExtra("URL",url)
                startActivity(intent)
            }
            binding.short3.setOnClickListener(){
                val url = (readFromFile(applicationContext,"web3.txt").split("{;?;}"))[1]
                val intent = Intent(applicationContext,BrowseInit::class.java)
                intent.putExtra("URL",url)
                startActivity(intent)
            }
            binding.short4.setOnClickListener(){
                val url = (readFromFile(applicationContext,"web4.txt").split("{;?;}"))[1]
                val intent = Intent(applicationContext,BrowseInit::class.java)
                intent.putExtra("URL",url)
                startActivity(intent)
            }
            binding.facebook.setOnClickListener {
                val facebookPackage = "com.facebook.katana"
                val facebookUrl = "https://www.facebook.com"
                val facebookAppUri = "fb://facewebmodal/f?href=$facebookUrl"
                val context = this

                try {
                    context.packageManager.getPackageInfo(facebookPackage, 0)


                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookAppUri))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                } catch (e: PackageManager.NameNotFoundException) {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
                    context.startActivity(browserIntent)
                }
            }

            binding.youtube.setOnClickListener {
                val youtubePackage = "com.google.android.youtube"
                val youtubeUrl = "https://www.youtube.com"
                val youtubeAppUri = "vnd.youtube://"
                val context = this

                try {
                    context.packageManager.getPackageInfo(youtubePackage, 0)


                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeAppUri))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                } catch (e: PackageManager.NameNotFoundException) {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
                    context.startActivity(browserIntent)
                }
            }

            binding.tiktok.setOnClickListener {
                val tiktokPackage = "com.zhiliaoapp.musically"
                val tiktokUrl = "https://www.tiktok.com"
                val tiktokAppUri = "snssdk1128://feed/"
                val context = this

                try {
                    context.packageManager.getPackageInfo(tiktokPackage, 0)


                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tiktokAppUri))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                } catch (e: PackageManager.NameNotFoundException) {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tiktokUrl))
                    context.startActivity(browserIntent)
                }
            }

        }


        fun doesInternalFileExist(context: Context, fileName: String): Boolean {
            val file = File(context.filesDir, fileName)
            return file.exists()
        }


        fun AssignShortcuts(){
            var nickname: String
            nickname = (readFromFile(applicationContext,"web1.txt").split("{;?;}"))[0]
            binding.short1.setText(nickname)
            nickname = (readFromFile(applicationContext,"web2.txt").split("{;?;}"))[0]
            binding.short2.setText(nickname)
            nickname = (readFromFile(applicationContext,"web3.txt").split("{;?;}"))[0]
            binding.short3.setText(nickname)
            nickname = (readFromFile(applicationContext,"web4.txt").split("{;?;}"))[0]
            binding.short4.setText(nickname)
        }
        if(doesInternalFileExist(applicationContext,"web1.txt") == false) {writeToFile(applicationContext,"web1.txt","https://www.google.com")}
        if(doesInternalFileExist(applicationContext,"web2.txt") == false) {writeToFile(applicationContext,"web2.txt","https://www.google.com")}
        if(doesInternalFileExist(applicationContext,"web3.txt") == false) {writeToFile(applicationContext,"web3.txt","https://www.google.com")}
        if(doesInternalFileExist(applicationContext,"web4.txt") == false) {writeToFile(applicationContext,"web4.txt","https://www.google.com")}
        AssignShortcuts()
        ButtonActions()
    }











    }
