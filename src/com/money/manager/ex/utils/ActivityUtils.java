/*
 * Copyright (C) 2012-2014 Alessandro Lazzari
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.money.manager.ex.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.Surface;

public class ActivityUtils {

    public static int forceCurrentOrientation(Activity activity) {
        int prevOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
        if (activity != null) {

            prevOrientation = activity.getRequestedOrientation(); // save current position

            if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                if (activity.getWindowManager().getDefaultDisplay().getRotation() == Surface.ROTATION_0 || activity.getWindowManager().getDefaultDisplay().getRotation() == Surface.ROTATION_90) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                }
            } else if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
            }
        }
        return prevOrientation;
    }

    public static void restoreOrientation(Activity activity, int orientation) {
        if (activity != null) {
            activity.setRequestedOrientation(orientation);
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        }
    }
}