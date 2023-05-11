package com.niichaa.myanimes_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_animes)
        rvAnime.setHasFixedSize(true)

        list.addAll(getListAnimes())
        showRecyclerList()
    }

    private fun getListAnimes(): ArrayList<Anime>{
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val dataSkor = resources.getStringArray(R.array.data_skor)
        val listAnime = ArrayList<Anime>()
        for (position in dataTitle.indices){
            val anime = Anime(dataTitle[position], dataDescription[position],
                dataPhoto.getResourceId(position, -1), dataStatus[position], dataSkor[position])
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = GridLayoutManager(this, 2)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {
                showSelectedAnime(data)
            }
        })
    }

    private fun showSelectedAnime(anime: Anime) {

//        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
//        val tvTitle: TextView = findViewById(R.id.tv_item_title)
//        val tvDescription: TextView = findViewById(R.id.tv_item_description)
//
//        tvTitle.text = anime.title
//        tvDescription.text = anime.description
//        imgPhoto.setImageResource(anime.photo)
//
//        var anime = ArrayList<Anime>()
//
//        val intent = Intent(this@MainActivity, DetailActivity::class.java)
//        intent.putParcelableArrayListExtra(DetailActivity.KEY_ANIME, anime)
//        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about -> {
                val me = Me(
                    "Hayatun Nisa",
                    "nisahayatun03022002@gmail.com"
                )
                val moveWithIntent = Intent(this@MainActivity, MeActivity::class.java)
                moveWithIntent.putExtra(MeActivity.EXTRA_ABOUT_ME, me)
                startActivity(moveWithIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }




}