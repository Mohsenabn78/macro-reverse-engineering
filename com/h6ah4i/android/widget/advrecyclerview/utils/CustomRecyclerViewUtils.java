package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes6.dex */
public class CustomRecyclerViewUtils {
    public static final int INVALID_SPAN_COUNT = -1;
    public static final int INVALID_SPAN_ID = -1;
    public static final int LAYOUT_TYPE_GRID_HORIZONTAL = 2;
    public static final int LAYOUT_TYPE_GRID_VERTICAL = 3;
    public static final int LAYOUT_TYPE_LINEAR_HORIZONTAL = 0;
    public static final int LAYOUT_TYPE_LINEAR_VERTICAL = 1;
    public static final int LAYOUT_TYPE_STAGGERED_GRID_HORIZONTAL = 4;
    public static final int LAYOUT_TYPE_STAGGERED_GRID_VERTICAL = 5;
    public static final int LAYOUT_TYPE_UNKNOWN = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_UNKNOWN = -1;
    public static final int ORIENTATION_VERTICAL = 1;

    private static View a(@NonNull ViewGroup viewGroup, float f4, float f5) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (f4 >= childAt.getLeft() && f4 <= childAt.getRight() && f5 >= childAt.getTop() && f5 <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private static int b(LinearLayoutManager linearLayoutManager) {
        View d4 = d(linearLayoutManager, 0, linearLayoutManager.getChildCount(), false, true);
        if (d4 == null) {
            return -1;
        }
        return linearLayoutManager.getPosition(d4);
    }

    private static int c(LinearLayoutManager linearLayoutManager) {
        View d4 = d(linearLayoutManager, linearLayoutManager.getChildCount() - 1, -1, false, true);
        if (d4 == null) {
            return -1;
        }
        return linearLayoutManager.getPosition(d4);
    }

    private static View d(LinearLayoutManager linearLayoutManager, int i4, int i5, boolean z3, boolean z4) {
        boolean z5;
        int width;
        int left;
        int right;
        int i6 = 1;
        if (linearLayoutManager.getOrientation() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            width = linearLayoutManager.getHeight();
        } else {
            width = linearLayoutManager.getWidth();
        }
        if (i5 <= i4) {
            i6 = -1;
        }
        View view = null;
        while (i4 != i5) {
            View childAt = linearLayoutManager.getChildAt(i4);
            if (z5) {
                left = childAt.getTop();
            } else {
                left = childAt.getLeft();
            }
            if (z5) {
                right = childAt.getBottom();
            } else {
                right = childAt.getRight();
            }
            if (left < width && right > 0) {
                if (z3) {
                    if (left >= 0 && right <= width) {
                        return childAt;
                    }
                    if (z4 && view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
            i4 += i6;
        }
        return view;
    }

    private static View e(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return null;
        }
        View view = viewHolder.itemView;
        if (!ViewCompat.isLaidOut(view)) {
            return null;
        }
        return view;
    }

    public static int extractOrientation(int i4) {
        switch (i4) {
            case -1:
                return -1;
            case 0:
            case 2:
            case 4:
                return 0;
            case 1:
            case 3:
            case 5:
                return 1;
            default:
                throw new IllegalArgumentException("Unknown layout type (= " + i4 + ")");
        }
    }

    public static RecyclerView.ViewHolder findChildViewHolderUnderWithTranslation(@NonNull RecyclerView recyclerView, float f4, float f5) {
        View findChildViewUnder = recyclerView.findChildViewUnder(f4, f5);
        if (findChildViewUnder != null) {
            return recyclerView.getChildViewHolder(findChildViewUnder);
        }
        return null;
    }

    public static RecyclerView.ViewHolder findChildViewHolderUnderWithoutTranslation(@NonNull RecyclerView recyclerView, float f4, float f5) {
        View a4 = a(recyclerView, f4, f5);
        if (a4 != null) {
            return recyclerView.getChildViewHolder(a4);
        }
        return null;
    }

    public static int findFirstCompletelyVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        return -1;
    }

    public static int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView, boolean z3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (z3) {
                return b((LinearLayoutManager) layoutManager);
            }
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        return -1;
    }

    public static int findLastCompletelyVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    public static int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView, boolean z3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (z3) {
                return c((LinearLayoutManager) layoutManager);
            }
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        return -1;
    }

