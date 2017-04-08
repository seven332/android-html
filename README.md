# android-html

[![Release](https://jitpack.io/v/seven332/android-html.svg)](https://jitpack.io/#seven332/android-html)

android-html 是基于 `android.text.Html`。

The android-html is forked from `android.text.Html`.

区别有：
* 支持 \<ins\> 标签
* 支持所有 css 颜色名称与格式
* 允许 `TagHandler` 重载默认标签解析

The differences:
* Support \<ins\> tag
* Support all css color names and formats
* Allow `TagHandler` overriding default tag parser

## Installation

```
repositories {
    maven { url 'https://jitpack.io' }
}

compile 'com.github.seven332:android-html:{version}'
```

## License

```
Copyright 2017 Hippo Seven

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
