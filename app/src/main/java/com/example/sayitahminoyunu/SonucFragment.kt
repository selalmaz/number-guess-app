package com.example.sayitahminoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.sayitahminoyunu.databinding.FragmentSonucBinding


class SonucFragment : Fragment() {

    private var _binding : FragmentSonucBinding?=null
    private val binding get() = _binding!!

    private val args:SonucFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentSonucBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sonuc=args.sonuc
        val yüzde=args.oran

        val oran:Double =String.format("%.2f",yüzde).toDouble()


        if (sonuc=="WİN")
        {
            binding.textView5.text="Kazandın"
            binding.imageView4.setImageResource(R.drawable.happiness)
            binding.textView2.text= "Başari Yüzdesi: %$oran"

        }
        else if(sonuc=="LOSE")
        {
            binding.textView5.text="Kaybettin"
            binding.imageView4.setImageResource(R.drawable.sad)
            binding.textView2.text="Başarı Yüzdesi: %0.0"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }



}