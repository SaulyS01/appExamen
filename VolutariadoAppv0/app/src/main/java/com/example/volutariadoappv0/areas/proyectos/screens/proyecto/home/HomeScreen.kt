package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.volutariadoappv0.areas.proyectos.screens.Screen
import com.example.volutariadoappv0.R
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home.components.ProyectoItem

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = { navController.navigate(Screen.Edit.route) }
            )
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteProyecto = { viewModel.onEvent(HomeEvent.DeleteProyecto(it)) },
                onEditProyecto = {
                    navController.navigate(
                        route = Screen.Edit.passId(it)
                    )
                },
                proyectos = state.proyectos
            )
        }
    )
}


@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.proyectos),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteProyecto: (proyecto: Proyecto) -> Unit,
    onEditProyecto: (id: Int?) -> Unit,
    proyectos: List<Proyecto> = emptyList()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(proyectos) { proyecto ->
                ProyectoItem(
                    proyecto = proyecto,
                    onEditProyecto = { onEditProyecto(proyecto.id) },
                    onDeleteProyecto = { onDeleteProyecto(proyecto) }
                )
            }
        }
    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {  }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_proyecto))
    }
}