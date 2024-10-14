package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import com.example.my.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var state = 1
    var op1:Int = 0
    var op2:Int = 0
    var resul:Int=0
    var op:String = ""
    lateinit var textContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.button21).setOnClickListener(this)
        findViewById<Button>(R.id.button16).setOnClickListener(this)
        findViewById<Button>(R.id.button17).setOnClickListener(this)
        findViewById<Button>(R.id.button18).setOnClickListener(this)
        findViewById<Button>(R.id.button12).setOnClickListener(this)
        findViewById<Button>(R.id.button13).setOnClickListener(this)
        findViewById<Button>(R.id.button14).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.button10).setOnClickListener(this)
        findViewById<Button>(R.id.button19).setOnClickListener(this)
        findViewById<Button>(R.id.button15).setOnClickListener(this)
        findViewById<Button>(R.id.button11).setOnClickListener(this)
        findViewById<Button>(R.id.button23).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        textContent = findViewById(R.id.textView2)
    }

    override fun onClick(p0:View?){
        val id=p0?.id
        when(id){
            R.id.button21 -> addDigit(0)
            R.id.button16 -> addDigit(1)
            R.id.button17 -> addDigit(2)
            R.id.button18 -> addDigit(3)
            R.id.button12 -> addDigit(4)
            R.id.button13 -> addDigit(5)
            R.id.button14 -> addDigit(6)
            R.id.button8 -> addDigit(7)
            R.id.button9 -> addDigit(8)
            R.id.button10 -> addDigit(9)
            R.id.button19 -> changeToOp2("+")
            R.id.button15 -> changeToOp2("-")
            R.id.button11 -> changeToOp2("x")
            R.id.button7 -> changeToOp2("/")
            R.id.button23 -> calculate()
            R.id.button4 -> {
                if (state==1){
                    op1=0;
                    textContent.text="0"
                }else if(state==2){
                    op2=0;
                    textContent.text="0"
                }
            }
            R.id.button5 -> {
                state=1;
                op1=0;
                op2=0
                textContent.text="0"
            }
            R.id.button6 -> {
                if (state==1&&op1!=0){
                    op1=op1/10
                    textContent.text=op1.toString()
                }else if(state==2&&op2!=0){
                    op2=op2/10
                    textContent.text=op2.toString()
                }
            }
        }
    }

    fun changeToOp2(o:String){
        op=o;
        state=2;
        textContent.text="0"

    }

    fun addDigit(c:Int){
        if(state==1){
            op1=op1*10+c
            textContent.text = op1.toString()
        }else if(state==2){
            op2=op2*10+c
            textContent.text = op2.toString()
        }
    }

    fun calculate(){
        when(op){
            "+"-> resul = op1+ op2
            "-"-> resul = op1-op2
            "x"->resul=op1*op2
            "/"->resul=op1/op2

        }
        textContent.text=resul.toString()
        state=1;
        op1=resul 
        op2=0

    }
}