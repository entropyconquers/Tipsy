package com.entropylabs.tipsy_tip_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.entropylabs.tipsy_tip_calculator.ui.theme.Tipsy_tip_calculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}
@Composable
fun PercentButton(selected: Boolean, percent: String){
    //true or false
    Column(
        Modifier
            .background(
                color = if (selected) colorResource(R.color.main_color) else Color.White,
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Text(
            "$percent %",
            color = if (!selected) colorResource(R.color.main_color) else Color.White,
            fontFamily = FontFamily(Font(R.font.gilroymedium)),
            fontSize = 21.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun MainView() {
    var textvalue = remember{ mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.background)
            )
    ) {
        Image(
            painterResource(id = R.drawable.bg_asset),
            "bg_asset",
            modifier = Modifier.fillMaxWidth()
        )
        Column() {
            Column(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()

            ){
                Image(painter = painterResource(id = R.drawable.tipsy),
                    contentDescription = "logo",

                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    "Enter bill total",
                    color = colorResource(id = R.color.text_heading),
                    fontFamily = FontFamily(Font(R.font.gilroybold)),
                    fontSize = 38.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                TextField(value = textvalue.value, onValueChange =  {
                    textvalue.value = it
                }, modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFFB7E2C6),
                        shape = RoundedCornerShape(10.dp)
                    )
                )
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    "Choose tip",
                    color = colorResource(id = R.color.text_heading),
                    fontFamily = FontFamily(Font(R.font.gilroybold)),
                    fontSize = 38.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(

                ){
                    PercentButton(selected = false, percent = "15")
                    Spacer(modifier = Modifier.width(20.dp))
                    PercentButton(selected = false, percent = "20")
                    Spacer(modifier = Modifier.width(20.dp))
                    PercentButton(selected = true, percent = "25")
                }


            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        colorResource(id = R.color.bg_overlay),
                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
                    )

                ,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Column(
                    Modifier.padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Your total bill is",
                        color = colorResource(id = R.color.text_subheading),
                        fontFamily = FontFamily(Font(R.font.gilroymedium)),
                        fontSize = 28.sp
                    )
                    Text(
                        "625",
                        color = colorResource(id = R.color.background_muted),
                        fontFamily = FontFamily(Font(R.font.gilroybold)),
                        fontSize = 78.sp
                    )
                }
                Column(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.text_subheading))
                ) {}
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                    ,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "bill",
                            color = colorResource(id = R.color.text_subheading),
                            fontFamily = FontFamily(Font(R.font.gilroymedium)),
                            fontSize = 20.sp
                        )
                        Text(
                            "500",
                            color = colorResource(id = R.color.background_muted),
                            fontFamily = FontFamily(Font(R.font.gilroybold)),
                            fontSize = 32.sp
                        )
                    }
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "tip",
                            color = colorResource(id = R.color.text_subheading),
                            fontFamily = FontFamily(Font(R.font.gilroymedium)),
                            fontSize = 20.sp
                        )
                        Text(
                            "125",
                            color = colorResource(id = R.color.background_muted),
                            fontFamily = FontFamily(Font(R.font.gilroybold)),
                            fontSize = 32.sp
                        )
                    }
                }
            }
        }

        /*Text(
            text = "Hello World",
            fontFamily = FontFamily(Font(R.font.gilroybold))

        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tipsy_tip_calculatorTheme {
        MainView()
    }
}