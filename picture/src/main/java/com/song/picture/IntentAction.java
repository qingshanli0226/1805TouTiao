package com.song.picture;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import io.reactivex.annotations.NonNull;

public class IntentAction {

    public static void send(@NonNull Context context, @NonNull String shareText) {
        Intent shareIntent = new Intent()
                .setAction(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, shareText);
        context.startActivity(Intent.createChooser(shareIntent, "分享"));
    }

    public static void sendImage(@NonNull Context context, @NonNull Uri uri) {
        Intent shareIntent = new Intent()
                .setAction(Intent.ACTION_SEND)
                .setType("image/*")
                .putExtra(Intent.EXTRA_STREAM, uri);
        context.startActivity(Intent.createChooser(shareIntent, "分享"));
    }
}
