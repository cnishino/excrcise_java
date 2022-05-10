// 内部クラス
// 内部クラスとは、その名のとおり、クラスの中にあるクラスのことです。

// 内部クラスBの中に、さらに内部クラスCを持つ
public class A {
  public class B {
      public class C {
      }
  }
}

// 内部クラスの使い方
// staticクラスは、クラス外から直接インスタンス化できる
// 非staticクラスは、外部クラスのインスタンスからのみインスタンス化できる
// 非staticな場合のみ内部クラスと呼び、それ以外は「ネストしたクラス」として扱う場合もある

// クラスA、Bを、別のクラスCからインスタンス化
public class Example {
  public static void main(String[] args) {
      Outer outer = new Outer(); // クラスOuterをインスタンス化
      Outer.Inner inner = outer.new Inner(); // クラスOuterの内部クラスInnerをインスタンス化
  }
}

// 内部クラスと外部クラスの関係性

// private なフィールドも内側からであれば参照可
public class Outer {

  // 外部クラスに定義したフィールドgreeting
    private String greeting = "こんにちは";

    public class Inner {

        public String hello() {
      // 内部クラスInnerから、外部クラスOuterのフィールドgreetingを参照
            return greeting;
        }
    }
}

// 内部クラスInnerがstaticな場合は、参照できすにコンパイルエラーとなる
public class Outer {

  // 非staticなフィールドgreeting
    private String greeting = "こんにちは";

  // staticな内部クラスInner
    public static class Inner {

        public String hello() {
      // 外部クラスOuterのフィールドgreetingは非staticなので、コンパイルエラー
            return greeting;
        }
    }

}

// 参照されるフィールドもstaticな場合は、staticな内部クラスからも参照できる
public class Outer {

  // staticなフィールドgreeting
    private static String greeting = "こんにちは";

  // staticな内部クラスInner
    public static class Inner {

        public String hello() {
      // 外部クラスOuterのフィールドgreetingはstaticなので、参照可能
            return greeting;
        }
    }

}

// 内部クラスを使うケース

// 定数クラス
public class Constants {

  public static final String CAT_NAME = "猫";

  public static final int CAT_LEG_COUNT = 4;

  public static final String OCTOPUS_NAME = "タコ";

  public static final int OCTOPUS_LEG_COUNT = 8;

}

// この定数をつかうコードは以下のようになる
System.out.println(Constants.CAT_NAME); // "猫"
System.out.println(Constants.CAT_LEG_COUNT); // 4
System.out.println(Constants.OCTOPUS_NAME);  // "タコ"
System.out.println(Constants.OCTOPUS_LEG_COUNT);  // 8

// 定数クラスを、内部クラスを使って書き換える
public class Constants {

  //内部クラスCatの中に、猫関係の定数を定義
    public static class Cat {
        public static final String NAME = "猫";
        public static final int LEG_COUNT = 4;
    }

  //内部クラスOctopusの中に、タコ関係の定数を定義
    public static class Octopus {
        public static final String NAME = "タコ";
        public static final int LEG_COUNT = 8;
    }

}
