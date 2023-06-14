package com.example.appmovieremember.ui.adapters

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appmovieremember.R
import com.example.appmovieremember.domain.entity.MovieClass

    class MoviesViewHolder(
        itemView: ViewGroup,
        listener: MoviesAdapter.onItemClickListener?,

        )
        : RecyclerView.ViewHolder(itemView) {


        private  var image: ImageView =itemView.findViewById<ImageView>(R.id.image_movie_image_view)
        private var nameTextView: TextView? =itemView.findViewById<TextView>(R.id.name_movie_text_view)
        private var yearTextView: TextView? =itemView.findViewById<TextView>(R.id.year_movie_text_view)
        private var ratingsTextView: TextView? =itemView.findViewById<TextView>(R.id.ratings_movie_text_view)
        private var imageLove:ImageView = itemView.findViewById(R.id.is_love_movie_image_view)
        private lateinit var movie:MovieClass
        init {
            itemView.setOnClickListener { listener?.onItemClick(movie) }
        }


        fun bind(item: MovieClass) {
            this.movie = item
            if(item.image.isNotBlank()){
                Glide.with(image.context)
                    .load(item.image)
                    .placeholder(R.drawable.favorite_navigation_bar)
                    .error(R.drawable.home_navigation_bar)
                    .into(image)
                Glide.with(imageLove.context)
                    .load(item.image)
                    .placeholder(R.drawable.favorite_navigation_bar)
                    .error(R.drawable.home_navigation_bar)
                    .into(image)
            } else{
                image.setImageResource(R.drawable.home_navigation_bar)
            }

            //image!!.setImageResource(item.image)
            nameTextView!!.text = item.title
            yearTextView!!.text = item.year.toString()
            ratingsTextView!!.text = item.rating.toString()
        }
}