package eu.navneet.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_task.*

class EditTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = Data.getData(pos).title
            val priority = Data.getData(pos).priority
            task_name.setText(title)
            task_priority.setText(priority)


            delete_button.setOnClickListener {
                Data.deleteData(pos)
                myIntent()
            }
            update_button.setOnClickListener {
                Data.updateData(pos, task_name.text.toString(), task_priority.text.toString())
                myIntent()
            }
        }

    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}