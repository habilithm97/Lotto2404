package com.example.lotto2404

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lotto2404.databinding.Fragment1Binding
import kotlin.random.Random

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = Fragment1Binding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.btn.setOnClickListener {
            val lottoNums = createLottoNumber()
            Log.d("Fragment1", lottoNums.toString())
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
}