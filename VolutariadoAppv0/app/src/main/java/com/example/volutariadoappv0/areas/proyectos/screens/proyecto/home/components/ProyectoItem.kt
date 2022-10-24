package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home.HomeEvent

@Composable
fun ProyectoItem(
    modifier: Modifier = Modifier,
    proyecto: Proyecto,
    onEditProyecto: () -> Unit,
    onDeleteProyecto: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${proyecto.proyecto}, ${proyecto.estado}",
                    style = MaterialTheme.typography.h6
                    
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = proyecto.fe_fin,
                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
                )
            }
            Row {
                IconButton(onClick = onEditProyecto) {
                   Icon(imageVector = Icons.Filled.Edit, contentDescription = null, tint = Color.Green)
               }
                IconButton(onClick = onDeleteProyecto) {
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = null, tint = Color.Red)
                }

            }
        }
    }
}