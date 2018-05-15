package com.yesfifa.holdinglibrary;

import android.os.Build;
import android.view.View;

import com.yesfifa.holdinglibrary.HoldingButtonLayout.Direction;
import com.yesfifa.holdinglibrary.HoldingButtonLayout.LayoutDirection;

final class DirectionHelper {

    static LayoutDirection resolveLayoutDirection(HoldingButtonLayout view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return LayoutDirection.RTL;
        }

        int rawDirection = view.getResources().getConfiguration().getLayoutDirection();
        if (rawDirection == View.LAYOUT_DIRECTION_RTL) {
            return LayoutDirection.RTL;
        } else {
            return LayoutDirection.LTR;
        }
    }

    static Direction resolveDefaultSlidingDirection(HoldingButtonLayout view) {
        if (resolveLayoutDirection(view) == LayoutDirection.RTL) {
            return Direction.START;
        } else {
            return Direction.END;
        }
    }

    static Direction adaptSlidingDirection(HoldingButtonLayout view, Direction direction) {
        if (resolveLayoutDirection(view) == LayoutDirection.RTL) {
            return direction;
        } else {
            return direction.toRtl();
        }
    }
}
