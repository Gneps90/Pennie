package com.jash.core.presentation.designsystem.componants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jash.core.presentation.designsystem.ArrowLeftIcon
import com.jash.core.presentation.designsystem.LogoIcon
import com.jash.core.presentation.designsystem.LogoutIcon
import com.jash.core.presentation.designsystem.PennieTheme
import com.pennie.core.presentation.designsystem.R
import com.jash.core.presentation.designsystem.Satoshi
import com.jash.core.presentation.designsystem.componants.utils.DropDownItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PennieToolbar(
    showBackButton: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    menuItems: List<DropDownItem> = emptyList(),
    onMenuItemClick: (Int) -> Unit = {},
    onBackClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    startContent: (@Composable () -> Unit)? = null

){
    var isDropDownOpen by rememberSaveable {
        mutableStateOf(false)
    }
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                startContent?. invoke()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.primary,
                    fontFamily = Satoshi,
                )
            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if(showBackButton){
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ArrowLeftIcon,
                        contentDescription = stringResource(id = R.string.go_back),
                        tint = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        },
        actions = {
            if(menuItems.isNotEmpty()){
                Box {
                    DropdownMenu(
                        expanded = isDropDownOpen,
                        onDismissRequest = {
                            isDropDownOpen = false
                        }
                    ) {
                        menuItems.forEachIndexed { index, item ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .clickable { onMenuItemClick(index) }
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ){
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = item.title)
                            }
                        }
                    }
                    IconButton(onClick =  {
                        isDropDownOpen = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = stringResource(id = R.string.open_menu),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun PennieToolbarPreview() {
    PennieTheme {
        PennieToolbar(
            showBackButton = false,
            title = "pennie",
            modifier = Modifier.fillMaxWidth(),
            startContent = {
                Icon(
                    imageVector = LogoIcon,
                    contentDescription = null
                )
            },
            menuItems = listOf(
                DropDownItem(
                    icon = LogoutIcon,
                    title = "Log Out"
                )
            )
        )
    }
}