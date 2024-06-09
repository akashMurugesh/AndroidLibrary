package com.akash.androidlibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akash.androidlibrary.R
import com.akash.androidlibrary.databinding.FragmentGlideBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class GlideFragment: Fragment() {

    private lateinit var binding: FragmentGlideBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGlideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = "https://picsum.photos/200"

        with (binding) {

            glideFragmentGenerateButton.setOnClickListener {
                Glide.with(this@GlideFragment)
                    .load(imageUrl)
                    .fitCenter()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.placeholder_image)
                    .into(glideFragmentImage)
            }

        }
    }
}