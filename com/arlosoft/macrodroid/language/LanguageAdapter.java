package com.arlosoft.macrodroid.language;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.jsramraj.flags.Flags;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LanguageAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LanguageAdapter extends ArrayAdapter<String> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String[] f12610a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String[] f12611b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final FlagProvider f12612c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanguageAdapter(@NotNull Context context, @NotNull String[] languages, @NotNull String[] languageCode, @NotNull FlagProvider flagProvider) {
        super(context, (int) R.layout.simple_spinner_item_with_left_image, (int) R.id.languageText, languages);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(languages, "languages");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(flagProvider, "flagProvider");
        this.f12610a = languages;
        this.f12611b = languageCode;
        this.f12612c = flagProvider;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return getView(i4, view, parent);
    }

    @NotNull
    public final FlagProvider getFlagProvider() {
        return this.f12612c;
    }

    @NotNull
    public final String[] getLanguageCode() {
        return this.f12611b;
    }

    @NotNull
    public final String[] getLanguages() {
        return this.f12610a;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Unit unit;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view2 = super.getView(i4, view, parent);
        Intrinsics.checkNotNullExpressionValue(view2, "super.getView(position, convertView, parent)");
        ImageView imageView = (ImageView) view2.findViewById(R.id.flagIcon);
        ((TextView) view2.findViewById(R.id.languageText)).setText(this.f12610a[i4]);
        Integer flagResourceFromLanguage = this.f12612c.getFlagResourceFromLanguage(this.f12611b[i4]);
        if (flagResourceFromLanguage != null) {
            imageView.setImageResource(flagResourceFromLanguage.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                imageView.setImageBitmap(Flags.forCountry(this.f12611b[i4]).getBitmap());
            } catch (Exception unused) {
                imageView.setImageResource(17170445);
            }
        }
        return view2;
    }
}
