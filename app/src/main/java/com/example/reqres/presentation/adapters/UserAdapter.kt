package com.example.reqres.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reqres.R
import com.example.reqres.data.entities.UserModel
import com.example.reqres.databinding.CardUserBinding
import com.example.reqres.presentation.ui.MainFragmentDirections

class UserAdapter: PagingDataAdapter<UserModel, UserAdapter.UserViewHolder>(UserDiffCallBack()) {
    class UserDiffCallBack : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.lastName == newItem.lastName && oldItem.email == newItem.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CardUserBinding>(layoutInflater, R.layout.card_user,parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.user = user
        holder.binding.root.setOnClickListener{
            //Navigate to Profile
            val action = MainFragmentDirections.actionMainFragmentToProfileFragment(user!!)
            it.findNavController().navigate(action)
        }
        holder.binding.executePendingBindings()
    }
    inner class UserViewHolder(val binding: CardUserBinding) : RecyclerView.ViewHolder(binding.root)
}