package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.domain.uses.GetProyecto
import com.example.volutariadoappv0.areas.proyectos.domain.uses.InsertProyecto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getProyecto: GetProyecto,
    private val insertProyecto: InsertProyecto,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _proyecto = mutableStateOf(TextFieldState())
    val proyecto: State<TextFieldState> = _proyecto

    private val _costo = mutableStateOf(TextFieldState())
    val costo: State<TextFieldState> = _costo

    private val _fe_inicio = mutableStateOf(TextFieldState())
    val fe_inicio: State<TextFieldState> = _fe_inicio

    private val _fe_fin = mutableStateOf(TextFieldState())
    val fe_fin: State<TextFieldState> = _fe_fin

    private val _estado = mutableStateOf(TextFieldState())
    val estado: State<TextFieldState> = _estado

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentProyectoId: Int? = null

    init {
        savedStateHandle.get<Int>("proyectoId")?.let { proyectoId ->
            if (proyectoId != -1) {
                viewModelScope.launch {
                    getProyecto(proyectoId)?.also { proyectoU ->
                        currentProyectoId = proyectoU.id
                        _proyecto.value = proyecto.value.copy(
                            text = proyectoU.proyecto
                        )
                        _costo.value = costo.value.copy(
                            text = proyectoU.costo.toString()
                        )
                        _fe_inicio.value = fe_inicio.value.copy(
                            text = proyectoU.fe_inicio
                        )
                        _fe_fin.value = fe_fin.value.copy(
                            text = proyectoU.fe_fin
                        )
                        _estado.value = estado.value.copy(
                            text = proyectoU.estado
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent) {
        when (event) {
            is EditEvent.EnteredProyecto -> {
                _proyecto.value = proyecto.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredCosto -> {
                _costo.value = costo.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredFeInicio -> {
                _fe_inicio.value = fe_inicio.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredFeFin -> {
                _fe_fin.value = fe_fin.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredEstado -> {
                _estado.value = estado.value.copy(
                    text = event.value
                )
            }
            EditEvent.InsertProyecto -> {
                viewModelScope.launch {
                    insertProyecto(
                        Proyecto(
                            proyecto = proyecto.value.text,
                            costo = costo.value.text.toInt(),
                            fe_inicio = fe_inicio.value.text,
                            fe_fin = fe_inicio.value.text,
                            estado = estado.value.text,
                            id = currentProyectoId
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveProyecto)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveProyecto: UiEvent()
    }
}