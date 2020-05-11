package com.geekybeans.homepractice.models

import com.geekybeans.homepractice.models.BookPlaceholder

data class BookEntity (val title: String,
                       val body: String,
                       val placeholderColor: BookPlaceholder,
                       val url: String)
{
}