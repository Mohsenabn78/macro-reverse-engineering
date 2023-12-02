package com.thebluealliance.spectrum;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import com.thebluealliance.spectrum.SpectrumPalette;
import com.thebluealliance.spectrum.internal.ColorCircleDrawable;

/* loaded from: classes6.dex */
public class SpectrumPreference extends DialogPreference {
    public static final int ALPHA_DISABLED = 97;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int[] f38043a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int f38044b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f38045c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38046d;

    /* renamed from: e  reason: collision with root package name */
    private SpectrumPalette f38047e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38048f;

    /* renamed from: g  reason: collision with root package name */
    private View f38049g;

    /* renamed from: h  reason: collision with root package name */
    private int f38050h;

    /* renamed from: i  reason: collision with root package name */
    private int f38051i;

    /* renamed from: j  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f38052j;

    /* loaded from: classes6.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (SpectrumPreference.this.getKey().equals(str)) {
                SpectrumPreference spectrumPreference = SpectrumPreference.this;
                spectrumPreference.f38044b = sharedPreferences.getInt(str, spectrumPreference.f38044b);
                SpectrumPreference.this.f();
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements SpectrumPalette.OnColorSelectedListener {
        b() {
        }

        @Override // com.thebluealliance.spectrum.SpectrumPalette.OnColorSelectedListener
        public void onColorSelected(@ColorInt int i4) {
            SpectrumPreference.this.f38045c = i4;
            if (SpectrumPreference.this.f38046d) {
                SpectrumPreference.this.onClick(null, -1);
                if (SpectrumPreference.this.getDialog() != null) {
                    SpectrumPreference.this.getDialog().dismiss();
                }
            }
        }
    }

    public SpectrumPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38046d = true;
        this.f38048f = false;
        this.f38050h = 0;
        this.f38051i = -1;
        this.f38052j = new a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SpectrumPreference, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SpectrumPreference_spectrum_colors, 0);
            if (resourceId != 0) {
                this.f38043a = getContext().getResources().getIntArray(resourceId);
            }
            this.f38046d = obtainStyledAttributes.getBoolean(R.styleable.SpectrumPreference_spectrum_closeOnSelected, true);
            this.f38050h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SpectrumPalette_spectrum_outlineWidth, 0);
            this.f38051i = obtainStyledAttributes.getInt(R.styleable.SpectrumPalette_spectrum_columnCount, -1);
            obtainStyledAttributes.recycle();
            setDialogLayoutResource(R.layout.dialog_color_picker);
            setWidgetLayoutResource(R.layout.color_preference_widget);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f38049g == null) {
            return;
        }
        ColorCircleDrawable colorCircleDrawable = new ColorCircleDrawable(this.f38044b);
        colorCircleDrawable.setOutlineWidth(this.f38050h);
        if (!isEnabled()) {
            colorCircleDrawable.setColor(-16777216);
            colorCircleDrawable.setAlpha(0);
            colorCircleDrawable.setOutlineWidth(getContext().getResources().getDimensionPixelSize(R.dimen.color_preference_disabled_outline_size));
            colorCircleDrawable.setOutlineColor(-16777216);
            colorCircleDrawable.setOutlineAlpha(97);
        }
        this.f38049g.setBackground(colorCircleDrawable);
    }

    public boolean getCloseOnSelected() {
        return this.f38046d;
    }

    @ColorInt
    public int getColor() {
        return this.f38044b;
    }

    @ColorInt
    public int[] getColors() {
        return this.f38043a;
    }

    @Override // android.preference.DialogPreference
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        if (this.f38043a != null) {
            SpectrumPalette spectrumPalette = (SpectrumPalette) view.findViewById(R.id.palette);
            this.f38047e = spectrumPalette;
            spectrumPalette.setColors(this.f38043a);
            this.f38047e.setSelectedColor(this.f38044b);
            this.f38047e.setOutlineWidth(this.f38050h);
            this.f38047e.setFixedColumnCount(this.f38051i);
            this.f38047e.setOnColorSelectedListener(new b());
            return;
        }
        throw new RuntimeException("SpectrumPreference requires a colors array");
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.f38049g = view.findViewById(R.id.color_preference_widget);
        f();
    }

    @Override // android.preference.Preference
    protected View onCreateView(ViewGroup viewGroup) {
        getSharedPreferences().registerOnSharedPreferenceChangeListener(this.f38052j);
        return super.onCreateView(viewGroup);
    }

    @Override // android.preference.DialogPreference
    protected void onDialogClosed(boolean z3) {
        if (z3 && callChangeListener(Integer.valueOf(this.f38045c))) {
            setColor(this.f38045c);
        }
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInteger(i4, -16777216));
    }

    @Override // android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if (this.f38046d) {
            builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        }
    }

    @Override // android.preference.Preference
    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.f38052j);
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z3, Object obj) {
        if (z3) {
            this.f38044b = getPersistedInt(-16777216);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        this.f38044b = intValue;
        persistInt(intValue);
    }

    public void setCloseOnSelected(boolean z3) {
        this.f38046d = z3;
    }

    public void setColor(@ColorInt int i4) {
        boolean z3;
        if (this.f38044b != i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || !this.f38048f) {
            this.f38044b = i4;
            this.f38048f = true;
            persistInt(i4);
            f();
            if (z3) {
                notifyChanged();
            }
        }
    }

    public void setColors(@ColorInt int[] iArr) {
        this.f38043a = iArr;
    }

    public void setColors(@ArrayRes int i4) {
        this.f38043a = getContext().getResources().getIntArray(i4);
    }
}
