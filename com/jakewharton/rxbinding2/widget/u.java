package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TextViewBeforeTextChangeEvent.java */
/* loaded from: classes6.dex */
public final class u extends TextViewBeforeTextChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34426a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f34427b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34428c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34429d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34430e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TextView textView, CharSequence charSequence, int i4, int i5, int i6) {
        if (textView != null) {
            this.f34426a = textView;
            if (charSequence != null) {
                this.f34427b = charSequence;
                this.f34428c = i4;
                this.f34429d = i5;
                this.f34430e = i6;
                return;
            }
            throw new NullPointerException("Null text");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public int after() {
        return this.f34430e;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public int count() {
        return this.f34429d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewBeforeTextChangeEvent)) {
            return false;
        }
        TextViewBeforeTextChangeEvent textViewBeforeTextChangeEvent = (TextViewBeforeTextChangeEvent) obj;
        if (this.f34426a.equals(textViewBeforeTextChangeEvent.view()) && this.f34427b.equals(textViewBeforeTextChangeEvent.text()) && this.f34428c == textViewBeforeTextChangeEvent.start() && this.f34429d == textViewBeforeTextChangeEvent.count() && this.f34430e == textViewBeforeTextChangeEvent.after()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f34426a.hashCode() ^ 1000003) * 1000003) ^ this.f34427b.hashCode()) * 1000003) ^ this.f34428c) * 1000003) ^ this.f34429d) * 1000003) ^ this.f34430e;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    public int start() {
        return this.f34428c;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    @NonNull
    public CharSequence text() {
        return this.f34427b;
    }

    public String toString() {
        return "TextViewBeforeTextChangeEvent{view=" + this.f34426a + ", text=" + ((Object) this.f34427b) + ", start=" + this.f34428c + ", count=" + this.f34429d + ", after=" + this.f34430e + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent
    @NonNull
    public TextView view() {
        return this.f34426a;
    }
}
