package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.preference.DialogPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceViewHolder;
import com.thebluealliance.spectrum.internal.ColorCircleDrawable;
import com.thebluealliance.spectrum.internal.SpectrumPreferenceDialogFragmentCompat;

/* loaded from: classes6.dex */
public class SpectrumPreferenceCompat extends DialogPreference {
    public static final int ALPHA_DISABLED = 97;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int[] f38055a;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int f38056b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38057c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38058d;

    /* renamed from: e  reason: collision with root package name */
    private View f38059e;

    /* renamed from: f  reason: collision with root package name */
    private int f38060f;

    /* renamed from: g  reason: collision with root package name */
    private int f38061g;

    /* renamed from: h  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f38062h;

    /* loaded from: classes6.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (SpectrumPreferenceCompat.this.getKey().equals(str)) {
                SpectrumPreferenceCompat spectrumPreferenceCompat = SpectrumPreferenceCompat.this;
                spectrumPreferenceCompat.f38056b = sharedPreferences.getInt(str, spectrumPreferenceCompat.f38056b);
                SpectrumPreferenceCompat.this.d();
            }
        }
    }

    public SpectrumPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38057c = true;
        this.f38058d = false;
        this.f38060f = 0;
        this.f38061g = -1;
        this.f38062h = new a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SpectrumPreference, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SpectrumPreference_spectrum_colors, 0);
            if (resourceId != 0) {
                this.f38055a = getContext().getResources().getIntArray(resourceId);
            }
            this.f38057c = obtainStyledAttributes.getBoolean(R.styleable.SpectrumPreference_spectrum_closeOnSelected, true);
            this.f38060f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SpectrumPalette_spectrum_outlineWidth, 0);
            this.f38061g = obtainStyledAttributes.getInt(R.styleable.SpectrumPalette_spectrum_columnCount, -1);
            obtainStyledAttributes.recycle();
            setDialogLayoutResource(R.layout.dialog_color_picker);
            setWidgetLayoutResource(R.layout.color_preference_widget);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f38059e == null) {
            return;
        }
        ColorCircleDrawable colorCircleDrawable = new ColorCircleDrawable(this.f38056b);
        colorCircleDrawable.setOutlineWidth(this.f38060f);
        if (!isEnabled()) {
            colorCircleDrawable.setColor(-1);
            colorCircleDrawable.setAlpha(0);
            colorCircleDrawable.setOutlineWidth(getContext().getResources().getDimensionPixelSize(R.dimen.color_preference_disabled_outline_size));
            colorCircleDrawable.setOutlineColor(-16777216);
            colorCircleDrawable.setOutlineAlpha(97);
        }
        this.f38059e.setBackground(colorCircleDrawable);
    }

    public static boolean onDisplayPreferenceDialog(Preference preference, PreferenceFragmentCompat preferenceFragmentCompat) {
        boolean z3;
        if (preferenceFragmentCompat.getTargetFragment() instanceof PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) {
            z3 = ((PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) preferenceFragmentCompat.getTargetFragment()).onPreferenceDisplayDialog(preferenceFragmentCompat, preference);
        } else {
            z3 = false;
        }
        if (!z3 && (preferenceFragmentCompat.getActivity() instanceof PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback)) {
            z3 = ((PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback) preferenceFragmentCompat.getActivity()).onPreferenceDisplayDialog(preferenceFragmentCompat, preference);
        }
        if (!z3 && preferenceFragmentCompat.getFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") != null) {
            z3 = true;
        }
        if (!z3 && (preference instanceof SpectrumPreferenceCompat)) {
            SpectrumPreferenceDialogFragmentCompat newInstance = SpectrumPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            newInstance.setTargetFragment(preferenceFragmentCompat, 0);
            newInstance.show(preferenceFragmentCompat.getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
            return true;
        }
        return z3;
    }

    public boolean getCloseOnSelected() {
        return this.f38057c;
    }

    @ColorInt
    public int getColor() {
        return this.f38056b;
    }

    @ColorInt
    public int[] getColors() {
        return this.f38055a;
    }

    public int getFixedColumnCount() {
        return this.f38061g;
    }

    public int getOutlineWidth() {
        return this.f38060f;
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        getSharedPreferences().registerOnSharedPreferenceChangeListener(this.f38062h);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        this.f38059e = preferenceViewHolder.findViewById(R.id.color_preference_widget);
        d();
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInteger(i4, -16777216));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.f38062h);
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(boolean z3, Object obj) {
        if (z3) {
            this.f38056b = getPersistedInt(-16777216);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        this.f38056b = intValue;
        persistInt(intValue);
    }

    public void setCloseOnSelected(boolean z3) {
        this.f38057c = z3;
    }

    public void setColor(@ColorInt int i4) {
        boolean z3;
        if (this.f38056b != i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || !this.f38058d) {
            this.f38056b = i4;
            this.f38058d = true;
            persistInt(i4);
            d();
            if (z3) {
                notifyChanged();
            }
        }
    }

    public void setColors(@ColorInt int[] iArr) {
        this.f38055a = iArr;
    }

    public void setColors(@ArrayRes int i4) {
        this.f38055a = getContext().getResources().getIntArray(i4);
    }
}
