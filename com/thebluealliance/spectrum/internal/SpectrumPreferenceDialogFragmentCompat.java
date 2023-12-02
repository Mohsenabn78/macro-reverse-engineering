package com.thebluealliance.spectrum.internal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.thebluealliance.spectrum.R;
import com.thebluealliance.spectrum.SpectrumPalette;
import com.thebluealliance.spectrum.SpectrumPreferenceCompat;

/* loaded from: classes6.dex */
public class SpectrumPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* renamed from: b  reason: collision with root package name */
    private SpectrumPalette f38076b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private int f38077c;

    /* loaded from: classes6.dex */
    class a implements SpectrumPalette.OnColorSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpectrumPreferenceCompat f38078a;

        a(SpectrumPreferenceCompat spectrumPreferenceCompat) {
            this.f38078a = spectrumPreferenceCompat;
        }

        @Override // com.thebluealliance.spectrum.SpectrumPalette.OnColorSelectedListener
        public void onColorSelected(@ColorInt int i4) {
            SpectrumPreferenceDialogFragmentCompat.this.f38077c = i4;
            if (this.f38078a.getCloseOnSelected()) {
                SpectrumPreferenceDialogFragmentCompat.this.onClick(null, -1);
                if (SpectrumPreferenceDialogFragmentCompat.this.getDialog() != null) {
                    SpectrumPreferenceDialogFragmentCompat.this.getDialog().dismiss();
                }
            }
        }
    }

    private SpectrumPreferenceCompat c() {
        return (SpectrumPreferenceCompat) getPreference();
    }

    public static SpectrumPreferenceDialogFragmentCompat newInstance(String str) {
        SpectrumPreferenceDialogFragmentCompat spectrumPreferenceDialogFragmentCompat = new SpectrumPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        spectrumPreferenceDialogFragmentCompat.setArguments(bundle);
        return spectrumPreferenceDialogFragmentCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onBindDialogView(View view) {
        super.onBindDialogView(view);
        SpectrumPreferenceCompat c4 = c();
        if (c4.getColors() != null) {
            this.f38077c = c4.getColor();
            SpectrumPalette spectrumPalette = (SpectrumPalette) view.findViewById(R.id.palette);
            this.f38076b = spectrumPalette;
            spectrumPalette.setColors(c().getColors());
            this.f38076b.setSelectedColor(this.f38077c);
            this.f38076b.setOutlineWidth(c().getOutlineWidth());
            this.f38076b.setFixedColumnCount(c().getFixedColumnCount());
            this.f38076b.setOnColorSelectedListener(new a(c4));
            return;
        }
        throw new RuntimeException("SpectrumPreference requires a colors array");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z3) {
        SpectrumPreferenceCompat c4 = c();
        if (z3 && c4.callChangeListener(Integer.valueOf(this.f38077c))) {
            c4.setColor(this.f38077c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if (c().getCloseOnSelected()) {
            builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        }
    }
}
