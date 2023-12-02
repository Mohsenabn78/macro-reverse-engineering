package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTileKt;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int INPUT_MODE_CLOCK = 0;
    public static final int INPUT_MODE_KEYBOARD = 1;

    /* renamed from: f  reason: collision with root package name */
    private TimePickerView f24750f;

    /* renamed from: g  reason: collision with root package name */
    private ViewStub f24751g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private TimePickerClockPresenter f24752h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TimePickerTextInputPresenter f24753i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private TimePickerPresenter f24754j;
    @DrawableRes

    /* renamed from: k  reason: collision with root package name */
    private int f24755k;
    @DrawableRes

    /* renamed from: l  reason: collision with root package name */
    private int f24756l;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f24758n;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f24760p;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f24762r;

    /* renamed from: s  reason: collision with root package name */
    private MaterialButton f24763s;

    /* renamed from: t  reason: collision with root package name */
    private Button f24764t;

    /* renamed from: v  reason: collision with root package name */
    private TimeModel f24766v;

    /* renamed from: b  reason: collision with root package name */
    private final Set<View.OnClickListener> f24746b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<View.OnClickListener> f24747c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<DialogInterface.OnCancelListener> f24748d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f24749e = new LinkedHashSet();
    @StringRes

    /* renamed from: m  reason: collision with root package name */
    private int f24757m = 0;
    @StringRes

    /* renamed from: o  reason: collision with root package name */
    private int f24759o = 0;
    @StringRes

    /* renamed from: q  reason: collision with root package name */
    private int f24761q = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f24765u = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f24767w = 0;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: b  reason: collision with root package name */
        private int f24772b;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f24774d;

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f24776f;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f24778h;

        /* renamed from: a  reason: collision with root package name */
        private TimeModel f24771a = new TimeModel();
        @StringRes

        /* renamed from: c  reason: collision with root package name */
        private int f24773c = 0;
        @StringRes

        /* renamed from: e  reason: collision with root package name */
        private int f24775e = 0;
        @StringRes

        /* renamed from: g  reason: collision with root package name */
        private int f24777g = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f24779i = 0;

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.l(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int i4) {
            this.f24771a.h(i4);
            return this;
        }

        @NonNull
        public Builder setInputMode(int i4) {
            this.f24772b = i4;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = 60) int i4) {
            this.f24771a.i(i4);
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@StringRes int i4) {
            this.f24777g = i4;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@StringRes int i4) {
            this.f24775e = i4;
            return this;
        }

        @NonNull
        public Builder setTheme(@StyleRes int i4) {
            this.f24779i = i4;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int i4) {
            TimeModel timeModel = this.f24771a;
            int i5 = timeModel.f24788d;
            int i6 = timeModel.f24789e;
            TimeModel timeModel2 = new TimeModel(i4);
            this.f24771a = timeModel2;
            timeModel2.i(i6);
            this.f24771a.h(i5);
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int i4) {
            this.f24773c = i4;
            return this;
        }

        @NonNull
        public Builder setNegativeButtonText(@Nullable CharSequence charSequence) {
            this.f24778h = charSequence;
            return this;
        }

        @NonNull
        public Builder setPositiveButtonText(@Nullable CharSequence charSequence) {
            this.f24776f = charSequence;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence charSequence) {
            this.f24774d = charSequence;
            return this;
        }
    }

    private Pair<Integer, Integer> i(int i4) {
        if (i4 != 0) {
            if (i4 == 1) {
                return new Pair<>(Integer.valueOf(this.f24756l), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
            }
            throw new IllegalArgumentException("no icon for mode: " + i4);
        }
        return new Pair<>(Integer.valueOf(this.f24755k), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int j() {
        int i4 = this.f24767w;
        if (i4 != 0) {
            return i4;
        }
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private TimePickerPresenter k(int i4, @NonNull TimePickerView timePickerView, @NonNull ViewStub viewStub) {
        if (i4 == 0) {
            TimePickerClockPresenter timePickerClockPresenter = this.f24752h;
            if (timePickerClockPresenter == null) {
                timePickerClockPresenter = new TimePickerClockPresenter(timePickerView, this.f24766v);
            }
            this.f24752h = timePickerClockPresenter;
            return timePickerClockPresenter;
        }
        if (this.f24753i == null) {
            this.f24753i = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.f24766v);
        }
        this.f24753i.d();
        return this.f24753i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static MaterialTimePicker l(@NonNull Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", builder.f24771a);
        bundle.putInt("TIME_PICKER_INPUT_MODE", builder.f24772b);
        bundle.putInt("TIME_PICKER_TITLE_RES", builder.f24773c);
        if (builder.f24774d != null) {
            bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", builder.f24774d);
        }
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", builder.f24775e);
        if (builder.f24776f != null) {
            bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", builder.f24776f);
        }
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", builder.f24777g);
        if (builder.f24778h != null) {
            bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", builder.f24778h);
        }
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", builder.f24779i);
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void m(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.f24766v = timeModel;
        if (timeModel == null) {
            this.f24766v = new TimeModel();
        }
        this.f24765u = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
        this.f24757m = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.f24758n = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.f24759o = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.f24760p = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.f24761q = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.f24762r = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.f24767w = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    private void n() {
        int i4;
        Button button = this.f24764t;
        if (button != null) {
            if (isCancelable()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            button.setVisibility(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(MaterialButton materialButton) {
        if (materialButton != null && this.f24750f != null && this.f24751g != null) {
            TimePickerPresenter timePickerPresenter = this.f24754j;
            if (timePickerPresenter != null) {
                timePickerPresenter.hide();
            }
            TimePickerPresenter k4 = k(this.f24765u, this.f24750f, this.f24751g);
            this.f24754j = k4;
            k4.show();
            this.f24754j.invalidate();
            Pair<Integer, Integer> i4 = i(this.f24765u);
            materialButton.setIconResource(((Integer) i4.first).intValue());
            materialButton.setContentDescription(getResources().getString(((Integer) i4.second).intValue()));
            materialButton.sendAccessibilityEvent(4);
        }
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.f24748d.add(onCancelListener);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.f24749e.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.f24747c.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.f24746b.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.f24748d.clear();
    }

    public void clearOnDismissListeners() {
        this.f24749e.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.f24747c.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.f24746b.clear();
    }

    @IntRange(from = 0, to = HomeScreenTileKt.TILE_ID_ACTION_BLOCKS)
    public int getHour() {
        return this.f24766v.f24788d % 24;
    }

    public int getInputMode() {
        return this.f24765u;
    }

    @IntRange(from = 0, to = 60)
    public int getMinute() {
        return this.f24766v.f24789e;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancelListener : this.f24748d) {
            onCancelListener.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        m(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), j());
        Context context = dialog.getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i4 = R.attr.materialTimePickerStyle;
        int i5 = R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i4, i5);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, i4, i5);
        this.f24756l = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.f24755k = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.setElevation(ViewCompat.getElevation(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.f24750f = timePickerView;
        timePickerView.k(this);
        this.f24751g = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.f24763s = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        int i4 = this.f24757m;
        if (i4 != 0) {
            textView.setText(i4);
        } else if (!TextUtils.isEmpty(this.f24758n)) {
            textView.setText(this.f24758n);
        }
        o(this.f24763s);
        Button button = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (View.OnClickListener onClickListener : MaterialTimePicker.this.f24746b) {
                    onClickListener.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i5 = this.f24759o;
        if (i5 != 0) {
            button.setText(i5);
        } else if (!TextUtils.isEmpty(this.f24760p)) {
            button.setText(this.f24760p);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        this.f24764t = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                for (View.OnClickListener onClickListener : MaterialTimePicker.this.f24747c) {
                    onClickListener.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        int i6 = this.f24761q;
        if (i6 != 0) {
            this.f24764t.setText(i6);
        } else if (!TextUtils.isEmpty(this.f24762r)) {
            this.f24764t.setText(this.f24762r);
        }
        n();
        this.f24763s.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i7;
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                if (materialTimePicker.f24765u == 0) {
                    i7 = 1;
                } else {
                    i7 = 0;
                }
                materialTimePicker.f24765u = i7;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.o(materialTimePicker2.f24763s);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f24754j = null;
        this.f24752h = null;
        this.f24753i = null;
        TimePickerView timePickerView = this.f24750f;
        if (timePickerView != null) {
            timePickerView.k(null);
            this.f24750f = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.f24749e) {
            onDismissListener.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDoubleTap() {
        this.f24765u = 1;
        o(this.f24763s);
        this.f24753i.g();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f24766v);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f24765u);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f24757m);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.f24758n);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.f24759o);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.f24760p);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.f24761q);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.f24762r);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.f24767w);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.f24748d.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.f24749e.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.f24747c.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.f24746b.remove(onClickListener);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z3) {
        super.setCancelable(z3);
        n();
    }
}
