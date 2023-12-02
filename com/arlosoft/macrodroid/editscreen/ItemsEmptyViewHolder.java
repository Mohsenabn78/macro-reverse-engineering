package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ItemsEmptyViewHolder.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ItemsEmptyViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemsEmptyViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ButterKnife.bind(this, itemView);
    }

    public final void bind() {
    }
}
