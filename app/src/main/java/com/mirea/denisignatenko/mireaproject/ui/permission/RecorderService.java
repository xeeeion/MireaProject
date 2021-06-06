package com.mirea.denisignatenko.mireaproject.ui.permission;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

import static com.mirea.denisignatenko.mireaproject.ui.permission.PermissionFragment.fileName;

public class RecorderService extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        try {
            player = new MediaPlayer();

        } catch (Exception e) {
            e.printStackTrace();
        }
        player.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            player.setDataSource(fileName);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.start();
        return START_STICKY;
    }

    private void releasePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    public void onDestroy() {
        player.stop();
    }
}