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

package com.hippo.android.html;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

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
  public void testColor4() throws Exception {
    Spanned text = Html.fromHtml("<font color=\"#ffffff\">Hello</font>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, ForegroundColorSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof ForegroundColorSpan);
    assertEquals(-1, ((ForegroundColorSpan) spans[0]).getForegroundColor());
  }

  @Test
  public void testTagIns() throws Exception {
    Spanned text = Html.fromHtml("<ins>Hello</ins>", Html.FROM_HTML_MODE_COMPACT);
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, UnderlineSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof UnderlineSpan);
  }

  @Test
  public void testCustomTag() throws Exception {
    Spanned text = Html.fromHtml(
        "<横杠>Hello</横杠>",
        Html.FROM_HTML_MODE_COMPACT,
        null,
        new TestTagHandler("横杠", new StrikethroughSpan())
    );
    assertEquals("Hello", text.toString());
    Object[] spans = text.getSpans(0, 1, StrikethroughSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof StrikethroughSpan);
  }

  @Test
  public void testOverrideTag1() throws Exception {
    Spanned text = Html.fromHtml(
        "<strike>Hello</strike>",
        Html.FROM_HTML_MODE_COMPACT,
        null,
        new TestTagHandler("strike", new UnderlineSpan())
    );
    Object[] spans = text.getSpans(0, 1, UnderlineSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof UnderlineSpan);
  }

  @Test
  public void testOverrideTag2() throws Exception {
    Spanned text = Html.fromHtml(
        "<del>Hello</del>",
        Html.FROM_HTML_MODE_COMPACT,
        null,
        new TestTagHandler("strike", new UnderlineSpan())
    );
    Object[] spans = text.getSpans(0, 1, StrikethroughSpan.class);
    assertEquals(1, spans.length);
    assertTrue(spans[0] instanceof StrikethroughSpan);
  }

  private static class TestTagHandler implements Html.TagHandler {

    private String tag;
    private Object span;

    public TestTagHandler(String tag, Object span) {
      this.tag = tag;
      this.span = span;
    }

    @Override
    public boolean handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader,
        Attributes attributes) {
      if (this.tag.equalsIgnoreCase(tag)) {
        if (opening) {
          start(output, new PlaceHolder());
        } else {
          end(output, PlaceHolder.class, span);
        }
        return true;
      } else {
        return false;
      }
    }

    private static void start(Editable text, Object mark) {
      int len = text.length();
      text.setSpan(mark, len, len, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    private static void end(Editable text, Class kind, Object repl) {
      int len = text.length();
      Object obj = getLast(text, kind);
      if (obj != null) {
        setSpanFromMark(text, obj, repl);
      }
    }

    private static <T> T getLast(Spanned text, Class<T> kind) {
        /*
         * This knows that the last returned object from getSpans()
         * will be the most recently added.
         */
      T[] objs = text.getSpans(0, text.length(), kind);

      if (objs.length == 0) {
        return null;
      } else {
        return objs[objs.length - 1];
      }
    }

    private static void setSpanFromMark(Spannable text, Object mark, Object... spans) {
      int where = text.getSpanStart(mark);
      text.removeSpan(mark);
      int len = text.length();
      if (where != len) {
        for (Object span : spans) {
          text.setSpan(span, where, len, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
      }
    }

    private static class PlaceHolder {}
  }
}
