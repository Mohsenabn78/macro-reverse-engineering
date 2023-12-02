package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TextViewTextChangeEvent.java */
/* loaded from: classes6.dex */
public final class w extends TextViewTextChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34434a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f34435b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34436c;

    /* renamed from: d  reason: collision with root package name */
    private final int f34437d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34438e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TextView textView, CharSequence charSequence, int i4, int i5, int i6) {
        if (textView != null) {
            this.f34434a = textView;
            if (charSequence != null) {
                this.f34435b = charSequence;
                this.f34436c = i4;
                this.f34437d = i5;
                this.f34438e = i6;
                return;
            }
            throw new NullPointerException("Null text");
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public int before() {
        return this.f34437d;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public int count() {
        return this.f34438e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewTextChangeEvent)) {
            return false;
        }
        TextViewTextChangeEvent textViewTextChangeEvent = (TextViewTextChangeEvent) obj;
        if (this.f34434a.equals(textViewTextChangeEvent.view()) && this.f34435b.equals(textViewTextChangeEvent.text()) && this.f34436c == textViewTextChangeEvent.start() && this.f34437d == textViewTextChangeEvent.before() && this.f34438e == textViewTextChangeEvent.count()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f34434a.hashCode() ^ 1000003) * 1000003) ^ this.f34435b.hashCode()) * 1000003) ^ this.f34436c) * 1000003) ^ this.f34437d) * 1000003) ^ this.f34438e;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    public int start() {
        return this.f34436c;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    @NonNull
    public CharSequence text() {
        return this.f34435b;
    }

    public String toString() {
        return "TextViewTextChangeEvent{view=" + this.f34434a + ", text=" + ((Object) this.f34435b) + ", start=" + this.f34436c + ", before=" + this.f34437d + ", count=" + this.f34438e + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
    @NonNull
    public TextView view() {
        return this.f34434a;
    }
}
