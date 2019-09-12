package com.kenshin.materialcardviewbug

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.kenshin.materialcardviewbug.MainActivity.Companion.USE_MATERIAL_CARDS

class LauncherActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {

        val id = v?.id
        val intent = Intent(this, MainActivity::class.java)

        when(id) {
            R.id.btnCardView -> {
                intent.putExtra(USE_MATERIAL_CARDS, false)
            }
            R.id.btnMaterialCardView -> {
                intent.putExtra(USE_MATERIAL_CARDS, true)
            }
        }

        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val btnMaterialCardView = findViewById<MaterialButton>(R.id.btnMaterialCardView)
        val btnCardView = findViewById<MaterialButton>(R.id.btnCardView)

        btnMaterialCardView.setOnClickListener(this)
        btnCardView.setOnClickListener(this)


    }
}
