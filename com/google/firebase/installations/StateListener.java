package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes5.dex */
interface StateListener {
    boolean a(PersistedInstallationEntry persistedInstallationEntry);

    boolean onException(Exception exc);
}
