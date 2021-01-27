package com.toutiao.bawei.a1805toutiao.customview;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.toutiao.bawei.a1805toutiao.R;

public class MoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        final MoveVie moveVie = findViewById(R.id.moveView);
        moveVie.registerMoveListener(new MoveVie.IMoveListnener() {
            @Override
            public void onMove(int dx, int dy) {
                //moveVie.scrollBy(-dx,-dy);
                moveVie.layout(moveVie.getLeft()+dx,moveVie.getTop()+dy,moveVie.getRight()+dx,moveVie.getBottom()+dy);
            }
        });
    }
}
