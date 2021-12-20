package com.magicworld.avantic.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.magicworld.avantic.R
import com.magicworld.avantic.databinding.FragmentDetailBinding
import com.magicworld.avantic.ui.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        (activity as MainActivity?)?.showIcon()
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lugar = args.lugar
        
        with(detailBinding) {
            nombreTextView.text = lugar.name
            description1TextView.text = lugar.description
            Picasso.get().load(lugar.image).into(pictureImageView)

            imageButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(lugar=lugar))
            }
        }

    }

}