    public static View findViewByPosition(@NonNull RecyclerView.LayoutManager layoutManager, int i4) {
        if (i4 != -1) {
            return layoutManager.findViewByPosition(i4);
        }
        return null;
    }

    public static Rect getDecorationOffsets(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, @NonNull Rect rect) {
        rect.left = layoutManager.getLeftDecorationWidth(view);
        rect.right = layoutManager.getRightDecorationWidth(view);
        rect.top = layoutManager.getTopDecorationHeight(view);
        rect.bottom = layoutManager.getBottomDecorationHeight(view);
        return rect;
    }

    public static Rect getLayoutMargins(@NonNull View view, @NonNull Rect rect) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            rect.left = marginLayoutParams.leftMargin;
            rect.right = marginLayoutParams.rightMargin;
            rect.top = marginLayoutParams.topMargin;
            rect.bottom = marginLayoutParams.bottomMargin;
        } else {
            rect.bottom = 0;
            rect.top = 0;
            rect.right = 0;
            rect.left = 0;
        }
        return rect;
    }

    public static int getLayoutType(@NonNull RecyclerView recyclerView) {
        return getLayoutType(recyclerView.getLayoutManager());
    }

    public static int getOrientation(@NonNull RecyclerView recyclerView) {
        return getOrientation(recyclerView.getLayoutManager());
    }

    public static int getSpanCount(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return 1;
    }

    public static int getSpanIndex(@Nullable RecyclerView.ViewHolder viewHolder) {
        View e4 = e(viewHolder);
        if (e4 == null) {
            return -1;
        }
        ViewGroup.LayoutParams layoutParams = e4.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
        }
        if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            return ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
        }
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            return -1;
        }
        return 0;
    }

    public static int getSpanSize(@Nullable RecyclerView.ViewHolder viewHolder) {
        View e4 = e(viewHolder);
        if (e4 == null) {
            return -1;
        }
        ViewGroup.LayoutParams layoutParams = e4.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            if (!((StaggeredGridLayoutManager.LayoutParams) layoutParams).isFullSpan()) {
                return 1;
            }
            return getSpanCount((RecyclerView) e4.getParent());
        } else if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            return ((GridLayoutManager.LayoutParams) layoutParams).getSpanSize();
        } else {
            if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
                return -1;
            }
            return 1;
        }
    }

    public static int getSynchronizedPosition(@NonNull RecyclerView.ViewHolder viewHolder) {
        int layoutPosition = viewHolder.getLayoutPosition();
        if (layoutPosition == viewHolder.getAdapterPosition()) {
            return layoutPosition;
        }
        return -1;
    }

    public static Rect getViewBounds(@NonNull View view, @NonNull Rect rect) {
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        return rect;
    }

    public static boolean isFullSpan(@Nullable RecyclerView.ViewHolder viewHolder) {
        View e4 = e(viewHolder);
        if (e4 == null) {
            return true;
        }
        ViewGroup.LayoutParams layoutParams = e4.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return ((StaggeredGridLayoutManager.LayoutParams) layoutParams).isFullSpan();
        }
        if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            if (getSpanCount((RecyclerView) e4.getParent()) == ((GridLayoutManager.LayoutParams) layoutParams).getSpanSize()) {
                return true;
            }
            return false;
        }
        boolean z3 = layoutParams instanceof RecyclerView.LayoutParams;
        return true;
    }

    public static boolean isGridLayout(int i4) {
        if (i4 != 3 && i4 != 2) {
            return false;
        }
        return true;
    }

    public static boolean isLinearLayout(int i4) {
        if (i4 == 1 || i4 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isStaggeredGridLayout(int i4) {
        if (i4 != 5 && i4 != 4) {
            return false;
        }
        return true;
    }

    public static int safeGetAdapterPosition(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            return viewHolder.getAdapterPosition();
        }
        return -1;
    }

    public static int safeGetLayoutPosition(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            return viewHolder.getLayoutPosition();
        }
        return -1;
    }

    public static int getLayoutType(@Nullable RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getOrientation() == 0 ? 2 : 3;
        } else if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation() == 0 ? 0 : 1;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation() == 0 ? 4 : 5;
        } else {
            return -1;
        }
    }

    public static int getOrientation(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return -1;
    }
}
