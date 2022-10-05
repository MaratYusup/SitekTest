package com.example.mobileclient.presentation.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileclient.databinding.RwFrInfoListItemBinding
import com.example.mobileclient.domain.model.UserAuthDataInfo

class RwFrInfoListAdapter(private val context: Context) :
    RecyclerView.Adapter<RwFrInfoListViewHolder>() {


    var userAuthDataInfoList = listOf<UserAuthDataInfo>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ((UserAuthDataInfo) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RwFrInfoListViewHolder {
        val binding =
            RwFrInfoListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return RwFrInfoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RwFrInfoListViewHolder, position: Int) {
        val userAuthDataInfo = userAuthDataInfoList[position]
        with(holder.binding) {

            textViewTitle.text = userAuthDataInfo.title ?: ""
            textViewText.text = userAuthDataInfo.text ?: ""
        }
    }

    override fun getItemCount(): Int {
        return userAuthDataInfoList.size
    }
}