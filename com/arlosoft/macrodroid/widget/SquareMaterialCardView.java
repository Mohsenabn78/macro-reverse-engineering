package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public class SquareMaterialCardView extends MaterialCardView {
    public SquareMaterialCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.card.MaterialCardView, androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i4);
    }
}
