package com.geekybeans.homepractice.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geekybeans.homepractice.R
import com.geekybeans.homepractice.models.BookEntity
import kotlinx.android.synthetic.main.item_book_view.view.*

class BooksAdapter(private val books: List<BookEntity>): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>()
{
    override fun getItemCount(): Int { return books.size }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder
    {
        return BooksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book_view,parent,false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int)
    {
        holder.bind(books[position])
    }

    inner class BooksViewHolder(private val view: View): RecyclerView.ViewHolder(view)
    {
        fun bind(book: BookEntity)
        {
            //set book's text
            view.book_title_textView.text = book.title
            view.book_body_textView.text = book.body
            //set book's image from url with color placeholder until it loads
            val color = Color.rgb(book.placeholderColor.red, book.placeholderColor.green, book.placeholderColor.blue)
            val colorDrawable = ColorDrawable(color)
            Glide.with(view.context).load(book.url).placeholder(colorDrawable).fitCenter().into(view.book_imageView)
        }
    }
}