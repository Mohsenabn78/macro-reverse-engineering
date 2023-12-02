package com.arlosoft.macrodroid.bubbleshowcase;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BubbleShowCaseSequence.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BubbleShowCaseSequence {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<BubbleShowCaseBuilder> f9552a;

    public BubbleShowCaseSequence() {
        ArrayList<BubbleShowCaseBuilder> arrayList = new ArrayList<>();
        this.f9552a = arrayList;
        arrayList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final int i4) {
        if (i4 >= this.f9552a.size()) {
            return;
        }
        if (i4 == 0) {
            this.f9552a.get(i4).isFirstOfSequence$app_standardRelease(true);
            this.f9552a.get(i4).isLastOfSequence$app_standardRelease(false);
        } else if (i4 == this.f9552a.size() - 1) {
            this.f9552a.get(i4).isFirstOfSequence$app_standardRelease(false);
            this.f9552a.get(i4).isLastOfSequence$app_standardRelease(true);
        } else {
            this.f9552a.get(i4).isFirstOfSequence$app_standardRelease(false);
            this.f9552a.get(i4).isLastOfSequence$app_standardRelease(false);
        }
        this.f9552a.get(i4).sequenceListener$app_standardRelease(new SequenceShowCaseListener() { // from class: com.arlosoft.macrodroid.bubbleshowcase.BubbleShowCaseSequence$show$1
            @Override // com.arlosoft.macrodroid.bubbleshowcase.SequenceShowCaseListener
            public void onDismiss() {
                BubbleShowCaseSequence.this.a(i4 + 1);
            }
        }).show();
    }

    @NotNull
    public final BubbleShowCaseSequence addShowCase(@NotNull BubbleShowCaseBuilder bubbleShowCaseBuilder) {
        Intrinsics.checkNotNullParameter(bubbleShowCaseBuilder, "bubbleShowCaseBuilder");
        this.f9552a.add(bubbleShowCaseBuilder);
        return this;
    }

    @NotNull
    public final BubbleShowCaseSequence addShowCases(@NotNull List<BubbleShowCaseBuilder> bubbleShowCaseBuilderList) {
        Intrinsics.checkNotNullParameter(bubbleShowCaseBuilderList, "bubbleShowCaseBuilderList");
        this.f9552a.addAll(bubbleShowCaseBuilderList);
        return this;
    }

    public final void show() {
        a(0);
    }
}
