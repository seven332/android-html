/*
 * Copyright 2017 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.html;

/*
 * Created by Hippo on 2/8/2017.
 */

import android.app.Application;
import android.content.res.Resources;
import android.text.Layout;
import android.util.Log;
import java.lang.reflect.Method;

class Reflections {

  private static final String LOG_TAG = Reflections.class.getSimpleName();

  private static final Method METHOD_ACTIVITY_THREAD_CURRENT_APPLICATION;
  private static final Method METHOD_ANDROID_BIDI_BIDI;

  public static final int UNKNOWN_DRAWABLE_RES_ID;

  static {
    Method methodActivityThreadCurrentApplication;
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      methodActivityThreadCurrentApplication = clazz.getMethod("currentApplication");
    } catch (Throwable e) {
      Log.e(LOG_TAG, "Can't find android.app.ActivityThread.currentApplication()", e);
      methodActivityThreadCurrentApplication = null;
    }
    METHOD_ACTIVITY_THREAD_CURRENT_APPLICATION = methodActivityThreadCurrentApplication;

    Method methodAndroidBidiBidi;
    try {
      Class<?> clazz = Class.forName("android.text.AndroidBidi");
      methodAndroidBidiBidi = clazz.getMethod("bidi",
          int.class, char[].class, byte[].class, int.class, boolean.class);
    } catch (Throwable e) {
      Log.e(LOG_TAG, "Can't find android.text.AndroidBidi.bidi()", e);
      methodAndroidBidiBidi = null;
    }
    METHOD_ANDROID_BIDI_BIDI = methodAndroidBidiBidi;

    int unknownDrawableResId = Resources.getSystem().getIdentifier("unknown_image", "drawable", "android");
    if (unknownDrawableResId == 0) {
      // Can't get unknown_image id, choose another drawable
      unknownDrawableResId = android.R.drawable.ic_menu_gallery;
    }
    UNKNOWN_DRAWABLE_RES_ID = unknownDrawableResId;
  }

  public static Application currentApplication() {
    try {
      return (Application) METHOD_ACTIVITY_THREAD_CURRENT_APPLICATION.invoke(null);
    } catch (Throwable e) {
      Log.e(LOG_TAG, "Can't invoke android.app.ActivityThread.currentApplication()", e);
      return null;
    }
  }

  public static int bidi(int dir, char[] chs, byte[] chInfo, int n, boolean haveInfo) {
    try {
      return (Integer) METHOD_ANDROID_BIDI_BIDI.invoke(null, dir, chs, chInfo, n, haveInfo);
    } catch (Throwable e) {
      Log.e(LOG_TAG, "Can't invoke android.text.AndroidBidi.bidi()", e);
      return Layout.DIR_LEFT_TO_RIGHT;
    }
  }
}
