package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class CalendarStyle {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final CalendarItemStyle f23426a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final CalendarItemStyle f23427b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final CalendarItemStyle f23428c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final CalendarItemStyle f23429d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final CalendarItemStyle f23430e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final CalendarItemStyle f23431f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    final CalendarItemStyle f23432g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final Paint f23433h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarStyle(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f23426a = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f23432g = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f23427b = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f23428c = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f23429d = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f23430e = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f23431f = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f23433h = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
