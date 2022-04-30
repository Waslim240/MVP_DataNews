package waslim.binar.andlima.designpattern.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.designpattern.model.GetAllNewsItem
import waslim.binar.andlima.designpattern.network.ApiClient

class NewsPresenter(val viewNews : NewsView) {

    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsItem>>,
                    response: Response<List<GetAllNewsItem>>
                ) {
                    if (response.isSuccessful){
                        viewNews.onSuccess(response.message(), response.body()!!)
                    } else {
                        viewNews.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsItem>>, t: Throwable) {
                    viewNews.onError(t.message!!)
                }

            })
    }

}