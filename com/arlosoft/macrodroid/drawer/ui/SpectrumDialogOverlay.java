package com.arlosoft.macrodroid.drawer.ui;

import android.app.AlertDialog;
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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.arlosoft.macrodroid.R;
import com.thebluealliance.spectrum.SpectrumPalette;

/* loaded from: classes3.dex */
public class SpectrumDialogOverlay extends DialogFragment implements SpectrumPalette.OnColorSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f11553b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f11554c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f11555d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    private int[] f11556e;

    /* renamed from: i  reason: collision with root package name */
    private OnColorSelectedListener f11560i;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f11557f = -1;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private int f11558g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11559h = true;

    /* renamed from: j  reason: collision with root package name */
    private int f11561j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f11562k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f11563l = 0;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f11564a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f11565b;

        /* renamed from: c  reason: collision with root package name */
        private OnColorSelectedListener f11566c;

        public Builder(Context context) {
            this.f11564a = context;
            this.f11565b = new Bundle();
        }

        public SpectrumDialogOverlay build() {
            SpectrumDialogOverlay spectrumDialogOverlay = new SpectrumDialogOverlay();
            spectrumDialogOverlay.setArguments(this.f11565b);
            spectrumDialogOverlay.setOnColorSelectedListener(this.f11566c);
            return spectrumDialogOverlay;
        }

        public Builder setColors(@ColorInt int[] iArr) {
            this.f11565b.putIntArray("colors", iArr);
            return this;
        }

        public Builder setDismissOnColorSelected(boolean z3) {
            this.f11565b.putBoolean("should_dismiss_on_color_selected", z3);
            return this;
        }

        public Builder setFixedColumnCount(int i4) {
            this.f11565b.putInt("fixed_column_count", i4);
            return this;
        }

        public Builder setNegativeButtonText(CharSequence charSequence) {
            this.f11565b.putCharSequence("negative_button_text", charSequence);
            return this;
        }

        public Builder setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
            this.f11566c = onColorSelectedListener;
            return this;
        }

        public Builder setOutlineWidth(int i4) {
            this.f11565b.putInt("border_width", i4);
            return this;
        }

        public Builder setPositiveButtonText(CharSequence charSequence) {
            this.f11565b.putCharSequence("positive_button_text", charSequence);
            return this;
        }

        public Builder setSelectedColor(@ColorInt int i4) {
            this.f11565b.putInt("selected_color", i4);
            this.f11565b.putInt("origina_selected_color", i4);
            return this;
        }

        public Builder setSelectedColorRes(@ColorRes int i4) {
            int color = ContextCompat.getColor(this.f11564a, i4);
            this.f11565b.putInt("selected_color", color);
            this.f11565b.putInt("origina_selected_color", color);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f11565b.putCharSequence("title", charSequence);
            return this;
        }

        public Builder setColors(@ArrayRes int i4) {
            this.f11565b.putIntArray("colors", this.f11564a.getResources().getIntArray(i4));
            return this;
        }

        public Builder setNegativeButtonText(@StringRes int i4) {
            this.f11565b.putCharSequence("negative_button_text", this.f11564a.getText(i4));
            return this;
        }

        public Builder setPositiveButtonText(@StringRes int i4) {
            this.f11565b.putCharSequence("positive_button_text", this.f11564a.getText(i4));
            return this;
        }

        public Builder setTitle(@StringRes int i4) {
            this.f11565b.putCharSequence("title", this.f11564a.getText(i4));
            return this;
        }

        public Builder(Context context, int i4) {
            this.f11564a = context;
            Bundle bundle = new Bundle();
            this.f11565b = bundle;
            bundle.putInt("theme_res_id", i4);
        }
    }

    /* loaded from: classes3.dex */
    public interface OnColorSelectedListener {
        void onColorSelected(boolean z3, @ColorInt int i4);
    }

    /* loaded from: classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            if (SpectrumDialogOverlay.this.f11560i != null) {
                SpectrumDialogOverlay.this.f11560i.onColorSelected(true, SpectrumDialogOverlay.this.f11558g);
            }
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            if (SpectrumDialogOverlay.this.f11560i != null) {
                SpectrumDialogOverlay.this.f11560i.onColorSelected(false, SpectrumDialogOverlay.this.f11557f);
            }
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OnColorSelectedListener onColorSelectedListener = this.f11560i;
        if (onColorSelectedListener != null) {
            onColorSelectedListener.onColorSelected(false, this.f11557f);
        }
    }

    @Override // com.thebluealliance.spectrum.SpectrumPalette.OnColorSelectedListener
    public void onColorSelected(@ColorInt int i4) {
        this.f11558g = i4;
        if (this.f11559h) {
            OnColorSelectedListener onColorSelectedListener = this.f11560i;
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
            this.f11553b = arguments.getCharSequence("title");
        } else {
            this.f11553b = getContext().getText(R.string.default_dialog_title);
        }
        if (arguments != null && arguments.containsKey("colors")) {
            this.f11556e = arguments.getIntArray("colors");
        } else {
            this.f11556e = new int[]{-16777216};
        }
        int[] iArr = this.f11556e;
        if (iArr != null && iArr.length != 0) {
            if (arguments != null && arguments.containsKey("selected_color")) {
                this.f11558g = arguments.getInt("selected_color");
            } else {
                this.f11558g = this.f11556e[0];
            }
            if (arguments != null && arguments.containsKey("origina_selected_color")) {
                this.f11557f = arguments.getInt("origina_selected_color");
            } else {
                this.f11557f = this.f11558g;
            }
            if (arguments != null && arguments.containsKey("should_dismiss_on_color_selected")) {
                this.f11559h = arguments.getBoolean("should_dismiss_on_color_selected");
            } else {
                this.f11559h = true;
            }
            if (arguments != null && arguments.containsKey("positive_button_text")) {
                this.f11554c = arguments.getCharSequence("positive_button_text");
            } else {
                this.f11554c = getContext().getText(17039370);
            }
            if (arguments != null && arguments.containsKey("negative_button_text")) {
                this.f11555d = arguments.getCharSequence("negative_button_text");
            } else {
                this.f11555d = getContext().getText(17039360);
            }
            if (arguments != null && arguments.containsKey("border_width")) {
                this.f11561j = arguments.getInt("border_width");
            }
            if (arguments != null && arguments.containsKey("fixed_column_count")) {
                this.f11562k = arguments.getInt("fixed_column_count");
            }
            if (arguments != null && arguments.containsKey("theme_res_id")) {
                this.f11563l = arguments.getInt("theme_res_id");
            }
            if (bundle != null && bundle.containsKey("selected_color")) {
                this.f11558g = bundle.getInt("selected_color");
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
        if (this.f11563l != 0) {
            builder = new AlertDialog.Builder(getContext(), this.f11563l);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle(this.f11553b);
        if (this.f11559h) {
            builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton(this.f11554c, new a());
        }
        builder.setNegativeButton(this.f11555d, new b());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_color_picker, (ViewGroup) null);
        SpectrumPalette spectrumPalette = (SpectrumPalette) inflate.findViewById(R.id.palette);
        spectrumPalette.setColors(this.f11556e);
        spectrumPalette.setSelectedColor(this.f11558g);
        spectrumPalette.setOnColorSelectedListener(this);
        int i4 = this.f11561j;
        if (i4 != 0) {
            spectrumPalette.setOutlineWidth(i4);
        }
        int i5 = this.f11562k;
        if (i5 > 0) {
            spectrumPalette.setFixedColumnCount(i5);
        }
        builder.setView(inflate);
        return builder.create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11560i = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selected_color", this.f11558g);
    }

    public void setOnColorSelectedListener(OnColorSelectedListener onColorSelectedListener) {
        this.f11560i = onColorSelectedListener;
    }
}
