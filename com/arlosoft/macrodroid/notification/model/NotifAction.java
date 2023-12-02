package com.arlosoft.macrodroid.notification.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NotifAction implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f13014a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13015b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f13016c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f13017d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<RemoteInputParcel> f13018e;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotifAction createFromParcel(Parcel parcel) {
            return new NotifAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotifAction[] newArray(int i4) {
            return new NotifAction[i4];
        }
    }

    public NotifAction(Parcel parcel) {
        ArrayList<RemoteInputParcel> arrayList = new ArrayList<>();
        this.f13018e = arrayList;
        this.f13014a = parcel.readString();
        this.f13015b = parcel.readString();
        this.f13016c = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.f13017d = parcel.readByte() != 0;
        parcel.readTypedList(arrayList, RemoteInputParcel.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.f13015b;
    }

    public PendingIntent getQuickReplyIntent() {
        if (this.f13017d) {
            return this.f13016c;
        }
        return null;
    }

    public ArrayList<RemoteInputParcel> getRemoteInputs() {
        return this.f13018e;
    }

    public String getText() {
        return this.f13014a;
    }

    public boolean isQuickReply() {
        return this.f13017d;
    }

    public void sendReply(Context context, String str) throws PendingIntent.CanceledException {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        Iterator<RemoteInputParcel> it = this.f13018e.iterator();
        while (it.hasNext()) {
            RemoteInputParcel next = it.next();
            bundle.putCharSequence(next.getResultKey(), str);
            RemoteInput.Builder builder = new RemoteInput.Builder(next.getResultKey());
            builder.setLabel(next.getLabel());
            builder.setChoices(next.getChoices());
            builder.setAllowFreeFormInput(next.isAllowFreeFormInput());
            builder.addExtras(next.getExtras());
            arrayList.add(builder.build());
        }
        RemoteInput.addResultsToIntent((RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]), intent, bundle);
        this.f13016c.send(context, 0, intent);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f13014a);
        parcel.writeString(this.f13015b);
        parcel.writeParcelable(this.f13016c, i4);
        parcel.writeByte(this.f13017d ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f13018e);
    }

    public NotifAction(String str, String str2, PendingIntent pendingIntent, RemoteInput remoteInput, boolean z3) {
        ArrayList<RemoteInputParcel> arrayList = new ArrayList<>();
        this.f13018e = arrayList;
        this.f13014a = str;
        this.f13015b = str2;
        this.f13016c = pendingIntent;
        this.f13017d = z3;
        arrayList.add(new RemoteInputParcel(remoteInput));
    }

    public NotifAction(NotificationCompat.Action action, String str, boolean z3) {
        this.f13018e = new ArrayList<>();
        this.f13014a = action.title.toString();
        this.f13015b = str;
        this.f13016c = action.actionIntent;
        if (action.getRemoteInputs() != null) {
            int length = action.getRemoteInputs().length;
            for (int i4 = 0; i4 < length; i4++) {
                this.f13018e.add(new RemoteInputParcel(action.getRemoteInputs()[i4]));
            }
        }
        this.f13017d = z3;
    }
}
