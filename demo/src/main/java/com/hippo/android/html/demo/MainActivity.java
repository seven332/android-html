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

package com.hippo.android.html.demo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.hippo.android.html.Html;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;

public class MainActivity extends Activity {

  private static final String P = "<p>初，郑武公娶于申，曰武姜，生庄公及共叔段。庄公寤生，惊姜氏，故名曰寤生，遂恶之。爱共叔段，欲立之，亟请于武公，公弗许。</p>"
      + "<p>及庄公即位，为之请制。公曰：“制，岩邑也。虢叔死焉，佗邑唯命。”请京，使居之，谓之京城大叔。</p>"
      + "<p>祭仲曰：“都城过百雉，国之害也。先王之制：大都，不过参国之一；中，五之一；小，九之一。今京不度，非制也，君将不堪。”公曰：“姜氏欲之，焉辟害？”对曰：“姜氏何厌之有？不如早为之所，无使滋蔓！蔓，难图也。蔓草犹不可除，况君之宠弟乎？”公曰：“多行不义，必自毙，子姑待之！”</p>"
      + "<p>既而大叔命西鄙、北鄙贰于己。公子吕曰：“国不堪贰，君将若之何？欲与大叔，臣请事之；若弗与，则请除之，无生民心。”公曰：“无庸，将自及。”</p>"
      + "<p>大叔又收贰以为己邑，至于廪延。子封曰：“可矣！厚将得众。”公曰：“不义不昵，厚将崩。”</p>"
      + "<p>大叔完聚，缮甲兵，具卒乘，将袭郑，夫人将启之。公闻其期曰：“可矣。”命子封帅车二百乘以伐京，京叛大叔段。段入于鄢，公伐诸鄢。五月辛丑，大叔出奔共。</p>"
      + "<p>书曰：“郑伯克段于鄢。”段不弟，故不言弟。如二君，故曰克。称郑伯，讥失教之。谓之郑志。不言出奔，难之也。</p>"
      + "<p>遂寘姜氏于城颍，而誓之曰：“不及黄泉，无相见也。”既而悔之。颍考叔为颍谷封人，闻之。有献于公，公赐之食。食舍肉，公问之。对曰：“小人有母，皆尝小人之食矣。未尝君之羹，请以遗之。”公曰：“尔有母遗，繄我独无！”颍考叔曰：“敢问何谓也？”公语之故，且告之悔。对曰：“君何患焉。若阙地及泉，隧而相见，其谁曰不然？”公从之。</p>"
      + "<p>公入而赋：“大隧之中，其乐也融融。”姜出而赋：“大隧之外，其乐也泄泄！”遂为母子如初。</p>"
      + "<p>君子曰：“颍考叔，纯孝也，爱其母，施及庄公。《诗》曰：‘孝子不匮，永锡尔类’，其是之谓乎？”</p>"
      + "<img src=\"unknown\">"
      + "<ins>underline</ins>"
      + "<横杠>StrikeThrough</横杠>"
      + "<b>Italic</b>";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView text = (TextView) findViewById(R.id.text);
    text.setText(Html.fromHtml(P, Html.FROM_HTML_MODE_LEGACY, null, new TestTagHandler()));
  }

  private static class TestTagHandler implements Html.TagHandler {

    @Override
    public boolean handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader,
        Attributes attributes) {
      if ("横杠".equalsIgnoreCase(tag)) {
        if (opening) {
          start(output, new StrikeThrough());
        } else {
          end(output, StrikeThrough.class, new StrikethroughSpan());
        }
        return true;
      } else if ("b".equalsIgnoreCase(tag)) {
        if (opening) {
          start(output, new Italic());
        } else {
          end(output, Italic.class, new StyleSpan(Typeface.ITALIC));
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

    private static class StrikeThrough {}
    private static class Italic {}
  }
}
