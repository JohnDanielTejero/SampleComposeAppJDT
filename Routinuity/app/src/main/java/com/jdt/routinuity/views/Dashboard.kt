package com.jdt.routinuity.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jdt.routinuity.DashboardHeader
import com.jdt.routinuity.R
import com.jdt.routinuity.components.context.CategorySelector
import com.jdt.routinuity.dashboard.HabitCard
import com.jdt.routinuity.dashboard.MenuFloat
import com.jdt.routinuity.dashboard.ProgressCard
import com.jdt.routinuity.experimental.HabitForm
import com.jdt.routinuity.ui.theme.RoutinuityTheme
import kotlinx.coroutines.launch
import java.time.LocalDate
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){

    val today = LocalDate.now()

    var selectedDay by remember { mutableStateOf(value = today) }
    var activeCategory by remember { mutableStateOf("Daily") }

    var showModalForm by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    var modalView by remember { mutableStateOf("") }
    var targetHabit by remember { mutableIntStateOf(-1) }

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ){
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item{
                if (showModalForm) {
                    ModalBottomSheet(
                        onDismissRequest = {
                            showModalForm = false
                        },
                        sheetState = sheetState,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp)
                    ) {
                        when {
                            (modalView == "habit-form") -> {
                                val item = if (targetHabit != -1) targetHabit else null
                                HabitForm(
                                    onCollapse = {
                                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                                            if (!sheetState.isVisible) {
                                                showModalForm = false
                                                modalView = ""
                                            }
                                        }
                                    },
                                    targetId = item,
                                    labels = listOf(
                                        "Label 1" to Color.Red,
                                        "Label 2" to Color.Green,
                                        "Label 3" to Color.Blue,
                                        "Label 4" to Color.Yellow,
                                        "Label 5" to Color.Magenta,
                                    ),
                                )
                            }
                        }

                    }
                }

                DashboardHeader(
                    today = today,
                    selectedDay = selectedDay,
                    textColor = MaterialTheme.colorScheme.background,
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    name = "John Doe",
                    changeSelectedDay = { value ->
                        selectedDay = value
                    }
                )

                Spacer(Modifier.height(10.dp).fillMaxWidth())

                CategorySelector { value ->
                    activeCategory = value
                }

                Spacer(Modifier.height(10.dp).fillMaxWidth())
                ProgressCard(
                    progress = 0.4f,
                    background = MaterialTheme.colorScheme.primary,
                    progressColor = MaterialTheme.colorScheme.background
                )
                Spacer(Modifier.height(10.dp).fillMaxWidth())

                for (i in 1..5) {

                    val icons = intArrayOf(R.drawable.ic_quantity, R.drawable.ic_repetition, R.drawable.ic_timer)
                    val delimiters = arrayOf("Quantity", "Times", "Minutes")
                    val randomIndex = Random.nextInt(0, icons.size - 1)
                    val progress = Random.nextInt(0, 10)

                    HabitCard(
                        progressColor = Color.Red.copy(alpha = 0.4f),
                        progress = progress,
                        icon = icons[randomIndex],
                        label = "Example Label",
                        requirement = 10,
                        delimiter = delimiters[randomIndex],
                        onClick = {
                            targetHabit = i
                            modalView = "habit-form"
                            showModalForm = true
                        }
                    )
                    Spacer(Modifier.height(10.dp).fillMaxWidth())
                }
            }

        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(50.dp)
        ){
            MenuFloat(
                onMenuClick = { page ->
                    showModalForm = true
                    modalView = page
                },
                backgroundColor = MaterialTheme.colorScheme.primary,
                foregroundColor = MaterialTheme.colorScheme.background
            )
        }

    }
}

@Preview
@Composable
fun DashboardScreenPreview(){
    val navController = rememberNavController()
    RoutinuityTheme {
        DashboardScreen(navController)
    }
}

