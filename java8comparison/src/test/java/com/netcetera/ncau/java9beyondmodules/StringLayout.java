package com.netcetera.ncau.java9beyondmodules;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.FieldLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

/**
 * Demonstrates string layout changes in Java 9.
 *
 * <p>This class can be run with</p>
 * <pre><code>sudo $JAVA_HOME/bin/java \
 * -XX:-CompactStrings \
 * --add-opens java.base/java.lang=ALL-UNNAMED -Djdk.attach.allowAttachSelf \
 * -cp target/ncau-java9-beyond-modules-1.0.0-SNAPSHOT-jar-with-test-dependencies.jar \
 * com.netcetera.ncau.java9beyondmodules.StringLayout
 * </pre></code>
 *
 * @see <a href="http://openjdk.java.net/jeps/254">JEP 254</a>
 */
public class StringLayout {

  /**
   * Main method, examines {@literal "hello world"}.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    System.out.println(VM.current().details());

    ClassLayout classLayout = ClassLayout.parseInstance("hello world");
    System.out.println(classLayout.toPrintable());

    Class<?> arrayClass = classLayout.fields().stream()
      .filter(StringLayout::isArray)
      .map(FieldLayout::typeClass)
      .map(StringLayout::toJniType)
      .map(StringLayout::forName)
      .findFirst()
      .get();

    classLayout = ClassLayout.parseClass(arrayClass);
    System.out.println(classLayout.toPrintable());

    if (arrayClass == char[].class) {
      classLayout = ClassLayout.parseInstance("hello world".toCharArray());
      System.out.println(classLayout.toPrintable());
    }

    if (arrayClass == byte[].class) {
      classLayout = ClassLayout.parseInstance("hello world".getBytes(ISO_8859_1));
      System.out.println(classLayout.toPrintable());
    }

    GraphLayout graphLayout = GraphLayout.parseInstance("hello world");
    System.out.println(graphLayout.toPrintable());

    graphLayout = GraphLayout.parseInstance("h€llo world");
    System.out.println(graphLayout.toPrintable());
  }

  private static boolean isArray(FieldLayout fieldLayout) {
    return fieldLayout.typeClass().endsWith("[]");
  }

  private static String toJniType(String className) {
    String componentType = className.substring(0, className.length() - 2);
    String jniComponentType;
    switch (componentType) {
      case "boolean":
        jniComponentType = "Z";
        break;
      case "byte":
        jniComponentType = "B";
        break;
      case "char":
        jniComponentType = "C";
        break;
      case "short":
        jniComponentType = "S";
        break;
      case "int":
        jniComponentType = "I";
        break;
      case "long":
        jniComponentType = "J";
        break;
      case "float":
        jniComponentType = "F";
        break;
      case "double":
        jniComponentType = "D";
        break;
      default:
        jniComponentType = 'L' + componentType + ';';
        break;
    }
    return '[' + jniComponentType;
  }

  private static Class<?> forName(String className) {
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("not a class name: " + className, null);
    }
  }

}
