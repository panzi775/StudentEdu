package com.example.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.demo.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


        binding.buttonSecond.width
        binding.buttonSecond.width = 200

        // 使用View的内置动画方法
        binding.buttonSecond.animate()
            .alpha(0f)
            .setDuration(1000L)
            .withEndAction {

            }
            .start()


        // 在 onViewCreated 里
        Glide.with(this)
            .load("https://example.com/image.jpg")
            .preload()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}