package com.kenshin.materialcardviewbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val USE_MATERIAL_CARDS = "USE_MATERIAL_CARDS"
    }

    private val materialCardObjectList by lazy {
        val list = mutableListOf<MaterialCardObject>()
        resources.getStringArray(R.array.objectList).forEach {
            list.add(MaterialCardObject(it))
        }
        list
    }

    private val adapter by lazy {
        MaterialCardViewListAdapter(intent.getBooleanExtra(USE_MATERIAL_CARDS, false))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMaterialCards = findViewById<RecyclerView>(R.id.rvMaterialCards)
        val lm = LinearLayoutManager(this)
        rvMaterialCards.layoutManager = lm
        rvMaterialCards.isNestedScrollingEnabled = true
        rvMaterialCards.adapter = adapter
        adapter.submitList(materialCardObjectList)
    }
}
