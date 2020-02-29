package com.example.lab_1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.text.StringBuilder

class MainAdapter (size: Int): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var size: Int

    init {
        this.size = size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val context: Context = parent.context

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.recycler_item, parent, false)

        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.bind(position + 1)
    }

    val numberText = arrayOf(
        arrayOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"),
        arrayOf("", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ",
            "семьдесят ", "восемьдесят ", "девяносто "),
        arrayOf("", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ",
            "семьсот ", "восемьсот ", "девятьсот "),
        arrayOf("тысяч ", "одна тысяча ", "две тысячи ", "три тысячи ", "четыре тысячи ",
            "пять тысяч ", "шесть тысяч ", "семь тысяч ", "восемь тысяч ", "девять тысяч "),
        arrayOf("", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ",
            "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "),
        arrayOf("", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ",
            "семьсот ", "восемьсот ", "девятьсот "))

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val number: TextView = itemView.findViewById(R.id.numberView)

        fun bind(n: Int) {// распределение цветов по четным и нечетным номерам
            var num = n
            number.setBackgroundColor(Color.WHITE)

            if (num % 2 != 0) {
                number.setBackgroundColor(Color.GRAY)
            } else if(num == 1_000_000) {
                number.text = "миллион"
                return
            }

            var str = StringBuilder()
            var element = 0
            var count = 0

            while(num != 0){
                element = num % 10
                num /= 10
                count++
                str.insert(0, numberText[count - 1][element])
            }

            var result = str.toString()

            var pattern = Pattern.compile("десять \\S* (тысячи|тысяча|тысяч)")
            var matcher = pattern.matcher(result)
            if (matcher.find()) {
                result = thousands(result)
            }
            pattern = Pattern.compile("десять (\\S{1,})$")
            matcher = pattern.matcher(result)
            if (matcher.find()) {
                result = dozens(result)
            }
            
            number.text = result
        }

        fun thousands(s: String): String{
            var str = s
            str = str.replace("десять одна тысяча", "одиннадцать тысяч")
            str = str.replace("десять две тысячи", "двенадцать тысяч")
            str = str.replace("десять три тысячи", "тринадцать тысяч")
            str = str.replace("десять четыре тысячи", "четырнадцать тысяч")
            str = str.replace("десять пять тысяч", "пятнадцать тысяч")
            str = str.replace("десять шесть тысяч", "шестнадцать тысяч")
            str = str.replace("десять семь тысяч", "семнадцать тысяч")
            str = str.replace("десять восемь тысяч", "восемнадцать тысяч")
            str = str.replace("десять девять тысяч", "девятнадцать тысяч")

            return str
        }

        fun  dozens(s: String): String{
            var str = s
            str = str.replace("десять один", "одиннадцать")
            str = str.replace("десять два", "двенадцать")
            str = str.replace("десять три", "тринадцать")
            str = str.replace("десять четыре", "четырнадцать")
            str = str.replace("десять пять", "пятнадцать")
            str = str.replace("десять шесть", "шестнадцать")
            str = str.replace("десять семь", "семнадцать")
            str = str.replace("десять восемь", "восемнадцать")
            str = str.replace("десять девять", "девятнадцать")

            return str
        }
    }
}