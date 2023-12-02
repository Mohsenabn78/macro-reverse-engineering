package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f23489a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23490b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i4, Rect rect) {
        if (i4 == 33) {
            setSelection(getAdapter2().i());
        } else if (i4 == 130) {
            setSelection(getAdapter2().b());
        } else {
            super.onFocusChanged(true, i4, rect);
        }
    }

    private View c(int i4) {
        return getChildAt(i4 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(@Nullable Long l4, @Nullable Long l5, @Nullable Long l6, @Nullable Long l7) {
        if (l4 == null || l5 == null || l6 == null || l7 == null || l6.longValue() > l5.longValue() || l7.longValue() < l4.longValue()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: b */
    public MonthAdapter getAdapter2() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int a4;
        int d4;
        int a5;
        int d5;
        int i4;
        int i5;
        int i6;
        int i7;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter2 = getAdapter2();
        DateSelector<?> dateSelector = adapter2.f23539b;
        CalendarStyle calendarStyle = adapter2.f23541d;
        int max = Math.max(adapter2.b(), getFirstVisiblePosition());
        int min = Math.min(adapter2.i(), getLastVisiblePosition());
        Long item = adapter2.getItem(max);
        Long item2 = adapter2.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair<Long, Long> next = it.next();
            Long l4 = next.first;
            if (l4 != null) {
                if (next.second != null) {
                    long longValue = l4.longValue();
                    long longValue2 = next.second.longValue();
                    if (!e(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (longValue < item.longValue()) {
                            if (adapter2.f(max)) {
                                left2 = 0;
                            } else if (!isLayoutRtl) {
                                left2 = materialCalendarGridView.c(max - 1).getRight();
                            } else {
                                left2 = materialCalendarGridView.c(max - 1).getLeft();
                            }
                            d4 = left2;
                            a4 = max;
                        } else {
                            materialCalendarGridView.f23489a.setTimeInMillis(longValue);
                            a4 = adapter2.a(materialCalendarGridView.f23489a.get(5));
                            d4 = d(materialCalendarGridView.c(a4));
                        }
                        if (longValue2 > item2.longValue()) {
                            if (adapter2.g(min)) {
                                left = getWidth();
                            } else if (!isLayoutRtl) {
                                left = materialCalendarGridView.c(min).getRight();
                            } else {
                                left = materialCalendarGridView.c(min).getLeft();
                            }
                            d5 = left;
                            a5 = min;
                        } else {
                            materialCalendarGridView.f23489a.setTimeInMillis(longValue2);
                            a5 = adapter2.a(materialCalendarGridView.f23489a.get(5));
                            d5 = d(materialCalendarGridView.c(a5));
                        }
                        int itemId = (int) adapter2.getItemId(a4);
                        int i8 = max;
                        int i9 = min;
                        int itemId2 = (int) adapter2.getItemId(a5);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            MonthAdapter monthAdapter = adapter2;
                            int numColumns2 = (numColumns + getNumColumns()) - 1;
                            View c4 = materialCalendarGridView.c(numColumns);
                            int top = c4.getTop() + calendarStyle.f23426a.c();
                            Iterator<Pair<Long, Long>> it2 = it;
                            int bottom = c4.getBottom() - calendarStyle.f23426a.b();
                            if (!isLayoutRtl) {
                                if (numColumns > a4) {
                                    i6 = 0;
                                } else {
                                    i6 = d4;
                                }
                                if (a5 > numColumns2) {
                                    i7 = getWidth();
                                } else {
                                    i7 = d5;
                                }
                            } else {
                                if (a5 > numColumns2) {
                                    i4 = 0;
                                } else {
                                    i4 = d5;
                                }
                                if (numColumns > a4) {
                                    i5 = getWidth();
                                } else {
                                    i5 = d4;
                                }
                                int i10 = i5;
                                i6 = i4;
                                i7 = i10;
                            }
                            canvas.drawRect(i6, top, i7, bottom, calendarStyle.f23433h);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            adapter2 = monthAdapter;
                            it = it2;
                        }
                        materialCalendarGridView = this;
                        max = i8;
                        min = i9;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z3, int i4, Rect rect) {
        if (z3) {
            a(i4, rect);
        } else {
            super.onFocusChanged(false, i4, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (!super.onKeyDown(i4, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
            return true;
        }
        if (19 != i4) {
            return false;
        }
        setSelection(getAdapter2().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i4, int i5) {
        if (this.f23490b) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i4) {
        if (i4 < getAdapter2().b()) {
            super.setSelection(getAdapter2().b());
        } else {
            super.setSelection(i4);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f23489a = UtcDates.q();
        if (MaterialDatePicker.n(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f23490b = MaterialDatePicker.o(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
    }
}
