package com.google.firebase.firestore.ktx;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.util.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Firestore.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.firebase.firestore.ktx.FirestoreKt$snapshots$1", f = "Firestore.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FirestoreKt$snapshots$1 extends SuspendLambda implements Function2<ProducerScope<? super DocumentSnapshot>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MetadataChanges $metadataChanges;
    final /* synthetic */ DocumentReference $this_snapshots;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirestoreKt$snapshots$1(DocumentReference documentReference, MetadataChanges metadataChanges, Continuation<? super FirestoreKt$snapshots$1> continuation) {
        super(2, continuation);
        this.$this_snapshots = documentReference;
        this.$metadataChanges = metadataChanges;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, DocumentSnapshot documentSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            CoroutineScopeKt.cancel(producerScope, "Error getting DocumentReference snapshot", firebaseFirestoreException);
        } else if (documentSnapshot != null) {
            ChannelsKt.trySendBlocking(producerScope, documentSnapshot);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FirestoreKt$snapshots$1 firestoreKt$snapshots$1 = new FirestoreKt$snapshots$1(this.$this_snapshots, this.$metadataChanges, continuation);
        firestoreKt$snapshots$1.L$0 = obj;
        return firestoreKt$snapshots$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final ListenerRegistration addSnapshotListener = this.$this_snapshots.addSnapshotListener(Executors.BACKGROUND_EXECUTOR, this.$metadataChanges, new EventListener() { // from class: com.google.firebase.firestore.ktx.a
                @Override // com.google.firebase.firestore.EventListener
                public final void onEvent(Object obj2, FirebaseFirestoreException firebaseFirestoreException) {
                    FirestoreKt$snapshots$1.b(ProducerScope.this, (DocumentSnapshot) obj2, firebaseFirestoreException);
                }
            });
            Intrinsics.checkNotNullExpressionValue(addSnapshotListener, "addSnapshotListener(BACK…apshot)\n        }\n      }");
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.google.firebase.firestore.ktx.FirestoreKt$snapshots$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ListenerRegistration.this.remove();
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull ProducerScope<? super DocumentSnapshot> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FirestoreKt$snapshots$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
