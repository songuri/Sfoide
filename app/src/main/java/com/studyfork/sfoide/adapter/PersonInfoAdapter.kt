package com.studyfork.sfoide.adapter

import Results
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studyfork.sfoide.MainActivity
import com.studyfork.sfoide.R
import java.util.ArrayList


class PersonInfoAdapterViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    var tvNameView: TextView = itemView.findViewById(R.id.tv_name)
    var tvPhoneView: TextView = itemView.findViewById(R.id.tv_phone)
    var ivPicture: ImageView = itemView.findViewById(R.id.img_picture)
}

class PersonInfoAdapter(context: Context) : RecyclerView.Adapter<PersonInfoAdapterViewHolder>() {
    val adapterContext: Context = context
    private var mItems: List<Results> =
        ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonInfoAdapterViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonInfoAdapterViewHolder(v)
    }

    /**
     * 여기서 데이터가 셋팅함.
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: PersonInfoAdapterViewHolder, position: Int) {
        val result: Results= mItems[position]
        holder.tvNameView.text = result.name.first
        holder.tvPhoneView.text = result.phone



        var imageUrl: String = result.picture.medium
        Glide.with(adapterContext)
            .load(imageUrl)
            .into(holder.ivPicture)
//        holder.tvNameView.text = store.name
//        holder.tvAddressView.text = store.addr
//        holder.tvDistanceView.text = "1km"
//        var remainCount = "100개이상"
//        var reaminStat = "충분"
//        var color = Color.GREEN
//        if (store.remain_stat != null) {
//            when (store.remain_stat) {
//                "plenty" -> {
//                    reaminStat = "충분"
//                    remainCount = "100개이상"
//                    color = Color.GREEN
//                }
//                "some" -> {
//                    reaminStat = "여유"
//                    remainCount = "30개이상"
//                    color = Color.BLUE
//                }
//                "few" -> {
//                    reaminStat = "부족"
//                    remainCount = "2개이상"
//                    color = Color.RED
//                }
//                "empty" -> {
//                    reaminStat = "재고없음"
//                    remainCount = "1개 이하"
//                    color = Color.GRAY
//                }
//            }
//        }
//        holder.tvCountView.text = remainCount
//        holder.tvRemainView.text = reaminStat
//        holder.tvRemainView.setTextColor(color)
//        holder.tvCountView.setTextColor(color)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateItems(Items: List<Results>) {
        mItems = Items
        notifyDataSetChanged() // UI 갱신
    }
}
