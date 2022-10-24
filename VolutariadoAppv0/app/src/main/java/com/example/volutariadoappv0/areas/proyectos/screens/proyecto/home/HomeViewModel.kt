package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volutariadoappv0.areas.proyectos.domain.uses.DeleteProyecto
import com.example.volutariadoappv0.areas.proyectos.domain.uses.GetProyectos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteProyecto: DeleteProyecto,
    getProyectos: GetProyectos,
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getProyectos().onEach { proyectos ->
            _state.value = state.value.copy(
                proyectos = proyectos
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteProyecto -> {
                viewModelScope.launch {
                    deleteProyecto(event.proyecto)
                }
            }
        }
    }
}