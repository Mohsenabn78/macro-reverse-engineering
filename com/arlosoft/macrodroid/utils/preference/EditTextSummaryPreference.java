package com.arlosoft.macrodroid.utils.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.arlosoft.macrodroid.utils.preference.EditTextSummaryPreference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EditTextSummaryPreference.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class EditTextSummaryPreference extends EditTextPreference {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSummaryPreference(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    private final void b() {
        setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: v0.a
            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                boolean c4;
                c4 = EditTextSummaryPreference.c(EditTextSummaryPreference.this, preference, obj);
                return c4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(EditTextSummaryPreference this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setSummary(obj.toString());
        return true;
    }

    @Override // androidx.preference.Preference
    @NotNull
    public CharSequence getSummary() {
        String text = getText();
        if (text == null) {
            return "-";
        }
        return text;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSummaryPreference(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSummaryPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextSummaryPreference(@NotNull Context context, @NotNull AttributeSet attrs, int i4, int i5) {
        super(context, attrs, i4, i5);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        b();
    }
}
