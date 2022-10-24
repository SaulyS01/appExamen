package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.volutariadoappv0.R
import com.example.volutariadoappv0.areas.proyectos.domain.uses.InsertProyecto
import com.example.volutariadoappv0.areas.proyectos.screens.proyecto.edit.components.ProyectoInputText
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val proyectoState = viewModel.proyecto.value
    val costoState = viewModel.costo.value
    val feInicioState = viewModel.fe_inicio.value
    val feFinState = viewModel.fe_fin.value
    val estadoState = viewModel.estado.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveProyecto -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = stringResource(id = R.string.add_proyecto)
            )
        },
        content = {
            EditContent(
                proyecto = proyectoState.text,
                costo = costoState.text,
                feInicio = feInicioState.text,
                feFin = feFinState.text,
                estado = estadoState.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            EditBottomBar(
                onInsertProyecto = { viewModel.onEvent(EditEvent.InsertProyecto) }
            )
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditContent(
    proyecto: String,
    costo: String,
    feInicio: String,
    feFin: String,
    estado: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        ProyectoInputText(
            text = proyecto,
            hint = stringResource(id = R.string.proyecto),
            onTextChange = { onEvent(EditEvent.EnteredProyecto(it)) }
        )
        ProyectoInputText(
            text = costo,
            hint = stringResource(id = R.string.costo),
            onTextChange = { onEvent(EditEvent.EnteredCosto(it)) }
        )
        ProyectoInputText(
            text = feInicio,
            hint = stringResource(id = R.string.feInicio),
            onTextChange = { onEvent(EditEvent.EnteredFeInicio(it)) }
        )
        ProyectoInputText(
            text = feFin,
            hint = stringResource(id = R.string.feFin),
            onTextChange = { onEvent(EditEvent.EnteredFeFin(it)) }
        )
        ProyectoInputText(
            text = estado,
            hint = stringResource(id = R.string.estado),
            onTextChange = { onEvent(EditEvent.EnteredEstado(it)) }
        )
    }
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertProyecto: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertProyecto() }
    ) {
        Text(text = stringResource(id = R.string.add_proyecto))
    }
}