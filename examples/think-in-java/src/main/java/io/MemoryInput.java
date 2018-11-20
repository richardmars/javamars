package io;//: io/MemoryInput.java
import java.io.*;

// 在ide中，java命令的执行山下文是在项目的根目录下，故只能读取其下的文件
public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
    StringReader in = new StringReader(
      BufferedInputFile.read("pom.xml"));
    int c;
    while((c = in.read()) != -1)
      System.out.print((char)c);
  }
} /* (Execute to see output) *///:~
