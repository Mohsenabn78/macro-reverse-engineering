package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes5.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public static final int INPUT_MODE_CALENDAR = 0;
    public static final int INPUT_MODE_TEXT = 1;

    /* renamed from: s  reason: collision with root package name */
    static final Object f23492s = "CONFIRM_BUTTON_TAG";

    /* renamed from: t  reason: collision with root package name */
    static final Object f23493t = "CANCEL_BUTTON_TAG";

    /* renamed from: u  reason: collision with root package name */
    static final Object f23494u = "TOGGLE_BUTTON_TAG";

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> f23495b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f23496c = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f23497d = new LinkedHashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f23498e = new LinkedHashSet<>();
    @StyleRes

    /* renamed from: f  reason: collision with root package name */
    private int f23499f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private DateSelector<S> f23500g;

    /* renamed from: h  reason: collision with root package name */
    private PickerFragment<S> f23501h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private CalendarConstraints f23502i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialCalendar<S> f23503j;
    @StringRes

    /* renamed from: k  reason: collision with root package name */
    private int f23504k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f23505l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23506m;

    /* renamed from: n  reason: collision with root package name */
    private int f23507n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f23508o;

    /* renamed from: p  reason: collision with root package name */
    private CheckableImageButton f23509p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private MaterialShapeDrawable f23510q;

    /* renamed from: r  reason: collision with root package name */
    private Button f23511r;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface InputMode {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> getDateSelector() {
        if (this.f23500g == null) {
            this.f23500g = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f23500g;
    }

    @NonNull
    private static Drawable j(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int k(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i4 = Month.d().f23533d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i4) + ((i4 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int l(Context context) {
        int i4 = this.f23499f;
        if (i4 != 0) {
            return i4;
        }
        return getDateSelector().getDefaultThemeResId(context);
    }

    private void m(Context context) {
        boolean z3;
        this.f23509p.setTag(f23494u);
        this.f23509p.setImageDrawable(j(context));
        CheckableImageButton checkableImageButton = this.f23509p;
        if (this.f23507n != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkableImageButton.setChecked(z3);
        ViewCompat.setAccessibilityDelegate(this.f23509p, null);
        t(this.f23509p);
        this.f23509p.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialDatePicker.this.f23511r.setEnabled(MaterialDatePicker.this.getDateSelector().isSelectionComplete());
                MaterialDatePicker.this.f23509p.toggle();
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.t(materialDatePicker.f23509p);
                MaterialDatePicker.this.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n(@NonNull Context context) {
        return q(context, 16843277);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o(@NonNull Context context) {
        return q(context, R.attr.nestedScrollable);
    }

    @NonNull
    static <S> MaterialDatePicker<S> p(@NonNull Builder<S> builder) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", builder.f23517b);
        bundle.putParcelable("DATE_SELECTOR_KEY", builder.f23516a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.f23518c);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", builder.f23519d);
        bundle.putCharSequence("TITLE_TEXT_KEY", builder.f23520e);
        bundle.putInt("INPUT_MODE_KEY", builder.f23522g);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    static boolean q(@NonNull Context context, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i4});
        boolean z3 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        PickerFragment<S> pickerFragment;
        int l4 = l(requireContext());
        this.f23503j = MaterialCalendar.newInstance(getDateSelector(), l4, this.f23502i);
        if (this.f23509p.isChecked()) {
            pickerFragment = MaterialTextInputPicker.c(getDateSelector(), l4, this.f23502i);
        } else {
            pickerFragment = this.f23503j;
        }
        this.f23501h = pickerFragment;
        s();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.f23501h);
        beginTransaction.commitNow();
        this.f23501h.addOnSelectionChangedListener(new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.f23511r.setEnabled(false);
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void onSelectionChanged(S s3) {
                MaterialDatePicker.this.s();
                MaterialDatePicker.this.f23511r.setEnabled(MaterialDatePicker.this.getDateSelector().isSelectionComplete());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        String headerText = getHeaderText();
        this.f23508o.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), headerText));
        this.f23508o.setText(headerText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.f23509p.isChecked()) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.f23509p.setContentDescription(string);
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.d().f23535f;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.o().getTimeInMillis();
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.f23497d.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.f23498e.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.f23496c.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.f23495b.add(materialPickerOnPositiveButtonClickListener);
    }

    public void clearOnCancelListeners() {
        this.f23497d.clear();
    }

    public void clearOnDismissListeners() {
        this.f23498e.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.f23496c.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.f23495b.clear();
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f23497d.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f23499f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f23500g = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f23502i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f23504k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f23505l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f23507n = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), l(requireContext()));
        Context context = dialog.getContext();
        this.f23506m = n(context);
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f23510q = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        this.f23510q.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        this.f23510q.setElevation(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i4;
        if (this.f23506m) {
            i4 = R.layout.mtrl_picker_fullscreen;
        } else {
            i4 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i4, viewGroup);
        Context context = inflate.getContext();
        if (this.f23506m) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(k(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(k(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f23508o = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.f23509p = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f23505l;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f23504k);
        }
        m(context);
        this.f23511r = (Button) inflate.findViewById(R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.f23511r.setEnabled(true);
        } else {
            this.f23511r.setEnabled(false);
        }
        this.f23511r.setTag(f23492s);
        this.f23511r.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f23495b.iterator();
                while (it.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(MaterialDatePicker.this.getSelection());
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(f23493t);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f23496c.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f23498e.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f23499f);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f23500g);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.f23502i);
        if (this.f23503j.n() != null) {
            builder.setOpenAt(this.f23503j.n().f23535f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.build());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f23504k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f23505l);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f23506m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f23510q);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f23510q, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        r();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f23501h.b();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.f23497d.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.f23498e.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.f23496c.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.f23495b.remove(materialPickerOnPositiveButtonClickListener);
    }

    /* loaded from: classes5.dex */
    public static final class Builder<S> {

        /* renamed from: a  reason: collision with root package name */
        final DateSelector<S> f23516a;

        /* renamed from: c  reason: collision with root package name */
        CalendarConstraints f23518c;

        /* renamed from: b  reason: collision with root package name */
        int f23517b = 0;

        /* renamed from: d  reason: collision with root package name */
        int f23519d = 0;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f23520e = null;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        S f23521f = null;

        /* renamed from: g  reason: collision with root package name */
        int f23522g = 0;

        private Builder(DateSelector<S> dateSelector) {
            this.f23516a = dateSelector;
        }

        private Month a() {
            if (!this.f23516a.getSelectedDays().isEmpty()) {
                Month c4 = Month.c(this.f23516a.getSelectedDays().iterator().next().longValue());
                if (b(c4, this.f23518c)) {
                    return c4;
                }
            }
            Month d4 = Month.d();
            if (!b(d4, this.f23518c)) {
                return this.f23518c.i();
            }
            return d4;
        }

        private static boolean b(Month month, CalendarConstraints calendarConstraints) {
            if (month.compareTo(calendarConstraints.i()) >= 0 && month.compareTo(calendarConstraints.f()) <= 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector) {
            return new Builder<>(dateSelector);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder<>(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder<>(new RangeDateSelector());
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.f23518c == null) {
                this.f23518c = new CalendarConstraints.Builder().build();
            }
            if (this.f23519d == 0) {
                this.f23519d = this.f23516a.getDefaultTitleResId();
            }
            S s3 = this.f23521f;
            if (s3 != null) {
                this.f23516a.setSelection(s3);
            }
            if (this.f23518c.h() == null) {
                this.f23518c.l(a());
            }
            return MaterialDatePicker.p(this);
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints) {
            this.f23518c = calendarConstraints;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int i4) {
            this.f23522g = i4;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S s3) {
            this.f23521f = s3;
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int i4) {
            this.f23517b = i4;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int i4) {
            this.f23519d = i4;
            this.f23520e = null;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence charSequence) {
            this.f23520e = charSequence;
            this.f23519d = 0;
            return this;
        }
    }
}
