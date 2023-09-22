package com.example.picture

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.picture.RetorofitInstance.Tag
import com.example.picture.databinding.FragmentSearchBinding


class search : Fragment() {
    private var _binding:FragmentSearchBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSearchBinding.inflate(layoutInflater,container,false)
        val view= binding.root


        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchText=binding.searchText

        searchText.changeText {
            if (it.toString().count()>0){
              binding.searchBtn?.visibility=View.VISIBLE
            }
            else {
                binding.searchBtn?.visibility=View.INVISIBLE
            }
        }

    binding.searchBtn.setOnClickListener {
        Log.d(Tag,"검색버튼 클릭 됨")
        RetrofitManager.instance.searchphotos(searchTerm = searchText.toString(), completion = {
            responseState,responseBody->

            when(responseState){
                RESPONSE_STATE.OK->{}
                RESPONSE_STATE.FAIL->{
                    Toast.makeText(requireContext(), "api호출 에러", Toast.LENGTH_SHORT).show()
            }

      
        }
        })

    }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
    fun EditText.changeText(completion:(Editable?)->Unit){
        this.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }
}