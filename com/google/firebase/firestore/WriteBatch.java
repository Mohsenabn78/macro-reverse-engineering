package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes5.dex */
public class WriteBatch {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f30245a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Mutation> f30246b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f30247c = false;

    /* loaded from: classes5.dex */
    public interface Function {
        void apply(@NonNull WriteBatch writeBatch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteBatch(FirebaseFirestore firebaseFirestore) {
        this.f30245a = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    private WriteBatch a(@NonNull DocumentReference documentReference, @NonNull UserData.ParsedUpdateData parsedUpdateData) {
        this.f30245a.v(documentReference);
        b();
        this.f30246b.add(parsedUpdateData.toMutation(documentReference.g(), Precondition.exists(true)));
        return this;
    }

    private void b() {
        if (!this.f30247c) {
            return;
        }
        throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
    }

    @NonNull
    public Task<Void> commit() {
        b();
        this.f30247c = true;
        if (this.f30246b.size() > 0) {
            return this.f30245a.i().write(this.f30246b);
        }
        return Tasks.forResult(null);
    }

    @NonNull
    public WriteBatch delete(@NonNull DocumentReference documentReference) {
        this.f30245a.v(documentReference);
        b();
        this.f30246b.add(new DeleteMutation(documentReference.g(), Precondition.NONE));
        return this;
    }

    @NonNull
    public WriteBatch set(@NonNull DocumentReference documentReference, @NonNull Object obj) {
        return set(documentReference, obj, SetOptions.f30229c);
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull Map<String, Object> map) {
        return a(documentReference, this.f30245a.l().parseUpdateData(map));
    }

    @NonNull
    public WriteBatch set(@NonNull DocumentReference documentReference, @NonNull Object obj, @NonNull SetOptions setOptions) {
        UserData.ParsedSetData parseSetData;
        this.f30245a.v(documentReference);
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        Preconditions.checkNotNull(setOptions, "Provided options must not be null.");
        b();
        if (setOptions.a()) {
            parseSetData = this.f30245a.l().parseMergeData(obj, setOptions.getFieldMask());
        } else {
            parseSetData = this.f30245a.l().parseSetData(obj);
        }
        this.f30246b.add(parseSetData.toMutation(documentReference.g(), Precondition.NONE));
        return this;
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull String str, @Nullable Object obj, Object... objArr) {
        return a(documentReference, this.f30245a.l().parseUpdateData(Util.collectUpdateArguments(1, str, obj, objArr)));
    }

    @NonNull
    public WriteBatch update(@NonNull DocumentReference documentReference, @NonNull FieldPath fieldPath, @Nullable Object obj, Object... objArr) {
        return a(documentReference, this.f30245a.l().parseUpdateData(Util.collectUpdateArguments(1, fieldPath, obj, objArr)));
    }
}
