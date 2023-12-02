package com.firebase.ui.auth.util.data;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: classes3.dex */
public class TaskFailureLogger implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private String f18227a;

    /* renamed from: b  reason: collision with root package name */
    private String f18228b;

    public TaskFailureLogger(@NonNull String str, @NonNull String str2) {
        this.f18227a = str;
        this.f18228b = str2;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(@NonNull Exception exc) {
        Log.w(this.f18227a, this.f18228b, exc);
    }
}
