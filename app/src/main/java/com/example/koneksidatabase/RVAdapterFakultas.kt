package com.example.koneksidatabase

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fakultas_list.view.*

class RVAdapterFakultas (private val context: Context, private val arrayList: ArrayList<Fakultas>):
    RecyclerView.Adapter<RVAdapterFakultas.Holder>(), Parcelable {
    class Holder(val view: View): RecyclerView.ViewHolder(view)

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("arrayList")
    ) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.fakultas_list,parent,false))
    }

    override fun getItemCount(): Int = arrayList!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.label_kodefakultas.text = arrayList?.get(position)?.kode_fakultas
        holder.view.label_namafakultas.text = "Nama Fakultas: "+arrayList?.get(position)?.nama_fakultas
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RVAdapterFakultas> {
        override fun createFromParcel(parcel: Parcel): RVAdapterFakultas {
            return RVAdapterFakultas(parcel)
        }

        override fun newArray(size: Int): Array<RVAdapterFakultas?> {
            return arrayOfNulls(size)
        }
    }
}