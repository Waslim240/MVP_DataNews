package waslim.binar.andlima.designpattern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import waslim.binar.andlima.designpattern.R
import waslim.binar.andlima.designpattern.adapter.AdapterNews
import waslim.binar.andlima.designpattern.model.GetAllNewsItem
import waslim.binar.andlima.designpattern.presenter.NewsPresenter
import waslim.binar.andlima.designpattern.presenter.NewsView

class MainActivity : AppCompatActivity(), NewsView {
    private lateinit var presenterNewsPresenter: NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterNewsPresenter = NewsPresenter(this)
        presenterNewsPresenter.getDataNews()
    }

    override fun onSuccess(pesan: String, news: List<GetAllNewsItem>) {
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = AdapterNews(news){
            val pindah = Intent(this, DetailNews::class.java)
            pindah.putExtra("DETAIL_NEWS", it)
            startActivity(pindah)
        }
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }

}