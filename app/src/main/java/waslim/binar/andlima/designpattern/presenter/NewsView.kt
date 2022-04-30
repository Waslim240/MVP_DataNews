package waslim.binar.andlima.designpattern.presenter

import waslim.binar.andlima.designpattern.model.GetAllNewsItem

interface NewsView {

    fun onSuccess(pesan : String, news : List<GetAllNewsItem>)
    fun onError(pesan : String)
}