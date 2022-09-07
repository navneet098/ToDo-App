package eu.navneet.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        save.setOnClickListener{
            if(task_name.text.toString().trim{it<=' '}.isNotEmpty()
                && task_priority.text.toString().trim{it<=' '}.isNotEmpty())   {

                var title=task_name.getText().toString()
                var priority=task_priority.getText().toString()
                Data.setData(title,priority)
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
        }
    }
}