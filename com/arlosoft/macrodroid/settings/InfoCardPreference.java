package com.arlosoft.macrodroid.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InfoCardPreference.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class InfoCardPreference extends Preference {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f13431a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f13432b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f13433c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InfoCardPreference(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void configureInfoCard(@NotNull String titleText, @NotNull String descriptionText, @NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.f13431a = titleText;
        this.f13432b = descriptionText;
        this.f13433c = clickListener;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(@NotNull PreferenceViewHolder viewholder) {
        Intrinsics.checkNotNullParameter(viewholder, "viewholder");
        super.onBindViewHolder(viewholder);
        View findViewById = viewholder.findViewById(R.id.infoCardGotIt);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.Button");
        View findViewById2 = viewholder.findViewById(R.id.infoCardTitle);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        View findViewById3 = viewholder.findViewById(R.id.infoCardDetail);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        View view = viewholder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.cardview.widget.CardView");
        CardView cardView = (CardView) view;
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        cardView.setCardBackgroundColor(typedValue.data);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small);
        ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(dimensionPixelOffset);
        layoutParams2.setMarginEnd(dimensionPixelOffset);
        ((TextView) findViewById2).setText(this.f13431a);
        ((TextView) findViewById3).setText(this.f13432b);
        ((Button) findViewById).setOnClickListener(this.f13433c);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InfoCardPreference(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InfoCardPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ InfoCardPreference(Context context, AttributeSet attributeSet, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i4, (i6 & 8) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InfoCardPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
