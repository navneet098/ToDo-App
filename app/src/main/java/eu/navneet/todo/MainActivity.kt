package eu.navneet.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }
        addTask.setOnClickListener{
            val intent =Intent(this,NewTask::class.java)
            startActivity(intent)
        }


        recycler_view.adapter=Adapter(Data.getAllData())
        recycler_view.layoutManager=LinearLayoutManager(this)
    }
}