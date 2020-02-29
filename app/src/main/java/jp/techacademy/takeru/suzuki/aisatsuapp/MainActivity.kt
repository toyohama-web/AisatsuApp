package jp.techacademy.takeru.suzuki.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeButton.text = "Button"
        timeButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.timeButton) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (hour >= 2 && hour < 10 && minute >= 0) {
                    textView.setText("おはようございます")
                    Log.d("UI_PARTS", "$hour:$minute" + " / おはようございます")
                } else if (hour >= 10 && hour < 18 && minute >= 0) {
                    textView.setText("こんにちは")
                    Log.d("UI_PARTS", "$hour:$minute" + " / こんにちは")
                } else
                    textView.setText("こんばんは")
                Log.d("UI_PARTS", "$hour:$minute" + " / こんばんは")
            },
            0, 0, true)
        timePickerDialog.show()
    }
}
