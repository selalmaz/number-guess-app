package com.example.sayitahminoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sayitahminoyunu.databinding.FragmentTahminBinding


class TahminFragment : Fragment() {

    private var _binding : FragmentTahminBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentTahminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomSayi=(1..20).random()
        var hak=5


        binding.hak.text="kalan hakkiniz: $hak"

        binding.button2.setOnClickListener{

            if(binding.editTextTahmin.text.toString().isEmpty())
            {
                Toast.makeText(context, "Lutfen Sayi Giriniz", Toast.LENGTH_SHORT).show()
            }

            else{
                var tahminSayi=binding.editTextTahmin.text.toString().toInt()
                hak=hak-1
                if(tahminSayi>randomSayi) {
                    binding.ipucu.text="İp Ucu:Azalt"
                }
                else if(randomSayi>tahminSayi){
                    binding.ipucu.text="İp Ucu:Arttır"
                }

                if(tahminSayi==randomSayi){
                    val gecis=TahminFragmentDirections.tahminTOSonuc("WİN",1f/(5-hak)*100)
                    findNavController().navigate(gecis)
                }

                else if(hak==0) {
                    val gecis=TahminFragmentDirections.tahminTOSonuc("LOSE",0f)
                    findNavController().navigate(gecis)
                }
                binding.hak.text="kalan hakkiniz: $hak"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}