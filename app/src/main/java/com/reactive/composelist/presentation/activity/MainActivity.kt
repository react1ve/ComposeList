package com.reactive.composelist.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.reactive.composelist.di.ItemViewModelFactory
import com.reactive.composelist.domain.repository.ItemRepositoryImpl
import com.reactive.composelist.domain.usecase.GetItemsUseCase
import com.reactive.composelist.presentation.screens.detail.ItemDetailScreen
import com.reactive.composelist.presentation.screens.list.ItemListScreen
import com.reactive.composelist.presentation.screens.list.ItemViewModel
import com.reactive.composelist.presentation.theme.ComposeListTheme

@ExperimentalCoilApi
@ExperimentalAnimationApi
class MainActivity: ComponentActivity() {

    private val itemViewModel : ItemViewModel by viewModels {
        ItemViewModelFactory(
            GetItemsUseCase(
                ItemRepositoryImpl()
            )
        )
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeListTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHostScreen(navController, itemViewModel)
                }
            }
        }
    }
}

@ExperimentalCoilApi
@ExperimentalAnimationApi
@Composable
fun NavHostScreen(navController : NavHostController, itemViewModel : ItemViewModel) {
    NavHost(navController = navController, startDestination = "item_list") {
        composable("item_list") {
            ItemListScreen(viewModel = itemViewModel, navController = navController)
        }
        composable("item_detail/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toInt() ?: 0
            val item = itemViewModel.items.value.first { it.id == itemId }
            ItemDetailScreen(item)
        }
    }
}

