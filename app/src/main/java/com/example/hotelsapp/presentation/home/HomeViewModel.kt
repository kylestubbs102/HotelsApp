package com.example.hotelsapp.presentation.home

import androidx.lifecycle.ViewModel
import com.example.hotelsapp.domain.repository.HotelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val hotelsRepository: HotelsRepository,
) : ViewModel() {

}
