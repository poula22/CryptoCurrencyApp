package com.test.cryptocurrancyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.common.Constants
import com.test.common.Resource
import com.test.domain.use_case.get_coin.GetCoinByIdUseCase
import com.test.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) :ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState>
        get() = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId:String) {
        getCoinByIdUseCase(coinId).onEach {result->
            when(result){
                is Resource.Success -> {
                    _state.value=CoinDetailState(coin = result.data)
                }
                is Resource.Error ->{
                    _state.value=CoinDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value=CoinDetailState(isLoading = false)
                }
            }

        }.launchIn(viewModelScope)
    }
}