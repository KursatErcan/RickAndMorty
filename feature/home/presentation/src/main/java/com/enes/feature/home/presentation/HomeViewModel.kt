package com.enes.feature.home.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.enes.common.data.util.onError
import com.enes.common.data.util.onSuccess
import com.enes.common.presentation.BaseViewModel
import com.enes.feature.home.domain.entity.ResultEntity
import com.enes.feature.home.domain.usecase.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val useCase: GetAllCharacterUseCase
) : BaseViewModel(application) {

    private val _characterList = MutableLiveData<List<ResultEntity>>()
    val characterList: LiveData<List<ResultEntity>> = _characterList

    fun getAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke()
                //.onStart { showIndicator() }
                .collect { result ->
                    result.onSuccess { success ->
                        val characters: ArrayList<ResultEntity> = arrayListOf()
                        success.data.results?.let { list ->
                            list.forEach { item ->
                                item?.let { characters.add(it) }
                            }

                        }
                        _characterList.postValue(characters)
                    }
                    result.onError {

                    }

                }
        }
    }

}