package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.UnwrapPositionResult;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;

/* loaded from: classes6.dex */
public class DebugWrapperAdapter extends SimpleWrapperAdapter<RecyclerView.ViewHolder> {
    public static final int FLAGS_ALL_DEBUG_FEATURES = 3;
    public static final int FLAG_VERIFY_UNWRAP_POSITION = 2;
    public static final int FLAG_VERIFY_WRAP_POSITION = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f34016d;

    public DebugWrapperAdapter(@NonNull RecyclerView.Adapter adapter) {
        super(adapter);
        this.f34016d = 3;
    }

    public int getSettingFlags() {
        return this.f34016d;
    }

    public void setSettingFlags(int i4) {
        this.f34016d = i4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void unwrapPosition(@NonNull UnwrapPositionResult unwrapPositionResult, int i4) {
        int wrapPosition;
        if ((this.f34016d & 2) != 0 && (getWrappedAdapter() instanceof WrapperAdapter)) {
            WrapperAdapter wrapperAdapter = (WrapperAdapter) getWrappedAdapter();
            UnwrapPositionResult unwrapPositionResult2 = new UnwrapPositionResult();
            wrapperAdapter.unwrapPosition(unwrapPositionResult2, i4);
            if (unwrapPositionResult2.isValid() && i4 != (wrapPosition = wrapperAdapter.wrapPosition(new AdapterPathSegment(unwrapPositionResult2.adapter, unwrapPositionResult2.tag), unwrapPositionResult2.position))) {
                String simpleName = getWrappedAdapter().getClass().getSimpleName();
                throw new IllegalStateException("Found a WrapperAdapter implementation issue while executing unwrapPosition(): " + simpleName + "\nunwrapPosition(" + i4 + ") returns " + unwrapPositionResult2.position + ", but wrapPosition(" + unwrapPositionResult2.position + ") returns " + wrapPosition);
            }
        }
        super.unwrapPosition(unwrapPositionResult, i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public int wrapPosition(@NonNull AdapterPathSegment adapterPathSegment, int i4) {
        WrapperAdapter wrapperAdapter;
        int wrapPosition;
        if ((this.f34016d & 1) != 0 && (getWrappedAdapter() instanceof WrapperAdapter) && (wrapPosition = (wrapperAdapter = (WrapperAdapter) getWrappedAdapter()).wrapPosition(adapterPathSegment, i4)) != -1) {
            UnwrapPositionResult unwrapPositionResult = new UnwrapPositionResult();
            wrapperAdapter.unwrapPosition(unwrapPositionResult, wrapPosition);
            if (unwrapPositionResult.position != i4) {
                String simpleName = getWrappedAdapter().getClass().getSimpleName();
                throw new IllegalStateException("Found a WrapperAdapter implementation issue while executing wrapPosition(): " + simpleName + "\nwrapPosition(" + i4 + ") returns " + wrapPosition + ", but unwrapPosition(" + wrapPosition + ") returns " + unwrapPositionResult.position);
            }
        }
        return super.wrapPosition(adapterPathSegment, i4);
    }
}
