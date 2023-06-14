package com.example.appmovieremember.domain.entity

import android.media.Rating
import android.os.ParcelFileDescriptor
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieClass (
    val image: String,
    val title:String,
    val description:String,
    val year:Long,
    val rating: Float,
    val isLove:Boolean
) : Parcelable {
    var id: Long? = null
}

