package com.ksenia.wanderguide.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ksenia.wanderguide.domain.model.Note
import kotlinx.coroutines.NonCancellable.isCompleted

@Composable
fun NotesScreen(navController: NavController){
    Column(
        Modifier
            .fillMaxWidth()
    ) {
    }
}

@Composable
fun NotesList(navController: NavController, notes: List<Note>) {
    LazyColumn {
        items(notes, key = { it.id }) { note ->
            NoteListItem(
                isCompleted = note.isCompleted,
                text = note.text,
                onCheckedChange = { newState ->
                    viewModel.updateNoteCompletion(note.id, newState)
                },
                onTextClick = {
                    navController.navigate("editNote/${note.id}")
                }
            )
        }
    }
}

@Composable
fun NoteListItem(
    modifier: Modifier = Modifier,
    isCompleted: Boolean,
    text: String,
    onCheckedChange: ((Boolean) -> Unit)? = null,
    onTextClick: (() -> Unit)? = null,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Checkbox(
                checked = isCompleted,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.size(24.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.outline
                )
            )

            Text(
                text = text,
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTextClick?.invoke() },
                style = MaterialTheme.typography.bodyLarge.copy(
                    textDecoration = if (isCompleted) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                ),
                color = if (isCompleted) {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                } else {
                    MaterialTheme.colorScheme.onSurface
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}