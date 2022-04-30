package waslim.binar.andlima.designpattern.network

import retrofit2.Call
import retrofit2.http.GET
import waslim.binar.andlima.designpattern.model.GetAllNewsItem

interface ApiService {

    @GET ("news")
    fun getAllNews() : Call<List<GetAllNewsItem>>

}