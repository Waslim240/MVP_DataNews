package waslim.binar.andlima.designpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_news.*
import waslim.binar.andlima.designpattern.R
import waslim.binar.andlima.designpattern.model.GetAllNewsItem

class DetailNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        detail()

    }

    private fun detail(){
        val detailNews = intent.getParcelableExtra<GetAllNewsItem>("DETAIL_NEWS")

        title_detail.text = detailNews?.title
        Glide.with(applicationContext).load(detailNews?.image).into(imageView_detail)
        createDate_detail.text = detailNews?.createdAt
        author_detail.text = detailNews?.author
        description.text = detailNews?.description
    }
}