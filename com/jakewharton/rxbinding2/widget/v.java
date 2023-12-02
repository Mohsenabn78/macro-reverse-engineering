package com.jakewharton.rxbinding2.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_TextViewEditorActionEvent.java */
/* loaded from: classes6.dex */
public final class v extends TextViewEditorActionEvent {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34431a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34432b;

    /* renamed from: c  reason: collision with root package name */
    private final KeyEvent f34433c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TextView textView, int i4, @Nullable KeyEvent keyEvent) {
        if (textView != null) {
            this.f34431a = textView;
            this.f34432b = i4;
            this.f34433c = keyEvent;
            return;
        }
        throw new NullPointerException("Null view");
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    public int actionId() {
        return this.f34432b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewEditorActionEvent)) {
            return false;
        }
        TextViewEditorActionEvent textViewEditorActionEvent = (TextViewEditorActionEvent) obj;
        if (this.f34431a.equals(textViewEditorActionEvent.view()) && this.f34432b == textViewEditorActionEvent.actionId()) {
            KeyEvent keyEvent = this.f34433c;
            if (keyEvent == null) {
                if (textViewEditorActionEvent.keyEvent() == null) {
                    return true;
                }
            } else if (keyEvent.equals(textViewEditorActionEvent.keyEvent())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((this.f34431a.hashCode() ^ 1000003) * 1000003) ^ this.f34432b) * 1000003;
        KeyEvent keyEvent = this.f34433c;
        if (keyEvent == null) {
            hashCode = 0;
        } else {
            hashCode = keyEvent.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    @Nullable
    public KeyEvent keyEvent() {
        return this.f34433c;
    }

    public String toString() {
        return "TextViewEditorActionEvent{view=" + this.f34431a + ", actionId=" + this.f34432b + ", keyEvent=" + this.f34433c + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent
    @NonNull
    public TextView view() {
        return this.f34431a;
    }
}
