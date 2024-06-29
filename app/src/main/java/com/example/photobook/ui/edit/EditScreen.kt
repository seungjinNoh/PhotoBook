package com.example.photobook.ui.edit

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.photobook.viewmodel.EditViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.Photo
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun AddPhoto(viewModel: EditViewModel = hiltViewModel()) {

    val title by viewModel.title.collectAsState()
    val photoUri by viewModel.photoUri.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TitleInput(title) { viewModel.updateTitle(it) }
            Spacer(modifier = Modifier.height(16.dp))
            PhotoPicker(photoUri = photoUri, onPhotoSelected = { viewModel.updatePhoto(it) })
        }
        Button(
            onClick = { viewModel.savePhoto(
                Photo(path = photoUri.toString(),
                    title = title,
                    id = 1,
                    w3w = "asd")
            ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Save")
        }
    }
}

@Composable
fun TitleInput(title: String, onTitleString: (String) -> Unit) {
    BasicTextField(
        value = title,
        onValueChange = onTitleString,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun PhotoPicker(photoUri: String?, onPhotoSelected: (String) -> Unit) {
    val context = LocalContext.current
    var imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val inputStream = context.contentResolver.openInputStream(it)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageBitmap.value = bitmap.asImageBitmap()
            onPhotoSelected(it.toString())
        }
    }


    if (photoUri != null) {
        val uri = Uri.parse(photoUri)
        val inputStream = context.contentResolver.openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        imageBitmap.value = bitmap.asImageBitmap()
    }
    
    Box(
        modifier = Modifier
            .size(200.dp)
            .clickable { launcher.launch("image/*") },
        contentAlignment = Alignment.Center,
    ) {
        if (imageBitmap.value != null) {
            Image(
                bitmap = imageBitmap.value!!,
                contentDescription = "선택된 사진",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Photo",
                modifier = Modifier.size(50.dp)
            )
        } 
    }
}