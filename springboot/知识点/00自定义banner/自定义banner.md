banner就是启动时的图标

可以在这几个网址自己定义banner

- <http://patorjk.com/software/taag>
- <http://www.network-science.de/ascii/>
- <http://www.degraeve.com/img2txt.php>



在resources下新建一个banner.txt文件，我放了下面的内容

```
${AnsiColor.BRIGHT_RED}
${AnsiBackground.BRIGHT_YELLOW}

                                                     
                                                     
                      .                              
                    .'|                              
                   <  |                              
   ____     _____   | |            ____     _____    
  `.   \  .'    /   | | .'''-.    `.   \  .'    /    
    `.  `'    .'    | |/.'''. \     `.  `'    .'     
      '.    .'      |  /    | |       '.    .'       
      .'     `.     | |     | |       .'     `.      
    .'  .'`.   `.   | |     | |     .'  .'`.   `.    
  .'   /    `.   `. | '.    | '.  .'   /    `.   `.  
 '----'       '----''---'   '---''----'       '----' 
```



 启动时样式

![banner](img/banner.png)

${AnsiColor.BRIGHT_RED} 设置字的颜色

${AnsiBackground.BRIGHT_YELLOW}设置背景色

可以看一下类里定义的其他的东西

```java
/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.ansi;

/**
 * {@link AnsiElement Ansi} colors.
 *
 * @author Phillip Webb
 * @author Geoffrey Chandler
 * @since 1.3.0
 */
public enum AnsiColor implements AnsiElement {

	DEFAULT("39"),

	BLACK("30"),

	RED("31"),

	GREEN("32"),

	YELLOW("33"),

	BLUE("34"),

	MAGENTA("35"),

	CYAN("36"),

	WHITE("37"),

	BRIGHT_BLACK("90"),

	BRIGHT_RED("91"),

	BRIGHT_GREEN("92"),

	BRIGHT_YELLOW("93"),

	BRIGHT_BLUE("94"),

	BRIGHT_MAGENTA("95"),

	BRIGHT_CYAN("96"),

	BRIGHT_WHITE("97");

	private final String code;

	AnsiColor(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}

}
```



```java
/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.ansi;

/**
 * {@link AnsiElement Ansi} background colors.
 *
 * @author Phillip Webb
 * @author Geoffrey Chandler
 * @since 1.3.0
 */
public enum AnsiBackground implements AnsiElement {

	DEFAULT("49"),

	BLACK("40"),

	RED("41"),

	GREEN("42"),

	YELLOW("43"),

	BLUE("44"),

	MAGENTA("45"),

	CYAN("46"),

	WHITE("47"),

	BRIGHT_BLACK("100"),

	BRIGHT_RED("101"),

	BRIGHT_GREEN("102"),

	BRIGHT_YELLOW("103"),

	BRIGHT_BLUE("104"),

	BRIGHT_MAGENTA("105"),

	BRIGHT_CYAN("106"),

	BRIGHT_WHITE("107");

	private String code;

	AnsiBackground(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}

}
```

若想关闭掉banner，在启动类中修改如下图所示

```java
package com.xhx.springboot.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
//          SpringApplication.run(BannerApplication.class, args);
        SpringApplication app = new SpringApplication(BannerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }
}
```

