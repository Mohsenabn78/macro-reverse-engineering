package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TextViewAfterTextChangeEvent.java */
/* loaded from: classes6.dex */
public final class t extends TextViewAfterTextChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34424a;

    /* renamed from: b  reason: collision with root package name */
    private final Editable f34425b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TextView textView, @Nullable Editable editable) {
        if (textView != null) {
            this.f34424a = textView;
            this.f34425b = editable;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
    @Nullable
    public Editable editable() {
        return this.f34425b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewAfterTextChangeEvent)) {
            return false;
        }
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        if (this.f34424a.equals(textViewAfterTextChangeEvent.view())) {
            Editable editable = this.f34425b;
            if (editable == null) {
                if (textViewAfterTextChangeEvent.editable() == null) {
                    return true;
                }
            } else if (editable.equals(textViewAfterTextChangeEvent.editable())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f34424a.hashCode() ^ 1000003) * 1000003;
        Editable editable = this.f34425b;
        if (editable == null) {
            hashCode = 0;
        } else {
            hashCode = editable.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "TextViewAfterTextChangeEvent{view=" + this.f34424a + ", editable=" + ((Object) this.f34425b) + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
    @NonNull
    public TextView view() {
        return this.f34424a;
    }
}
