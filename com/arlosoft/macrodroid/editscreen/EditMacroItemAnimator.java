package com.arlosoft.macrodroid.editscreen;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: EditMacroItemAnimator.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class EditMacroItemAnimator extends RefactoredDefaultItemAnimator {
    public static final int $stable = 0;

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        if (oldHolder == newHolder && i4 == i6 && i5 == i7) {
            dispatchChangeFinished(oldHolder, true);
            return false;
        }
        return super.animateChange(oldHolder, newHolder, i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public void l() {
        super.l();
        super.setSupportsChangeAnimations(false);
        super.setChangeDuration(0L);
    }
}
