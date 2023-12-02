package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.UnwrapPositionResult;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class WrapperAdapterUtils {
    private WrapperAdapterUtils() {
    }

    private static RecyclerView.Adapter a(@Nullable RecyclerView.Adapter adapter) {
        if (!(adapter instanceof WrapperAdapter)) {
            return adapter;
        }
        WrapperAdapter wrapperAdapter = (WrapperAdapter) adapter;
        ArrayList arrayList = new ArrayList();
        wrapperAdapter.getWrappedAdapters(arrayList);
        wrapperAdapter.release();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a(arrayList.get(size));
        }
        arrayList.clear();
        return adapter;
    }

    public static <T> T findWrappedAdapter(@Nullable RecyclerView.Adapter adapter, @NonNull Class<T> cls) {
        if (cls.isInstance(adapter)) {
            return cls.cast(adapter);
        }
        if (adapter instanceof SimpleWrapperAdapter) {
            return (T) findWrappedAdapter(((SimpleWrapperAdapter) adapter).getWrappedAdapter(), cls);
        }
        return null;
    }

    public static RecyclerView.Adapter releaseAll(@Nullable RecyclerView.Adapter adapter) {
        return a(adapter);
    }

    public static int unwrapPosition(@NonNull RecyclerView.Adapter adapter, int i4) {
        return unwrapPosition(adapter, null, i4);
    }

    public static int wrapPosition(@NonNull AdapterPath adapterPath, @Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2, int i4) {
        List<AdapterPathSegment> segments = adapterPath.segments();
        int size = segments.size();
        int i5 = adapter == null ? size - 1 : -1;
        int i6 = adapter2 == null ? 0 : -1;
        if (adapter != null || adapter2 != null) {
            for (int i7 = 0; i7 < size; i7++) {
                AdapterPathSegment adapterPathSegment = segments.get(i7);
                if (adapter != null && adapterPathSegment.adapter == adapter) {
                    i5 = i7;
                }
                if (adapter2 != null && adapterPathSegment.adapter == adapter2) {
                    i6 = i7;
                }
            }
        }
        if (i5 == -1 || i6 == -1 || i6 > i5) {
            return -1;
        }
        return wrapPosition(adapterPath, i5, i6, i4);
    }

    public static int unwrapPosition(@NonNull RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2, int i4) {
        return unwrapPosition(adapter, adapter2, null, i4, null);
    }

    public static int unwrapPosition(@NonNull RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2, Object obj, int i4) {
        return unwrapPosition(adapter, adapter2, obj, i4, null);
    }

    public static int unwrapPosition(@Nullable RecyclerView.Adapter adapter, @Nullable AdapterPathSegment adapterPathSegment, int i4, @Nullable AdapterPath adapterPath) {
        return unwrapPosition(adapter, adapterPathSegment.adapter, adapterPathSegment.tag, i4, adapterPath);
    }

    public static int unwrapPosition(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2, @Nullable Object obj, int i4, @Nullable AdapterPath adapterPath) {
        UnwrapPositionResult unwrapPositionResult = new UnwrapPositionResult();
        if (adapterPath != null) {
            adapterPath.clear();
        }
        if (adapter == null) {
            return -1;
        }
        Object obj2 = null;
        if (adapterPath != null) {
            adapterPath.append(new AdapterPathSegment(adapter, null));
        }
        while (true) {
            if (i4 != -1 && adapter != adapter2) {
                if (adapter instanceof WrapperAdapter) {
                    unwrapPositionResult.clear();
                    ((WrapperAdapter) adapter).unwrapPosition(unwrapPositionResult, i4);
                    i4 = unwrapPositionResult.position;
                    obj2 = unwrapPositionResult.tag;
                    if (unwrapPositionResult.isValid() && adapterPath != null) {
                        adapterPath.append(unwrapPositionResult);
                    }
                    adapter = unwrapPositionResult.adapter;
                    if (adapter == null) {
                        break;
                    }
                } else if (adapter2 != null) {
                    i4 = -1;
                }
            } else {
                break;
            }
        }
        if (adapter2 != null && adapter != adapter2) {
            i4 = -1;
        }
        if (obj != null && obj2 != obj) {
            i4 = -1;
        }
        if (i4 == -1 && adapterPath != null) {
            adapterPath.clear();
        }
        return i4;
    }

    public static <T> T findWrappedAdapter(@Nullable RecyclerView.Adapter adapter, @NonNull Class<T> cls, int i4) {
        AdapterPath adapterPath = new AdapterPath();
        if (unwrapPosition(adapter, null, null, i4, adapterPath) == -1) {
            return null;
        }
        for (AdapterPathSegment adapterPathSegment : adapterPath.segments()) {
            if (cls.isInstance(adapterPathSegment.adapter)) {
                return cls.cast(adapterPathSegment.adapter);
            }
        }
        return null;
    }

    public static int wrapPosition(@NonNull AdapterPath adapterPath, int i4, int i5, int i6) {
        List<AdapterPathSegment> segments = adapterPath.segments();
        while (i4 > i5) {
            i6 = ((WrapperAdapter) segments.get(i4 - 1).adapter).wrapPosition(segments.get(i4), i6);
            if (i6 == -1) {
                break;
            }
            i4--;
        }
        return i6;
    }
}
