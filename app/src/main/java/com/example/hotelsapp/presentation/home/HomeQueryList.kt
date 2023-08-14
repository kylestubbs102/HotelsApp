package com.example.hotelsapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.hotelsapp.R
import com.example.hotelsapp.domain.model.LocationQueryRow

@Composable
fun QueryLazyColumn(
    queryRows: List<LocationQueryRow>,
    onClick: (LocationQueryRow) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(top = 60.dp, start = 10.dp, end = 10.dp)) {
        items(queryRows) { queryRow ->
            QueryRow(queryRow = queryRow, onClick = onClick)
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Composable
fun QueryRow(
    queryRow: LocationQueryRow,
    onClick: (LocationQueryRow) -> Unit,
) {
    Row(modifier = Modifier
        .clickable {
            onClick(queryRow)
        }
        .background(Color.White)
        .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.location_icon_content_description),
            modifier = Modifier.padding(10.dp)
        )
        Column {
            Text(
                text = queryRow.location,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = queryRow.city, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}