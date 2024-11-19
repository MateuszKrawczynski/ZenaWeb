package web.browser.zenaweb

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import web.browser.zenaweb.databinding.ActivitySettingsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class Settings : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


            fun writeToFile(context: Context, fileName: String, content: String) {
                context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                    output.write(content.toByteArray())
                }}
                // getpacket() -> [nickname,url]
                fun getpacket(): Array<String>{ return arrayOf(binding.nickname.text.toString(),binding.url.text.toString())}
                fun visualreturn(deleting: Boolean){
                    if (deleting == true){
                        binding.output.setText("All shortcuts deleted!")
                        Handler().postDelayed({binding.output.setText("")},1500)
                    }
                    else{
                        binding.output.setText("Shortcut created!")
                        Handler().postDelayed({binding.output.setText("")},1500)
                    }
                }
        binding.web1.setOnClickListener(){
            val nickname = getpacket()[0].toString()
            val url = getpacket()[1].toString()
            writeToFile(this,"web1.txt","$nickname{;?;}$url")
            visualreturn(false)
        }
        binding.web2.setOnClickListener(){
            val nickname = getpacket()[0].toString()
            val url = getpacket()[1].toString()
            writeToFile(this,"web2.txt","$nickname{;?;}$url")
            visualreturn(false)
        }
        binding.web3.setOnClickListener(){
            val nickname = getpacket()[0].toString()
            val url = getpacket()[1].toString()
            writeToFile(this,"web3.txt","$nickname{;?;}$url")
            visualreturn(false)
        }
        binding.web4.setOnClickListener(){
            val nickname = getpacket()[0].toString()
            val url = getpacket()[1].toString()
            writeToFile(this,"web4.txt","$nickname{;?;}$url")
            visualreturn(false)
        }
        binding.del.setOnClickListener(){
            writeToFile(this,"web1.txt","Here will be  your favorite websites!{;?;}https://www.google.com")
            writeToFile(this,"web2.txt","Here will be  your favorite websites!{;?;}https://www.google.com")
            writeToFile(this,"web3.txt","Here will be  your favorite websites!{;?;}https://www.google.com")
            writeToFile(this,"web4.txt","Here will be  your favorite websites!{;?;}https://www.google.com")
            visualreturn(true)

        }







        }}
