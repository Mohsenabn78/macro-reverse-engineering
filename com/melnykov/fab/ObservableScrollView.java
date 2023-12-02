package com.melnykov.fab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes6.dex */
public class ObservableScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private OnScrollChangedListener f36153a;

    /* loaded from: classes6.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView scrollView, int i4, int i5, int i6, int i7);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        OnScrollChangedListener onScrollChangedListener = this.f36153a;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(this, i4, i5, i6, i7);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.f36153a = onScrollChangedListener;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
