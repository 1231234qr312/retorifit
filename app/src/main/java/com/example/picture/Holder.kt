package com.example.picture

import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.picture.RetorofitInstance.Tag


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {






        fun binding(photoItem: ContactsContract.CommonDataKinds.Photo){
            Log.d(Tag, "Holder - bindWithView() called")




        }


    }