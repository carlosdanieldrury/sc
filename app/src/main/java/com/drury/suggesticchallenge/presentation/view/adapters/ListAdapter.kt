package com.drury.suggesticchallenge.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.drury.suggesticchallenge.R
import com.drury.suggesticchallenge.databinding.ListItemLayoutBinding
import com.drury.suggesticchallenge.domain.DayMessageModel
import com.drury.suggesticchallenge.presentation.view.OnClickItemListerner
import com.drury.suggesticchallenge.utils.toStringName

class ListAdapter(
    private val onClickItemListerner: OnClickItemListerner
) : RecyclerView.Adapter<ListViewHolder>() {

    private val items: MutableList<DayMessageModel> = mutableListOf()

    fun setItems(list: List<DayMessageModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemLayoutBinding>(layoutInflater, R.layout.list_item_layout, parent, false)
        return ListViewHolder(binding, onClickItemListerner)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}

class ListViewHolder(val binding: ListItemLayoutBinding, val listerner: OnClickItemListerner) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dayMessageModel: DayMessageModel) {
        val day = dayMessageModel.day.plus(1)
        val title = dayMessageModel.title
        val subtitle = dayMessageModel.subtitle
        binding.dayId.text = day.toString()
        binding.dayIdTitle.text = itemView.context.getString(R.string.day_title, day.toStringName())
        binding.title.text = title
        binding.subtitle.text = subtitle
        binding.root.setOnClickListener { listerner.showAlertDialog(title = title, message = subtitle) }
    }
}