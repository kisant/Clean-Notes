package com.kis.cleannotes.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kis.cleannotes.R
import com.kis.cleannotes.core.domain.model.Note
import com.kis.cleannotes.core.ui_kit.composables.CreateFloatingActionButton
import com.kis.cleannotes.core.ui_kit.composables.NoteItem
import com.kis.cleannotes.core.ui_kit.composables.TopBar
import com.kis.cleannotes.home.di.HomeScreenModule

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onCreateNoteFloatingActionButtonClick: () -> Unit,
    onDeleteNoteButtonClick: (Note) -> Unit,
    onNoteClick: (String) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.shadow(4.dp),
                title = stringResource(R.string.main_toolbar_title)
            )
        },
        floatingActionButton = {
            CreateFloatingActionButton {
                onCreateNoteFloatingActionButtonClick()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            when (uiState) {
                is HomeUiState.Empty ->  HomeScreenEmpty()
                is HomeUiState.Content -> HomeScreenContent(
                    notes = uiState.notes,
                    onDeleteNoteButtonClick = onDeleteNoteButtonClick,
                    onNoteClick = onNoteClick
                )
            }
        }
    }
}

@Composable
private fun HomeScreenEmpty(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.do_not_have_any_notes_banner),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 27.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onDeleteNoteButtonClick: (Note) -> Unit,
    onNoteClick: (String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(notes) { index, note ->
            NoteItem(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .clickable { onNoteClick(note.id.toString()) },
                title = note.title,
                description = note.description,
                onDeleteButtonClick = { onDeleteNoteButtonClick(note) }
            )
        }
    }
}