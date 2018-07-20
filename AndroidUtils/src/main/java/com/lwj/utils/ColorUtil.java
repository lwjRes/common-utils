package com.lwj.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import java.util.ArrayList;

/**
 * Created by lwj on 2018/7/5.
 * lwjfork@gmail.com
 */

public class ColorUtil {


    public static int praseColor(String color) {
        return Color.parseColor(color);
    }

    /**
     * 从colors.xml中读取color
     *
     * @param resId color id
     * @return color
     */
    public static int getColor(@ColorRes int resId) {
        return ResUtil.getColor(resId);
    }

    /**
     * create Drawable by color
     *
     * @param resId color id
     * @return Drawable
     */
    public static Drawable getColorDrawable(@ColorRes int resId) {
        return ResUtil.getColorDrawable(resId);
    }


    /**
     * 从colors.xml中读取color
     *
     * @param resId color id
     * @return color
     */
    public static ColorStateList getColorStateList(@ColorRes int resId) {
        return ResUtil.getColorStateList(resId);
    }


    public static ColorStateListBuilder getColorStateListBuilder() {
        return new ColorStateListBuilder();
    }

    public static class ColorStateListBuilder {

        private ArrayList<int[]> state = new ArrayList<>();
        private ArrayList<Integer> color = new ArrayList<>();


        private ColorStateListBuilder() {

        }

        public ColorStateListBuilder addColorState(@ColorInt int colorInt, int... stateSet) {
            state.add(stateSet);
            color.add(colorInt);
            return this;
        }


        public ColorStateListBuilder addColorResState(@ColorRes int resId, int... stateSet) {
            return addColorState(ResUtil.getColor(resId), stateSet);
        }


        public ColorStateList buildColor() {

            int num = state.size();
            int[][] states = new int[num][];
            int[] colors = new int[num];
            for (int i = 0; i < num; i++) {
                states[i] = state.get(i);
                colors[i] = color.get(i);
            }
            return new ColorStateList(states, colors);
        }
    }


}
