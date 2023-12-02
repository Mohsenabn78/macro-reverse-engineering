package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BetterCheckBox.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BetterCheckBox extends AppCompatCheckBox {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f16461a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BetterCheckBox(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setChecked(boolean z3, boolean z4) {
        if (!z4) {
            super.setOnCheckedChangeListener(null);
            super.setChecked(z3);
            super.setOnCheckedChangeListener(this.f16461a);
            return;
        }
        super.setChecked(z3);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f16461a = onCheckedChangeListener;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public final void toggle(boolean z3) {
        if (!z3) {
            super.setOnCheckedChangeListener(null);
            super.toggle();
            super.setOnCheckedChangeListener(this.f16461a);
            return;
        }
        super.toggle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BetterCheckBox(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BetterCheckBox(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
