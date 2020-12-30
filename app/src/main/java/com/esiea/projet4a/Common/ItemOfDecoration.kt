package com.esiea.projet4a.Common

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import java.time.ZoneOffset

class ItemOfDecoration(private val itemOffset: Int) :RecyclerView.ItemDecoration() {
    constructor(context: Context,@DimenRes itemDimensID: Int) :this(context.resources.getDimensionPixelSize(itemDimensID))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect!!.set(itemOffset,itemOffset,itemOffset,itemOffset)

    }


}