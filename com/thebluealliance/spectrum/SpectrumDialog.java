package com.thebluealliance.spectrum;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.thebluealliance.spectrum.SpectrumPalette;

/* loaded from: classes6.dex */
public class SpectrumDialog extends DialogFragment implements SpectrumPalette.OnColorSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f38009b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f38010c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f38011d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    private int[] f38012e;

    /* renamed from: i  reason: collision with root package name */
    private OnColorSelectedListener f38016i;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f38013f = -1;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private int f38014g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38015h = true;

    /* renamed from: j  reason: collision with root package name */
    private int f38017j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f38018k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f38019l = 0;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f38020a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f38021b;

        /* renamed from: c  reason: collision with root package name */
        private OnColorSelectedListener f38022c;

        public Builder(Context context) {
            this.f38020a = context;
            this.f38021b = new Bundle();
        }

        public SpectrumDialog build() {
            SpectrumDialog spectrumDialog = new SpectrumDialog();
            spectrumDialog.setArguments(this.f38021b);
            spectrumDialog.setOnColorSelectedListener(this.f38022c);
            return spectrumDialog;
        }

        public Builder setColors(@ColorInt int[] iArr) {
            this.f38021b.putIntArray("colors", iArr);
            return this;
        }

        public Builder setDismissOnColorSelected(boolean z3) {
            this.f38021b.putBoolean("should_dismiss_on_color_selected", z3);
            return this;
        }

        public Builder setFixedColumnCount(int i4) {
            this.f38021b.putInt("fixed_column_count", i4);
            return this;
        }

        public Builder setNegativeButtonText(CharSequence charSequence) {
            this.f38021b.putCharSequence("negative_button_text", charSequence);
            return this;
        }

        public Builder setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
            this.f38022c = onColorSelectedListener;
            return this;
        }

        public Builder setOutlineWidth(int i4) {
            this.f38021b.putInt("border_width", i4);
            return this;
        }

        public Builder setPositiveButtonText(CharSequence charSequence) {
            this.f38021b.putCharSequence("positive_button_text", charSequence);
            return this;
        }

        public Builder setSelectedColor(@ColorInt int i4) {
            this.f38021b.putInt("selected_color", i4);
            this.f38021b.putInt("origina_selected_color", i4);
            return this;
        }

        public Builder setSelectedColorRes(@ColorRes int i4) {
            int color = ContextCompat.getColor(this.f38020a, i4);
            this.f38021b.putInt("selected_color", color);
            this.f38021b.putInt("origina_selected_color", color);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f38021b.putCharSequence("title", charSequence);
            return this;
        }

        public Builder setColors(@ArrayRes int i4) {
            this.f38021b.putIntArray("colors", this.f38020a.getResources().getIntArray(i4));
            return this;
        }

        public Builder setNegativeButtonText(@StringRes int i4) {
            this.f38021b.putCharSequence("negative_button_text", this.f38020a.getText(i4));
            return this;
        }

        public Builder setPositiveButtonText(@StringRes int i4) {
            this.f38021b.putCharSequence("positive_button_text", this.f38020a.getText(i4));
            return this;
        }

        public Builder setTitle(@StringRes int i4) {
            this.f38021b.putCharSequence("title", this.f38020a.getText(i4));
            return this;
        }

        public Builder(Context context, int i4) {
            this.f38020a = context;
            Bundle bundle = new Bundle();
            this.f38021b = bundle;
            bundle.putInt("theme_res_id", i4);
        }
    }

    /* loaded from: classes6.dex */
    public interface OnColorSelectedListener {
        void onColorSelected(boolean z3, @ColorInt int i4);
    }

    /* loaded from: classes6.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            if (SpectrumDialog.this.f38016i != null) {
                SpectrumDialog.this.f38016i.onColorSelected(true, SpectrumDialog.this.f38014g);
            }
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            if (SpectrumDialog.this.f38016i != null) {
                SpectrumDialog.this.f38016i.onColorSelected(false, SpectrumDialog.this.f38013f);
            }
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OnColorSelectedListener onColorSelectedListener = this.f38016i;
        if (onColorSelectedListener != null) {
            onColorSelectedListener.onColorSelected(false, this.f38013f);
        }
    }

    @Override // com.thebluealliance.spectrum.SpectrumPalette.OnColorSelectedListener
    public void onColorSelected(@ColorInt int i4) {
        this.f38014g = i4;
        if (this.f38015h) {
            OnColorSelectedListener onColorSelectedListener = this.f38016i;
            if (onColorSelectedListener != null) {
                onColorSelectedListener.onColorSelected(true, i4);
            }
            dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("title")) {
            this.f38009b = arguments.getCharSequence("title");
        } else {
            this.f38009b = getContext().getText(R.string.default_dialog_title);
        }
        if (arguments != null && arguments.containsKey("colors")) {
            this.f38012e = arguments.getIntArray("colors");
        } else {
            this.f38012e = new int[]{-16777216};
        }
        int[] iArr = this.f38012e;
        if (iArr != null && iArr.length != 0) {
            if (arguments != null && arguments.containsKey("selected_color")) {
                this.f38014g = arguments.getInt("selected_color");
            } else {
                this.f38014g = this.f38012e[0];
            }
            if (arguments != null && arguments.containsKey("origina_selected_color")) {
                this.f38013f = arguments.getInt("origina_selected_color");
            } else {
                this.f38013f = this.f38014g;
            }
            if (arguments != null && arguments.containsKey("should_dismiss_on_color_selected")) {
                this.f38015h = arguments.getBoolean("should_dismiss_on_color_selected");
            } else {
                this.f38015h = true;
            }
            if (arguments != null && arguments.containsKey("positive_button_text")) {
                this.f38010c = arguments.getCharSequence("positive_button_text");
            } else {
                this.f38010c = getContext().getText(17039370);
            }
            if (arguments != null && arguments.containsKey("negative_button_text")) {
                this.f38011d = arguments.getCharSequence("negative_button_text");
            } else {
                this.f38011d = getContext().getText(17039360);
            }
            if (arguments != null && arguments.containsKey("border_width")) {
                this.f38017j = arguments.getInt("border_width");
            }
            if (arguments != null && arguments.containsKey("fixed_column_count")) {
                this.f38018k = arguments.getInt("fixed_column_count");
            }
            if (arguments != null && arguments.containsKey("theme_res_id")) {
                this.f38019l = arguments.getInt("theme_res_id");
            }
            if (bundle != null && bundle.containsKey("selected_color")) {
                this.f38014g = bundle.getInt("selected_color");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("SpectrumDialog must be created with an array of colors");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder;
        if (this.f38019l != 0) {
            builder = new AlertDialog.Builder(getContext(), this.f38019l);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(this.f38009b);
        if (this.f38015h) {
            builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton(this.f38010c, new a());
        }
        builder.setNegativeButton(this.f38011d, new b());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_color_picker, (ViewGroup) null);
        SpectrumPalette spectrumPalette = (SpectrumPalette) inflate.findViewById(R.id.palette);
        spectrumPalette.setColors(this.f38012e);
        spectrumPalette.setSelectedColor(this.f38014g);
        spectrumPalette.setOnColorSelectedListener(this);
        int i4 = this.f38017j;
        if (i4 != 0) {
            spectrumPalette.setOutlineWidth(i4);
        }
        int i5 = this.f38018k;
        if (i5 > 0) {
            spectrumPalette.setFixedColumnCount(i5);
        }
        builder.setView(inflate);
        return builder.create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f38016i = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selected_color", this.f38014g);
    }

    public void setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
        this.f38016i = onColorSelectedListener;
    }
}
