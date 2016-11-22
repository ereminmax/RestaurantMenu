package com.maxeremin;

import com.maxeremin.view.View;

/*<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<configuration>
<source>1.8</source>
<target>1.8</target>
</configuration>
</plugin>*/
class Main {

    public static void main(String ... arg) {

        View view = View.getInstance();
        view.execute();

    }

}