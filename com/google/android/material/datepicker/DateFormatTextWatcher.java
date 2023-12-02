package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes5.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f23438a;

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f23439b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f23440c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23441d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f23442e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f23443f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateFormatTextWatcher(final String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f23439b = dateFormat;
        this.f23438a = textInputLayout;
        this.f23440c = calendarConstraints;
        this.f23441d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f23442e = new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.1
            @Override // java.lang.Runnable
            public void run() {
                TextInputLayout textInputLayout2 = DateFormatTextWatcher.this.f23438a;
                DateFormat dateFormat2 = DateFormatTextWatcher.this.f23439b;
                Context context = textInputLayout2.getContext();
                String string = context.getString(R.string.mtrl_picker_invalid_format);
                String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), str);
                String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat2.format(new Date(UtcDates.o().getTimeInMillis())));
                textInputLayout2.setError(string + "\n" + format + "\n" + format2);
                DateFormatTextWatcher.this.e();
            }
        };
    }

    private Runnable d(final long j4) {
        return new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.2
            @Override // java.lang.Runnable
            public void run() {
                DateFormatTextWatcher.this.f23438a.setError(String.format(DateFormatTextWatcher.this.f23441d, DateStrings.c(j4)));
                DateFormatTextWatcher.this.e();
            }
        };
    }

    abstract void f(@Nullable Long l4);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i4, int i5, int i6) {
        this.f23438a.removeCallbacks(this.f23442e);
        this.f23438a.removeCallbacks(this.f23443f);
        this.f23438a.setError(null);
        f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date parse = this.f23439b.parse(charSequence.toString());
            this.f23438a.setError(null);
            long time = parse.getTime();
            if (this.f23440c.getDateValidator().isValid(time) && this.f23440c.k(time)) {
                f(Long.valueOf(parse.getTime()));
                return;
            }
            Runnable d4 = d(time);
            this.f23443f = d4;
            g(this.f23438a, d4);
        } catch (ParseException unused) {
            g(this.f23438a, this.f23442e);
        }
    }

    void e() {
    }
}
