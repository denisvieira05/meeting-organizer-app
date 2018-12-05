package org.js.denisvieira.meeting_organizer.application.modules.selectguideline

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.databinding.SelectGuidelineActBinding

class SelectGuidelineActivity : AppCompatActivity() {

    private lateinit var mSelectGuidelineActBinding: SelectGuidelineActBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mSelectGuidelineActBinding = DataBindingUtil.setContentView(this,
                R.layout.select_guideline_act)

    }

}