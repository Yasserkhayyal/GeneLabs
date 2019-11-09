package com.example.geneLabs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geneLabs.api.GeneLabsResponse
import com.example.geneLabs.models.DataRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SharedViewModel() : ViewModel() {
    val response = MutableLiveData<GeneLabsResponse>()
    val showLoading = MutableLiveData<Boolean>().apply {
        value = false
    }
    val error = MutableLiveData<String>()
    private val repository = DataRepository()
    private val disposables = arrayListOf<Disposable>()

    fun getData() {
        val newDisposable = repository.getData()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                setShowLoading(true)
            }.doOnDispose {
                setShowLoading(false)
            }.subscribe({
                setShowLoading(false)
                response.value = it
            }, {
                setShowLoading(false)
                error.value = it.message ?: "unknown error"
            })
        disposables.add(newDisposable)
    }


    private fun setShowLoading(enabled: Boolean) {
        showLoading.value = enabled
    }

    fun getDataForSearchKey(text: String): List<GeneLabsResponse.Hits.Hit> {
        val geneLabsResponse = response.value
        val findings = arrayListOf<GeneLabsResponse.Hits.Hit>()
        geneLabsResponse?.hits?.hits?.forEach { hit ->
            findings.add(hit)
        }
        return findings
    }

    override fun onCleared() {
        disposables.clear()
    }
}