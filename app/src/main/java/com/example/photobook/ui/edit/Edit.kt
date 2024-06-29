package com.example.photobook.ui.edit

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.photobook.R
import com.example.photobook.utils.LogUtil
import com.example.photobook.viewmodel.EditViewModel

@Composable
fun Edit(
    upPress: () -> Unit,
    photoId: String = ""
) {

    /**
     * todo
     * 함수 자체를 2개 만든다(추가, 수정)
     * 그리고 각 컴포넌트마다 함수로 뺀다(제목입력, 지도 선택, 등등)
     */

    /**
     *  todo photoId로 DB의 값을 읽어오는 로직
     *  각각의 변수 상위 컴포저블에서 state 변수로 선언하기
     *  있으면 DB에서 데이터 읽어서 보여주기
     *  없으면 빈 화면으로 보여주기
     */


    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(text = "Edit Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Photo()
        ChoosePhoto()
        SelectedPhoto()
    }

}



//@Composable
//fun TitleInput(title: String, onTitleChange: (String) -> Unit) {
//    BasicTextField(
//        value = title,
//        onValueChange = onTitleChange,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    )
//}

@Composable
fun Photo() {
    Text(text = "Photo")
}

@Composable
fun ChoosePhoto() {

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            LogUtil.d("uri: $uri")
            selectedImageUri.value = uri
        }
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        //이미지 선택 버튼
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    singlePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )

        //이미지 보여지는 화면
        AsyncImage(
            model = selectedImageUri.value,
            contentDescription = null,
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun SelectedPhoto() {

}