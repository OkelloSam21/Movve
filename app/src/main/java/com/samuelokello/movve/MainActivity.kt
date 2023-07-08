package com.samuelokello.movve

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuelokello.movve.ui.theme.MovveTheme

class MainActivity : ComponentActivity() {
	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MovveTheme {
					Scaffold(
						containerColor = Color.Black,
						topBar = {
						TopAppBar(
							modifier = Modifier.padding(4.dp),
							colors = TopAppBarDefaults.smallTopAppBarColors(
								containerColor = Color.Black,
							),
							navigationIcon = {
								Row {
									Text(
										text = "Mov",
										fontWeight = FontWeight.ExtraBold,
										fontSize = 32.sp,
										color = Color.White,
									)
									Text(
										text = "ve",
										fontWeight = FontWeight.ExtraBold,
										fontSize = 32.sp,
										color = Color.Red,
									)
								}
							},
							actions ={
								Image(
									imageVector = Icons.Filled.Search,
									modifier = Modifier.size(40.dp),
									colorFilter = ColorFilter.tint(Color.White),
									contentDescription = null,
								)
							},title = {})
					}) { PaddingValues ->
						LazyColumn(
							modifier = Modifier
								.fillMaxSize()
								.padding(PaddingValues),
							
							){
							item {
								Text(
									text = "Popular Movie",
									fontSize = 24.sp,
									color = Color.White,
								)
								Spacer(modifier = Modifier.height(8.dp))
								LazyRow(
									contentPadding = PaddingValues(horizontal = 8.dp),
									
									){
									items(movieList){ movie ->
										MovieCollection(
											movie = movie
										)
										Spacer(modifier = Modifier.width(16.dp))
									}
								}
							}
							item {
								Text(
									text = "TV Show",
									fontSize = 24.sp,
									color = Color.White,
								)
								Spacer(modifier = Modifier.height(8.dp))
								LazyRow(
									contentPadding = PaddingValues(horizontal = 8.dp),
									
									){
									items(movieList){ movie ->
										MovieCollection(
											movie = movie
										)
										Spacer(modifier = Modifier.width(16.dp))
									}
								}
							}
							item {
								Text(
									text = "Popular Movie",
									fontSize = 24.sp,
									color = Color.White,
								)
								Spacer(modifier = Modifier.height(8.dp))
								LazyRow(
									contentPadding = PaddingValues(horizontal = 8.dp),
									
									){
									items(movieList){ movie ->
										MovieCollection(
											movie = movie
										)
										Spacer(modifier = Modifier.width(16.dp))
									}
								}
							}
							item {
								Text(
									text = "Series",
									fontSize = 24.sp,
									color = Color.White
								)
								Spacer(modifier = Modifier.height(8.dp))
								LazyRow(
									contentPadding = PaddingValues(horizontal = 8.dp),
									
									){
									items(movieList){ movie ->
										MovieCollection(
											movie = movie
										)
										Spacer(modifier = Modifier.width(16.dp))
									}
								}
							}
						}
					}
			}
		}
	}
	
	data class Movie(val title: String, val year: String, val imageResId: Int)
	
	private val movieList = listOf(
		Movie("Black Adam ", "2023 ", R.drawable.movie1),
		Movie("Die Hart", "2023 ", R.drawable.diehart),
		Movie("Mummies", "2023 ", R.drawable.content_mummies_movie),
		Movie("Fast X", "2023 ", R.drawable.download),
		Movie("Jocker", "2022", R.drawable.jocker),
		Movie("Luna","2023 ", R.drawable.luna),
		Movie("Spider Man","2022 ", R.drawable.sm_across_sv_final_2023),
		Movie("Up Coming","2022", R.drawable.upcomming),
		Movie("Tourist Guide","2022 ", R.drawable.touristguide),
	)
	
	@Composable
	fun MovieCollection(movie: Movie) {
		Column(
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Card(
				modifier = Modifier
					.width(150.dp)
					.height(250.dp),
			) {
				Image(
					modifier = Modifier.fillMaxSize(),
					painter = painterResource(id = movie.imageResId),
					contentDescription = null,
					contentScale = ContentScale.Crop
				)
			}
			Text(
				text = movie.title,
				color = Color.White,
			)
			Text(
				text = movie.year,
				color = Color.Gray,
			)
		}

	}
}