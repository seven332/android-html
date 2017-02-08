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

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.graphics.Color;
import android.os.Build;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.N_MR1)
@RunWith(RobolectricTestRunner.class)
public class HtmlTest {

  @Test
  public void testColor1() throws Exception {
    Spanned text = Html.fromHtml("<font color=\"moccasin\">Hello</font>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, ForegroundColorSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof ForegroundColorSpan);
    assertEquals(0xFFFFE4B5, ((ForegroundColorSpan) spans[0]).getForegroundColor());
  }

  @Test
  public void testColor2() throws Exception {
    Spanned text = Html.fromHtml("<font color=\"rgb(255,0,0)\">Hello</font>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, ForegroundColorSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof ForegroundColorSpan);
    assertEquals(Color.RED, ((ForegroundColorSpan) spans[0]).getForegroundColor());
  }

  @Test
  public void testColor3() throws Exception {
    Spanned text = Html.fromHtml("<font color=\"#0000ff\">Hello</font>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, ForegroundColorSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof ForegroundColorSpan);
    assertEquals(Color.BLUE, ((ForegroundColorSpan) spans[0]).getForegroundColor());
  }

  @Test
  public void testTagIns() throws Exception {
    Spanned text = Html.fromHtml("<ins>Hello</ins>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, UnderlineSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof UnderlineSpan);
  }
}
