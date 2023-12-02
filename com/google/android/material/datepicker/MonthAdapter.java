package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class MonthAdapter extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final int f23537f = UtcDates.q().getMaximum(4);

    /* renamed from: a  reason: collision with root package name */
    final Month f23538a;

    /* renamed from: b  reason: collision with root package name */
    final DateSelector<?> f23539b;

    /* renamed from: c  reason: collision with root package name */
    private Collection<Long> f23540c;

    /* renamed from: d  reason: collision with root package name */
    CalendarStyle f23541d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f23542e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f23538a = month;
        this.f23539b = dateSelector;
        this.f23542e = calendarConstraints;
        this.f23540c = dateSelector.getSelectedDays();
    }

    private void e(Context context) {
        if (this.f23541d == null) {
            this.f23541d = new CalendarStyle(context);
        }
    }

    private boolean h(long j4) {
        Iterator<Long> it = this.f23539b.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (UtcDates.a(j4) == UtcDates.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(@Nullable TextView textView, long j4) {
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        if (this.f23542e.getDateValidator().isValid(j4)) {
            textView.setEnabled(true);
            if (h(j4)) {
                calendarItemStyle = this.f23541d.f23427b;
            } else if (UtcDates.o().getTimeInMillis() == j4) {
                calendarItemStyle = this.f23541d.f23428c;
            } else {
                calendarItemStyle = this.f23541d.f23426a;
            }
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.f23541d.f23432g;
        }
        calendarItemStyle.d(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j4) {
        if (Month.c(j4).equals(this.f23538a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(this.f23538a.g(j4)) - materialCalendarGridView.getFirstVisiblePosition()), j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i4) {
        return b() + (i4 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f23538a.e();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: c */
    public Long getItem(int i4) {
        if (i4 >= this.f23538a.e() && i4 <= i()) {
            return Long.valueOf(this.f23538a.f(j(i4)));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.f23538a
            int r2 = r8.f23534e
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.f23538a
            long r7 = r8.f(r7)
            com.google.android.material.datepicker.Month r3 = r5.f23538a
            int r3 = r3.f23532c
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.d()
            int r4 = r4.f23532c
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.DateStrings.g(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.DateStrings.l(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.k(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i4) {
        if (i4 % this.f23538a.f23533d == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i4) {
        if ((i4 + 1) % this.f23538a.f23533d == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23538a.f23534e + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4 / this.f23538a.f23533d;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return (this.f23538a.e() + this.f23538a.f23534e) - 1;
    }

    int j(int i4) {
        return (i4 - this.f23538a.e()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l4 : this.f23540c) {
            l(materialCalendarGridView, l4.longValue());
        }
        DateSelector<?> dateSelector = this.f23539b;
        if (dateSelector != null) {
            for (Long l5 : dateSelector.getSelectedDays()) {
                l(materialCalendarGridView, l5.longValue());
            }
            this.f23540c = this.f23539b.getSelectedDays();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(int i4) {
        if (i4 >= b() && i4 <= i()) {
            return true;
        }
        return false;
    }
}
