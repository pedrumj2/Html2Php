# Html2Php
A jetbrain plugin to convert the header section of an html file into a PHP include file

1. Add a config file inside the target project under /src/resources  
2. Add the following lines:
    - html2php.source: <relative path from project root to source html file>
    - html2php.dest: <relative path from project root to output file>  
3. The plugin will appear under the tools menu named "Convert"   
    
The plugin will search for all lines that include external css and javascript files:
```html
 <script src="path/somescript.js"></script>  
  <script src="path2/somescript2.js"></script>  
 <link rel="stylesheet" type="text/css" href="path3/somestyle.css"></link>
```
and will convert it to
```php
 <?
  wp_enqueue_script( 'somescript.js"', get_template_directory_uri() . 'path/somescript.js', array()); 
  wp_enqueue_script( 'somescript2.js"', get_template_directory_uri() . 'path2/somescript2.js', array('somescript.js'));
  wp_enqueue_style( 'somestyle.js"', get_template_directory_uri() . 'path3/somestyle.js', array());
```

