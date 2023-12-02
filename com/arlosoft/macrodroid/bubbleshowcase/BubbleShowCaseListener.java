package com.arlosoft.macrodroid.bubbleshowcase;

import org.jetbrains.annotations.NotNull;

/* compiled from: BubbleShowCaseListener.kt */
/* loaded from: classes3.dex */
public interface BubbleShowCaseListener {
    void onBackgroundDimClick(@NotNull BubbleShowCase bubbleShowCase);

    void onBubbleClick(@NotNull BubbleShowCase bubbleShowCase);

    void onCloseActionImageClick(@NotNull BubbleShowCase bubbleShowCase);

    void onTargetClick(@NotNull BubbleShowCase bubbleShowCase);
}
