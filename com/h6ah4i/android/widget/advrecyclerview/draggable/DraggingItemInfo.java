package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

/* loaded from: classes6.dex */
public class DraggingItemInfo {
    public final int grabbedPositionX;
    public final int grabbedPositionY;
    public final int height;
    public final long id;
    public final int initialItemLeft;
    public final int initialItemTop;
    public final Rect margins;
    public final int spanSize;
    public final int width;

    public DraggingItemInfo(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        this.width = viewHolder.itemView.getWidth();
        this.height = viewHolder.itemView.getHeight();
        this.id = viewHolder.getItemId();
        int left = viewHolder.itemView.getLeft();
        this.initialItemLeft = left;
        int top = viewHolder.itemView.getTop();
        this.initialItemTop = top;
        this.grabbedPositionX = i4 - left;
        this.grabbedPositionY = i5 - top;
        Rect rect = new Rect();
        this.margins = rect;
        CustomRecyclerViewUtils.getLayoutMargins(viewHolder.itemView, rect);
        this.spanSize = CustomRecyclerViewUtils.getSpanSize(viewHolder);
    }

    public static DraggingItemInfo createWithNewView(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder) {
        return new DraggingItemInfo(draggingItemInfo, viewHolder);
    }

    private DraggingItemInfo(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder) {
        this.id = draggingItemInfo.id;
        int width = viewHolder.itemView.getWidth();
        this.width = width;
        int height = viewHolder.itemView.getHeight();
        this.height = height;
        this.margins = new Rect(draggingItemInfo.margins);
        this.spanSize = CustomRecyclerViewUtils.getSpanSize(viewHolder);
        this.initialItemLeft = draggingItemInfo.initialItemLeft;
        this.initialItemTop = draggingItemInfo.initialItemTop;
        float f4 = width * 0.5f;
        float f5 = height * 0.5f;
        float f6 = draggingItemInfo.grabbedPositionX;
        float f7 = (f6 - (draggingItemInfo.width * 0.5f)) + f4;
        float f8 = (draggingItemInfo.grabbedPositionY - (draggingItemInfo.height * 0.5f)) + f5;
        if (f7 >= 0.0f && f7 < width) {
            f4 = f7;
        }
        this.grabbedPositionX = (int) f4;
        if (f8 >= 0.0f && f8 < height) {
            f5 = f8;
        }
        this.grabbedPositionY = (int) f5;
    }
}
