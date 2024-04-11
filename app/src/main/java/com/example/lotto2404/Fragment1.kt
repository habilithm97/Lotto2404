package com.example.lotto2404

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.lotto2404.databinding.Fragment1Binding
import kotlin.random.Random

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding
    private lateinit var mContext: MainActivity

    private val ballList : List<TextView> by lazy {
        listOf(binding.ball1, binding.ball2, binding.ball3,
            binding.ball4, binding.ball5, binding.ball6)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = Fragment1Binding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.btn.setOnClickListener {
            val lottoNums = createLottoNumber()
            Log.d("Fragment1", lottoNums.toString())
            setLottoNums(lottoNums)

            lottoNums.forEachIndexed { i, num ->
                val ball = ballList[i] // 각 TextView
                setBallColor(num, ball)
            }
        }
    }

    private fun createLottoNumber() : List<Int> {
        val result = mutableListOf<Int>()
        val nums = IntArray(45) {it + 1}
        nums.shuffle(Random(System.currentTimeMillis()))
        nums.slice(0..5).forEach { num -> result.add(num) }
        result.sort()
        return result
    }

    private fun setLottoNums(result: List<Int>) {
        with(binding) {
            ball1.text = result[0].toString()
            ball2.text = result[1].toString()
            ball3.text = result[2].toString()
            ball4.text = result[3].toString()
            ball5.text = result[4].toString()
            ball6.text = result[5].toString()
        }
    }

    private fun setBallColor(num: Int, ball: TextView) {
        when(num) {
            in 1..10 -> ball.background = ContextCompat.getDrawable(mContext, R.drawable.ball_yellow)
            in 11..20 -> ball.background = ContextCompat.getDrawable(mContext, R.drawable.ball_blue)
            in 21..30 -> ball.background = ContextCompat.getDrawable(mContext, R.drawable.ball_red)
            in 31..40 -> ball.background = ContextCompat.getDrawable(mContext, R.drawable.ball_gray)
            else -> ball.background = ContextCompat.getDrawable(mContext, R.drawable.ball_green)
        }
    }
}