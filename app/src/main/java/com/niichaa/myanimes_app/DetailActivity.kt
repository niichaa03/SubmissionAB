package com.niichaa.myanimes_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_ANIME = "key_anime"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        @Suppress
        val dataAnime = intent.getParcelableExtra<Anime>("key_anime") as Anime

        val tvTitleDetail: TextView = findViewById(R.id.tv_titleDetail)
        val tvDescriptionDetail: TextView = findViewById(R.id.tv_descriptionDetail)
        val tvPhotoDetail: ImageView = findViewById(R.id.tv_photoDetail)
        val tvStatusDetail: TextView = findViewById(R.id.tv_statusDetail)
        val tvSkorDetail: TextView = findViewById(R.id.tv_skorDetail)

        tvTitleDetail.text = dataAnime.title
        tvDescriptionDetail.text = dataAnime.description
        tvPhotoDetail.setImageResource(dataAnime.photo)
        tvStatusDetail.text = dataAnime.status
        tvSkorDetail.text = dataAnime.skor

    }
}