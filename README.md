# Cream Cheese

## Settings

in Xenon click to add a Market. this will create a stub market. you will want to edit your config file to finish fleshing it out. Mine is at

```
~/.config/xenon/settings/program/update/settings.properties
```

add a url there of something Xenon can find. the Url will be your Market Url

## Market

Market urls could be something like `https://localhost:3000` in which case you will need to serve up a json Catalog on `/catalog`

The catalog lists your products, whose name will be worked into other urls
> 
```
{"timestamp":"1565300363166","products":["creamcheese"]}

```

so with creamcheese, and xenon on Mac, i also need to serve json from this endpoint:

```
http://localhost:3000/creamcheese/macosx/product/card
```

here is an example of the product card

```
{
  "group": "com.danlangford",
  "artifact": "creamcheese",
  "version": "0.1-SNAPSHOT",
  "timestamp": "2019-08-08 21:02:04",
  "iconUri": "https://res.cloudinary.com/hksqkdlah/image/upload/ar_1:1,c_fill,dpr_3.0,f_auto,q_auto:low,w_400/34505_sil-creamcheese-philadelphia-1",
  "name": "Cream Cheese",
  "provider": "DanLangford",
  "providerUrl": "http://www.danlangford.com",
  "inception": "2017",
  "summary": "more delicious food",
  "description": "you need bagels firsts",
  "copyrightSummary": "All rights reserved.",
  "licenseSummary": "creamcheese comes with ABSOLUTELY NO WARRANTY. This is open software, and you are welcome to redistribute it under certain conditions.",
  "productUri": "https://www.danlangford.com/",
  "mainClass": "com.danlangford.creamcheese.Program",
  "javaVersion": "11",
  "maintainers": [
  {
    "name": "Dan Langford",
    "email": "danlangford@gmail.com",
    "timezone": null,
    "organization": "Dan Langford",
    "organizationUrl": "http://www.danlangford.com",
    "roles": [ "Architect", "Developer" ]
  }
  ]
}

```

the last thing you need to know is that the Mod JAR needs to be served on this URL

```
http://localhost:3000/creamcheese/macosx/product/pack
```

## Mod

as you can see from my product card above my java jar will want this class

```java
package com.danlangford.creamcheese;

import com.REDACTED.product.ProductBundle;
import com.REDACTED.xenon.Mod;

public class Program extends Mod {

  @Override
  public ClassLoader getClassLoader() {
    return null;
  }

  @Override
  public ProductBundle getResourceBundle() {
    return null;
  }

  @Override
  public void register() {}

  @Override
  public void startup() {}

  @Override
  public void shutdown() {}

  @Override
  public void unregister() {}

}
```

:memo: TODO: document the registration and startup process
